<template>
	<div class="card" @click="pressedCard">
		<div class="icon-container">
            <img class="ac-img" src="@/assets/devices/AC.png">
		</div>
		<div v-if="verDevice" class="device">
			<AC :device="device" @closeMe="closeMe" />
		</div>
		<div class="card-name">{{device.name}}</div>
	</div>
</template>

<script>
import AC from "@/components/devices/AC.vue"

export default {
	components:{
		AC
	},
	name: 'ACCard',

	props: {
		device: {
			required: true	
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