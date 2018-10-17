<template>
	<div class="device-card" @click="pressedCard">
		<div class="icon-container">
			<img class="blind-img" src="@/assets/devices/blind.png">
		</div>
		<div v-if="verDevice" class="device">
			<Blind :device="device" @closeMe="closeMe" />
			<RBlind v-if="routine" :device="device" :routine="routine" @closeMe="closeMe" />
		</div>
		<div class="card-name">{{device.name}}</div>
	</div>
</template>

<script>
import Blind from "@/components/devices/Blind.vue"
import RBlind from "@/components/routines/devices/RBlind.vue"
export default {

	name: 'BlindCard',
	components:{
		Blind,
		RBlind
	},
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
			verDevice:false,
			name: 'Persiana'
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


.blind-img
	display: flex
	width: 32px
	height: 32px

</style>