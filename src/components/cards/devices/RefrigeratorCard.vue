<template>
	<div class="device-card" @click="pressedCard">
		<div class="icon-container">
			<img class="refri-img" src="@/assets/devices/refrigerator.png">
		</div>
		<div v-if="verDevice" class="device">
			<Refrigerator :device="device" @closeMe="closeMe" />
		</div>
		<div class="card-name">{{device.name}}</div>
	</div>
</template>


<script>
import Refrigerator from "@/components/devices/Refrigerator.vue"

export default {
	components:{
		Refrigerator
	},

	name: 'RefrigeratorCard',
	props: {
		device: {
			required: true	
		}
	},
	data () {
		return {
			verDevice: false,
			name: 'Heladera'
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



.refri-img
	display: flex
	width: 20px
	height: 50px

</style>