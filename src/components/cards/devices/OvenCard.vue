<template>
	<div class="device-card" @click="pressedCard">
		<div class="icon-container">
			<img class="oven-img" src="@/assets/devices/oven.png">
		</div>
		<div v-if="verDevice" class="device">
			<Oven :device="device" @closeMe="closeMe" />
			<ROven v-if="routine" :device="device" :routine="routine" @closeMe="closeMe" />
		</div>
		<div class="card-name">{{device.name}}</div>
	</div>
</template>

<script>
import Oven from "@/components/devices/Oven.vue"
import ROven from "@/components/routines/devices/ROven.vue"
export default {
	components:{
		Oven,
		ROven
	},

	name: 'OvenCard',
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
			name: 'Horno'
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




.oven-img
	display: flex
	width: 32px
	height: 32px
</style>