<template>
	<div :class="{active: active}" @click="$emit('clicked')" class='icon-wrapper'>
		<v-icon  v-if="name == 'bed'" name="bed" class="img1" scale="1.5" />
		<v-icon  v-if="name == 'couch'" name="couch" class="img1" scale="1.5" />
		<img     v-if="name == 'bathroom'" class="img1" src="@/assets/rooms/bathroom.png">
		<img     v-if="name == 'dining-room'" class="img1" src="@/assets/rooms/dining-room.png">
		<img     v-if="name == 'garden'" class="img1"  src="@/assets/rooms/garden.png">
		<img     v-if="name == 'kitchen'" class="img1" src="@/assets/rooms/kitchen.png">
		<img     v-if="name == 'office'" class="img1" src="@/assets/rooms/office.png">
		<img     v-if="name == 'washing-room'" class="img1" src="@/assets/rooms/washing-room.png">
		<v-icon  v-if="name == 'swimming-pool'" name="swimming-pool" class="img1" scale="1.5" />
	</div>
</template>

<script>
export default {

  name: 'Icon',
  props: {
  	name: {
  		required: true
  	},
  	scale: {
  		required: false,
  		default: 1
  	},
  	active: {
  		required: false,
  		default: false,
  	}
  },
  data () {
    return {

    }
  }
}
</script>

<style lang="sass" scoped>
.icon-wrapper
    display: flex
    justify-content: center
    align-items: center
    padding: 10px
    &.active
        background-color: #b1aeae
        box-shadow: inset 0 0 9px rgba(0, 0, 0, 0.5)
.img1
	display: flex
	width: 50px
	height: 50px

</style>