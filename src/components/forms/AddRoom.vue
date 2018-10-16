<template>
	<div class="modal" @click.stop="closeModal">
		<AddDevice v-if="showAddModal" @closeMe="showAddModal=false"/>
		<div class="modal-inner" @click.stop>
			<div class="modal-header">
				Agregar Habitacion
				<div class="close-modal-btn" @click="closeModal">
					<v-icon name="times-circle"  scale="1" />
				</div>

			</div>
			<div class="modal-body">
				<div class="form">
					<div class="form-row">
						<div class="form-label">Nombre de la Habitacion</div>
						<div class="form-field">
							<input v-model="name" placeholder="Nombre">
						</div>
					</div>
					<div class="form-row">
						<div class="form-label">Tipo de Habitacion</div>
						<div class="form-field select-field">
							<select v-model="type">
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
			 		<div @click="save" class="submit-btn">Agregar</div>
    		</div>
		</div>
	</div>
</template>

<script>
import AddDevice from "./AddDevice.vue"

export default {
	components:{
		AddDevice: AddDevice,
	},
  name: 'AddRoom',

  data () {
    return {
    	devices: [],
    	showAddModal: false,
    	name: "",
    	type: null
    }
  },
  methods: {
  	closeModal() {
  		this.$emit('closeMe')
  	},
  	selectedDevice(){
  		console.log(this.selected)
  		if(this.selected=="add"){
  			this.showAddModal=true
  			this.selected=""
  		}
  	},
  	save() {
  		if (this.type.id && this.name) {
  			this.$api.rooms.add({
	  			name: this.name,
	  			type: this.type.id,
	  			meta: JSON.stringify({}),
	  		}).then(() => {
	  			this.$toaster.success(this.$strings[this.$language].rooms.add.success)
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
	background-color: $logo
	color: black
</style>