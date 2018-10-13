<template>
	<div class="card" @click="pressedCard">
		<div class="icon-container">
			<v-icon name="lightbulb" class="card-icon" scale="2" />
		</div>
		<div v-if="verDevice" class="device">
			<Lightbulb :device="device" @closeMe="closeMe" />
		</div>
		<div class="card-name">{{device.name}}</div>
	</div>
</template>


<script>
import Lightbulb from "@/components/devices/Lightbulb.vue"

export default {
	components:{
		Lightbulb
	},

	name: 'LightCard',
	props: {
		device: {
			required: true	
		},
		openModals: {
			required: false,
			default: true
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
			this.verDevice = false

		}
	}
}
</script>

<style lang="sass" scoped>



</style>