<template>
	<div class="device-card" @click="pressedCard">
		<div class="icon-container">
			<v-icon name="stopwatch" class="card-icon" scale="2" />
		</div>
		<div v-if="verDevice" class="device">
			<Timer :device="device" @closeMe="closeMe" />
		</div>
		<div class="card-name">{{device.name}}</div>
	</div>
</template>

<script>
import Timer from "@/components/devices/Timer.vue"

export default {
	components:{
		Timer
	},
	name: 'TimerCard',
	props: {
		device: {
			required: true	
		}
	},
	data () {
		return {
			verDevice: false,

			name: 'Temporizador'
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