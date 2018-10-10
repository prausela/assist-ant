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
							<select v-model="selected">
							  <option disabled value=""></option>
							  <option>A</option>
							  <option>B</option>
							  <option>C</option>
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
			 	<div class="submit-btn">Agregar</div>
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
    	selected: null
    }
  },
  methods: {
  	closeModal() {
  		this.$emit('closeMe')
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