<template>
	<div class="modal" @click.stop="closeModal">
		<div class="modal-inner" @click.stop>
			<div class="modal-header">
				Agregar Dispositivo
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
						<div class="form-label">Tipo de Dispositivo</div>
						<div class="form-field select-field">
							<select v-model="type">
							  <option disabled value=""></option>
							  <option v-for="(type,id) in deviceTypes" :value="type" :key="id" >{{type.label[$language]}}</option>
							</select>
						</div>
					</div>
					<div class="form-row">
						<div class="form-label">Piso</div>
						<div class="form-field select-field">
							<select v-model="selected">
							  <option disabled value=""></option>
							  <option>A</option>
							  <option>B</option>
							  <option>C</option>
							</select>
						</div>
					</div>
					<div class="form-row">
						<div class="form-label">Habitacion</div>
						<div class="form-field select-field">
							<select v-model="selected">
							  <option disabled value=""></option>
							  <option>A</option>
							  <option>B</option>
							  <option>C</option>
							</select>
						</div>
					</div>
				</div>
			</div>
				<div class="modal-footer">
			 		<div @click="submit" class="submit-btn">Agregar</div>
      	</div>
		</div>
	</div>
</template>

<script>
export default {

  name: 'AddDevice',

  data () {
    return {
    	name: "",
    	type: {},
    	selected: null,
    	deviceTypes: {}
    }
  },
  methods: {
  	closeModal() {
  		this.$emit('closeMe')
  	},
  	refreshDeviceTypes() {
  		console.log('test')
  		if (this.$deviceTypes) {
  			this.deviceTypes = this.$deviceTypes
  		} else {
  			this.$refreshDeviceTypes()
  			setTimeout(() => {
  				this.refreshDeviceTypes()
  			}, 2000);	
  		}
  	},
  	submit() {
  		if (this.type.id && this.name) {
  			this.$api.devices.add({
	  			name: this.name,
	  			type: this.type.id,
	  			meta: JSON.stringify({}),
	  		}).then(() => {
	  			this.$toaster.success(this.$strings[this.$language].devices.add.success)
	  			this.closeModal()
	  		}).catch((error) => {
	  			this.$toaster.error(error.message)
	  		})
  		}
  		if (!this.type.id) {
  			this.$toaster.error(this.$strings[this.$language].devices.add.unselectedType)
  		}
  		if (!this.name) {
  			this.$toaster.error(this.$strings[this.$language].devices.add.unselectedName)
  		}
  		
  	}
  },
	mounted() {
		console.log('mounted')

		this.refreshDeviceTypes()
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
</style>