<template>
	<div class="device-card"  @click="verDevice = true">
		<div class="add-container icon-container">
			<v-icon name="plus" class="card-icon" scale="1.5" />
		</div>
		<div v-if="verDevice" class="device">
			<AddDevice :room="room" @closeMe="verDevice = false" />
		</div>
	</div>
</template>

<script>
import AddDevice from "@/components/forms/AddDevice.vue"

export default {

	name: 'AddDeviceCard',
	components: {
		AddDevice
	},
	props: {
		device: {
			required: false	
		},
		room: {
			required: false
		}
	},
	data () {
		return {
			name: 'Agregar',
			verDevice: false,
		}
	}
}
</script>

<style lang="sass" scoped>


.name
	text-align: center
	margin: 5px 0px

</style>