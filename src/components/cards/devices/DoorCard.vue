<template>
	<div class="device-card" @click="pressedCard">
		<div class="icon-container">
			<v-icon name="door-closed" class="card-icon" scale="2" />
		</div>
		<div v-if="verDevice" class="device">
			<Door :device="device" @closeMe="closeMe" />
		</div>
		<div class="card-name">{{device.name}}</div>
	</div>
</template>

<script>
import Door from "@/components/devices/Door.vue"

export default {
	components:{
		Door
	},
	name: 'DoorCard',
	props: {
		device: {
			required: true	
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
			this.verDevice = false

		}
	}
}
</script>

<style lang="sass" scoped>


</style>