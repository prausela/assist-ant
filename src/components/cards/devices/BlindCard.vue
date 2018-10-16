<template>
	<div class="device-card" @click="pressedCard">
		<div class="icon-container">
			<img class="blind-img" src="@/assets/devices/blind.png">
		</div>
		<div v-if="verDevice" class="device">
			<Blind :device="device" @closeMe="closeMe" />
		</div>
		<div class="card-name">{{device.name}}</div>
	</div>
</template>

<script>
import Blind from "@/components/devices/Blind.vue"
export default {

	name: 'BlindCard',
	components:{
		Blind
	},
	props: {
		device: {
			required: true	
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