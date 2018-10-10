<template>
	<div class="card" @click="pressedCard">
		<div class="icon-container">
			<v-icon name="stopwatch" class="card-icon" scale="2" />
		</div>
		<div v-if="verDevice" class="device">
			<Timer :device="device" @closeMe="closeMe" />
		</div>
		<div class="name">{{device.name}}</div>
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
	height: 100px
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
	cursor: pointer

	
.name
	text-align: center
	margin: 5px 0px
</style>