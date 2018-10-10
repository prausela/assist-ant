<template>
	<div class="card"  @click="verDevice = true">
		<div class="icon-container">
			<v-icon name="plus" class="card-icon" scale="1.5" />
		</div>
		<div v-if="verDevice" class="device">
			<AddDevice @closeMe="verDevice = false" />
		</div>
	</div>
</template>

<script>
import AddDevice from "@/components/devices/AddDevice.vue"

export default {

	name: 'AddDeviceCard',
	components: {
		AddDevice
	},
	props: {
		device: {
			required: false	
		}
	},

	data () {
		return {
			name: 'Agregar',
			verDevice: false
		}
	}
}
</script>

<style lang="sass" scoped>

.card
	display: flex
	justify-content:center
	align-content:center
	position: relative
	flex-direction: column
	width: 30%
	cursor: pointer


.icon-container
	justify-content: center
	align-content: center
	border: 1px solid black
	display: flex
	position: relative
	padding: 5px
	border-radius: 5px

.card-icon
	max-widht: 100%
	object-fit: contain
	height: 100%
	position: relative


.name
	text-align: center
	margin: 5px 0px

</style>