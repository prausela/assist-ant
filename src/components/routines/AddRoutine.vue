<template>
		<div class="modal" @click.stop="closeModal">
		<div class="modal-inner" @click.stop>
			<div class="modal-header">
				Agregar Rutina
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
				</div>
				<div class="form-row">
					Dispositivos
				</div>
				<div class="routine-devices">
					<DevicesList @devicesChanged="updateDevices" :routine="routine" :add="true" :devices="devices" />
				</div>
			</div>
			<div class="modal-footer">
		 		<a @click="submit" class="button is-primary">Agregar</a>
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
    	name: this.currRoutine.name || "",
    	routine: null,
    	devices: []
    }
  },
  mounted() {
		if (this.currRoutine) {
			this.routine = this.currRoutine
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
		  				this.$toaster.success(this.$strings[this.$language].routines.modify.success)
		  				this.closeModal()
		  			}).catch((error) => {
		  				console.log(error)
		  			})

		  		} else {
		  			this.$api.routines.modify(this.routine).then(() => {
		  				this.$toaster.success(this.$strings[this.$language].routines.add.success)
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
  	}
  },
  
}
</script>

<style lang="sass" scoped>
.routine-devices
	width: 100%	
	height: 200px
</style>