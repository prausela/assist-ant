<template>
	<div class="card" @click="pressedCard">
		<div class="icon-container">
            <img class="garage-img" src="@/assets/devices/garage.png">
		</div>
		<div v-if="verDevice" class="device">
			<Garage :device="device" @closeMe="closeMe" />
		</div>
		<div class="card-name">{{device.name}}</div>
	</div>
</template>

<script>
import Garage from "@/components/devices/Garage.vue"

export default {

	name: 'GarageCard',
	components:{
		Garage
	},
	props: {
		device: {
			required: true	
		}
	},

	data () {
		return {
			verDevice:false,
			name: 'Garage'
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


.garage-img
	display: flex
	width: 38px
	height: 32px

</style>