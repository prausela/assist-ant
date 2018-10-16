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
					<div class="form-row">
						<div class="form-label">Imagen de la habitacion</div>
						<div class="devices-list">
							<div class="icon-container1">
								<v-icon name="bed" class="img1" scale="1.5" />
							</div>
							<div class="icon-container1">
								<v-icon name="couch" class="img1" scale="1.5" />
							</div>
							<div class="icon-container1">
								<img class="img1" src="@/assets/rooms/bathroom.png">
							</div>
							<div class="icon-container1">
								<img class="img1" src="@/assets/rooms/dining-room.png">
							</div>
							<div class="icon-container1">
								<img class="img1"  src="@/assets/rooms/garden.png">
							</div>
							<div class="icon-container1">
								<img  class="img1" src="@/assets/rooms/kitchen.png">
							</div>
							<div class="icon-container1">
								<img  class="img1" src="@/assets/rooms/office.png">
							</div>
							<div class="icon-container1">
								<img  class="img1" src="@/assets/rooms/washing-room.png">
							</div>
							<div class="icon-container1">
								<v-icon name="swimming-pool" class="img1" scale="1.5" />
							</div>


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
  		if (this.name) {
  			this.$api.rooms.add({
	  			name: this.name,
	  			// type: this.type.id,
	  			meta: JSON.stringify({}),
	  		}).then(() => {
	  			this.$toaster.success(this.$strings[this.$language].rooms.add.success)
	  			this.closeModal()
	  		}).catch((error) => {
	  			this.$toaster.error(error.message)
	  		})
  		}
  		// if (!this.type.id) {
  		// 	this.$toaster.error(this.$strings[this.$language].devices.add.unselectedType)
  		// }
  		if (!this.name) {
  			this.$toaster.error(this.$strings[this.$language].rooms.add.unselectedName)
  		}
  	}
  }
}
</script>

<style lang="sass" scoped>
.img1
	display: flex
	width: 50px
	height: 50px


.devices-list
  flex-wrap: wrap
  position: relative
  display: flex
  justify-content: flex-start
  overflow: auto
  flex: 2

.icon-container1

  align-items: center
  display: flex
  position: relative
  border-radius: 5px
  cursor: pointer
  justify-content: center
  margin: 5px
  padding: 5px
  border: 1px solid black
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