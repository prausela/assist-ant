<template>
	<div class="device-card"  @click="verDevice = true">
		<div class="add-container icon-container">
			<v-icon name="plus" class="card-icon" scale="1.5" />
		</div>
		<div v-if="!routine && verDevice" class="device">
			<AddDevice :room="room" @closeMe="verDevice = false" />
		</div>
		<div v-if="routine && verDevice" class="device" >
			<AddDeviceToRoutine @devicesChanged="$emit('devicesChanged')" :routine="routine" @closeMe="closeModal" />
		</div>
		<div class="card-name"></div>
	</div>
</template>
s
<script>
import AddDevice from "@/components/forms/AddDevice.vue"
import AddDeviceToRoutine from "@/components/routines/AddDeviceToRoutine.vue"

export default {

	name: 'AddDeviceCard',
	components: {
		AddDevice,
		AddDeviceToRoutine,
	},
	props: {
		device: {
			required: false	
		},
		room: {
			required: false
		},
		routine: {
			required: false,
			default: false
		}
	},
	data () {
		return {
			name: 'Agregar',
			verDevice: false,
			devices: []
		}
	},
	mounted() {
		this.devices = this.$devices
	},
	methods: {
		closeModal() {
			this.verDevice = false
		}
	}
}
</script>

<style lang="sass" scoped>

.add-container
	height: 100px
.name
	text-align: center
	margin: 5px 0px

</style>