<template>
		<div class="modal" @click.stop="closeModal">
		<div class="modal-inner" @click.stop>
			<div v-if="!currRoutine" class="modal-header">
				Agregar Rutina
				<div class="close-modal-btn" @click="closeModal">
					<v-icon name="times-circle"  scale="1" />
				</div>
			</div>
			<div v-if="currRoutine" class="modal-header">
				{{this.name}}
				<div class="close-modal-btn" @click="closeModal">
					<v-icon name="times-circle"  scale="1" />
				</div>
			</div>
			<div class="modal-body">
				<div class="form">
					<div class="form-row">
						<div class="form-label">Nombre</div>
						<div class="form-field">
							<input v-model="name" placeholder="Nombre">
						</div>
					</div>
					<div class="form-row">
						<div class="form-label">Dispositivos</div>

							<div class="routine-devices">
								<DevicesList @devicesChanged="updateDevices" :routine="routine" :add="true" :devices="devices" />
							</div>

						</div>
					</div>
				</div>
				<div class="modal-footer">
					<a @click="submit" class=" button is-primary">{{currRoutine? 'Guardar' : 'Agregar'}}</a>
					<a v-if="currRoutine" @click="remove" class=" button is-primary">Eliminar</a>
				</div>

			</div>
		</div>
	</template>

<script>
export default {

  name: 'AddRoutine',
  props: {
  	currRoutine: {
  		default: null,
  		required: false
  	}
  },
  data () {
    return {
    	name: "",
    	routine: null,
    	devices: []
    }
  },
  mounted() {
		if (this.currRoutine) {
			this.routine = this.currRoutine
			this.name = this.currRoutine.name
		} else {
			this.routine = this.$api.routines.createRoutine()
		}
		this.updateDevices()
	},
  methods: {
  	
  	closeModal() {
  		this.$emit("closeMe")
  	},
  	submit() {
  		this.routine.name = this.name
	  		if (this.routine.name && this.routine.actions.length > 0  ) {
	  			if (!this.currRoutine) {
		  			this.$api.routines.add(this.routine).then(() => {
		  				this.$toaster.success(this.$strings[this.$language].routines.add.success)
		  				this.closeModal()
		  			}).catch((error) => {
		  				console.log(error)
		  			})

		  		} else {
		  			this.$api.routines.modify(this.routine).then(() => {
		  				console.log('modifying', this.routine)
		  				this.$toaster.success(this.$strings[this.$language].routines.modify.success)
		  				this.closeModal()
		  			}).catch((error) => {
		  				console.log(error)
		  			})
		  		}
	  		} else {
	  			if (!this.routine.name) {
	  				this.$toaster.error(this.$strings[this.$language].routines.add.unselectedName)
	  			}
	  			if (this.routine.actions.length == 0) {
	  				this.$toaster.error(this.$strings[this.$language].routines.add.unselectedActions)
	  			}
	  		}
  		

  	},
  	updateDevices() {
  		console.log('updating devices')
  		console.log(this.routine)
  		let filteredDevices = this.$devices.filter((dev) => {
	    // console.log(dev.id)
	    let found = false
	    this.routine.actions.forEach((action) => {
	      // console.log(action.deviceId == dev.id)
	      if (action.deviceId == dev.id) { 
	      	found = true
	      }
	  })
	    return found
	})
  		this.devices = filteredDevices
  	},
  	remove(){

  		this.$api.routines.delete(this.routine).then(() => {
  			this.$toaster.success(this.$strings[this.$language].routines.delete.success)
  			this.closeModal()
  		}).catch((error) => {
  			console.log(error)
  			this.$toaster.error(error)
  		})
  	},
  }
}
</script>

<style lang="sass" scoped>
.modal-body
	width: 100%
.form
	width: 100%
	padding: 15px
.form-row
	display: flex
	margin: 10px 0
.form-label
	padding-right: 15px
	width: 150px
	display: flex
	justify-content: flex-end
	align-items: center
.form-field
	flex: 1
	justify-content: flex-start
	display: flex
select
	width: 70%
input
	width: 69%
.submit-btn
	cursor: pointer
	background-color: $logo
	color: black

.button.is-primary
  box-shadow: inset 0 0 9px rgba(0, 0, 0, 0.5)
  background-color: rgb(0, 132, 204)
  font-size: 14px
.button.is-primary:hover
    background-color: #276cda
    border-color: transparent
    color: #fff
.routine-devices
  flex-wrap: wrap
  position: relative
  display: flex
  justify-content: flex-start
  overflow: auto
  flex: 2

.footer-icon
    flex: 1
    justify-content: center
    display: flex
    height: 100%
    align-items: center
    cursor: pointer
</style>