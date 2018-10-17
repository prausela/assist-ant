<template>
	<div class="device-card" @click="pressedCard">
		<div class="icon-container">
			<v-icon name="lightbulb" class="card-icon" scale="2" />
		</div>
		<div v-if="verDevice" class="device">
			<Lightbulb v-if="!routine" :device="device" @closeMe="closeMe" />
			<RLightbulb v-if="routine" :device="device" :routine="routine" @closeMe="closeMe" />
		</div>
		<div class="card-name">{{device.name}}</div>
	</div>
</template>


<script>
import Lightbulb from "@/components/devices/Lightbulb.vue"
import RLightbulb from "@/components/routines/devices/RLightbulb.vue"

export default {
	components:{
		Lightbulb,
		RLightbulb
	},

	name: 'LightCard',
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
			name: 'Luz'
		}
	},
	methods:{
		pressedCard(){
			if (this.openModals) {
				this.verDevice = true
			}
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