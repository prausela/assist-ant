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

	name: 'LightbulbCard',
	props: {
		device: {
			required: true	
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
					console.log('hola pressed Lcard')

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