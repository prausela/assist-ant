<template>
	<div class="card" @click="pressedCard">
		<div class="icon-container">
			<img class="oven-img" src="@/assets/devices/oven.png">
		</div>
		<div v-if="verDevice" class="device">
			<Oven :device="device" @closeMe="closeMe" />
		</div>
		<div class="name">{{device.name}}</div>
	</div>
</template>

<script>
import Oven from "@/components/devices/Oven.vue"

export default {
	components:{
		Oven
	},

	name: 'OvenCard',
	props: {
		device: {
			required: true	
		}
	},

	data () {
		return {
			verDevice: false,
			name: 'Horno'
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
	align-items: center
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


.name
	text-align: center
	margin: 5px 0px


.oven-img
	display: flex
	width: 32px
	height: 32px
</style>