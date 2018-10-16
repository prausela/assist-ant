<template>
	<div class="devices-list">
		<template v-for="(room, index) in rooms">
			<RoomCard v-if="room" :room="room" :key="index" :openModals="openModals"/>
		</template>
		<AddRoomCard v-if="add" />
	</div>
</template>

<script>
import RoomCard from "@/components/cards/rooms/RoomCard.vue"
import AddRoomCard from "@/components/cards/rooms/AddRoomCard.vue"
export default {

  name: 'RoomsList',
  components: {
  	AddRoomCard,
  	RoomCard
  },
  data () {
    return {

    }
  },
  props: {
  	rooms: {
  		required: true
  	},
  	add: {
  		required: false,
  		default: false
  	},
    openModals: {
      required: false,
      default: true
    }
  },
}
</script>

<style lang="sass" scoped>
.devices-list
  padding-left: 2%
  flex-wrap: wrap
  position: relative
  display: flex
  justify-content: flex-start
  overflow: auto
  width: 100%
</style>
