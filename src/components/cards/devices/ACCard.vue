<template>
	<div class="device-card" @click="pressedCard">
		<div class="icon-container">
            <img class="ac-img" src="@/assets/devices/AC.png">
		</div>
		<div v-if="verDevice" class="device">
			<AC :device="device" @closeMe="closeMe" />
			<RAC v-if="routine" :device="device" :routine="routine" @closeMe="closeMe" />
		</div>
		<div class="card-name">{{device.name}}</div>
	</div>
</template>

<script>
import AC from "@/components/devices/AC.vue"
import RAC from "@/components/routines/devices/RAC.vue"

export default {
	components:{
		AC,
		RAC
	},
	name: 'ACCard',

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
			name: 'Aire Acondicionado'
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







.ac-img
	display: flex
	width: 32px
	height: 32px

</style>