<template>
	<div class="device-card" @click="pressedCard">
		<div class="icon-container">
			<v-icon name="door-closed" class="card-icon" scale="2" />
		</div>
		<div v-if="verDevice" class="device">
			<Door :device="device" @closeMe="closeMe" />
			<RDoor v-if="routine" :device="device" :routine="routine" @closeMe="closeMe" />
		</div>
		<div class="card-name">{{device.name}}</div>
	</div>
</template>

<script>
import Door from "@/components/devices/Door.vue"
import RDoor from "@/components/routines/devices/RDoor.vue"

export default {
	components:{
		Door,
		RDoor
	},
	name: 'DoorCard',
	props: {
		device: {
			required: true	
		},
		openModals: {
			required: false,
			default: true
		},
		routine: {
			required: false,
			default: null
		}
	},

	data () {
		return {
			verDevice: false,
			name: 'Puerta'
		}
	},
	methods:{
		pressedCard(){
			this.verDevice = true
		},
		closeMe(){
			this.$emit('devicesChanged')
			this.verDevice = false

		}
	}
}
</script>

<style lang="sass" scoped>


</style>