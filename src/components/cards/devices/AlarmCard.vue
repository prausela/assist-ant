<template>
	<div class="card">
		<div class="icon-container">
			<img class="alarm-img" src="@/assets/devices/alarm.png">
		</div>
		<div class="name">{{device.name}}</div>
	</div>
</template>

<script>
export default {

	name: 'AlarmCard',
	props: {
		device: {
			required: true	
		}
	},

	data () {
		return {
			name: 'Alarma'
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

.alarm-img
	width: 100%
	height: 100%

</style>