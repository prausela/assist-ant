<template>
	<div class="card" @click="pressedCard">
		<div class="icon-container">
			<img class="blind-img" src="@/assets/devices/blind.png">
		</div>
		<div v-if="verDevice" class="device">
			<Blind :device="device" @closeMe="closeMe" />
		</div>
		<div class="name">{{device.name}}</div>
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

.blind-img
	display: flex
	width: 32px
	height: 32px

</style>