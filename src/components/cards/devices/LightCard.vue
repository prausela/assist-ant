<template>
	<div class="card" @click="pressedCard">
		<div class="icon-container">
			<v-icon name="lightbulb" class="card-icon" scale="2" />
		</div>
		<div v-if="verDevice" class="device">
			<Lightbulb :device="device" @closeMe="closeMe" />
		</div>
		<div class="name">{{device.name}}</div>
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
	justify-content: center
	align-content: center
	height: 100px
	border: 1px solid black
	display: flex
	position: relative
	padding: 5px

.card-icon
	max-widht: 100%
	object-fit: contain
	height: 100%
	position: relative


.name
	text-align: center
	margin: 5px 0px

</style>