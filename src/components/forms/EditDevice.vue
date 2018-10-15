<template>
	<div class="modal" @click.stop="closeModal">
		<div class="modal-inner" @click.stop>
			<div class="modal-header">
				Editar Dispositivo
				<div class="close-modal-btn" @click="closeModal">
					<v-icon name="times-circle"  scale="1" />
				</div>

			</div>
			<div class="modal-body">
				<div class="form">
					<div class="form-row">
						<div class="form-label">Nombre</div>
						<div class="form-field">
							<input v-model="dev.name" >
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
			 	<div @click="save" class="submit-btn">Guardar</div>
            </div>
		</div>
	</div>
</template>

<script>
// import Api from "@/ApiServiceProvider.js"
export default {

	name: 'EditDevice',
	props: [
	'device'
	],

	data () {
		return {
			name: this.device.name,
			selected: null,
			dev: {}
		}
	},
	methods: {
		closeModal() {
			console.log("hola close edit")
			this.$emit('closeEdit')
		},
		save() {
			this.$api.devices.modify(this.dev).then(() => {
	  			this.$toaster.success(this.$strings[this.$language].devices.edit.success)
	  			this.closeModal()
	  		}).catch((error) => {
	  			this.$toaster.error(error.message)
	  		})
		}
	},
	mounted() {
		this.dev = JSON.parse(JSON.stringify(this.device))
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