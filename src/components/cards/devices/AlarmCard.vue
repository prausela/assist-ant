<template>
	<div class="device-card" @click="pressedCard">
		<div class="icon-container">
			<img class="alarm-img" src="@/assets/devices/alarm.png">
		</div>
		<div v-if="verDevice" class="device">
			<Alarm :device="device" @closeMe="closeMe" />
		</div>
		<div class="card-name">{{device.name}}</div>
	</div>
</template>

<script>
import Alarm from "@/components/devices/Alarm.vue"

export default {
	
	name: 'AlarmCard',
	components:{
		Alarm
	},
	props: {
		device: {
			required: true	
		}
	},

	data () {
		return {
			verDevice:false,

			name: 'Alarma'
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



.alarm-img
	display: flex
	width: 38px
	height: 32px

</style>