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



.icon-container
	height: 60px

.name
	text-align: center
	margin: 5px 0px

</style>