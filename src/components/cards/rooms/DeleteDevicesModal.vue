<template>
	<div class="modal" @click.stop="$emit('cancel')">
		<div class="modal-inner" @click.stop>
			<div class="modal-body">
				<div class="close-modal-btn" @click="$emit('cancel')">
                    <v-icon name="times-circle"  scale="1" />
                </div>
				<div>
					Desea tambien eliminar los dispositivos de la habitacion?
				</div>
				<div class="delete-body">
					<a class="button is-success" @click="$emit('confirm')">Si</a>
					<a class="button is-danger" @click="$emit('decline')">No</a>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
export default {

  name: 'DeleteDevicesModal',

  data () {
    return {

    }
  }
}
</script>

<style lang="sass" scoped>
	.modal
		cursor: initial
	.button	
		width: 50px
		margin: 0 10px
		display: flex
		flex-direction: row
	.modal-inner
		padding: 50px 0
		height: 200px
		border-radius: 50px
		width: 350px
	.modal-body
		height: 70%
		display: flex
		flex-direction: column
		justify-content: space-around
	.close-modal-btn
		top: 20px
	.delete-body
		display: flex
		flex-direction: row
	
</style>