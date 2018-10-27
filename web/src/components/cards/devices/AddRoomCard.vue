<template>
	<div class="device-card"  @click="verDevice = true">
		<div class="add-container  icon-container">
			<v-icon name="plus" class="card-icon" scale="1.5" />
		</div>
		<div v-if="verDevice" class="device">
			<AddRoom @closeMe="verDevice = false" />
		</div>
		<div class="card-name">{{$strings[$language].deviceTypes.device.tooltips.add}}</div>
	</div>
</template>

<script>
import AddRoom from "@/components/forms/AddRoom.vue"

export default {

	name: 'AddRoomCard',
	components: {
		AddRoom
	},
	props: {
		device: {
			required: false	
		}
	},

	data () {
		return {
			name: 'Agregar',
			verDevice: false
		}
	}
}
</script>

<style lang="sass" scoped>

.name
	text-align: center
	margin: 5px 0px

</style>