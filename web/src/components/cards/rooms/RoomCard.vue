<template>
	<div class="device-card" @click="pressedCard">
		<div class="icon-container">
			<icono :name="room.meta.icon" class="card-icon" scale="2" />
		</div>
		<div v-if="verModal" class="device">
			<Room :room="room" @closeMe="closeMe" />
		</div>
		<div class="card-name">{{room.name}}</div>
	</div>
</template>


<script>
import Room from "./Room.vue"
export default {
	components:{
		Room
	},

	name: 'RoomCard',
	props: {
		room: {
			required: true	
		},
		openModals: {
			required: false,
			default: true
		}
	},
	data () {
		return {
			verModal: false,
		}
	},
	methods:{
		pressedCard(){
			if (this.openModals) {
				this.verModal = true
			}
		},
		closeMe(){
			this.verModal = false

		}
	}
}
</script>

<style lang="sass" scoped>



</style>