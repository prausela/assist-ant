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
					<DevicesList add="true" :devices="[]" />
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

  data () {
    return {
    	name: ""
    }
  },
  methods: {
  	closeModal() {
  		this.$emit("closeMe")
  	},
  	submit() {

  	},

  }
}
</script>

<style lang="sass" scoped>
.routine-devices
	width: 100%	
	height: 200px
</style>