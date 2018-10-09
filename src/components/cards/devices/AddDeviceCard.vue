<template>
	<div class="card">
		<div class="icon-container">
			<v-icon name="plus" class="card-icon" scale="1.5" />
		</div>
	</div>
</template>

<script>
export default {

	name: 'AddDeviceCard',

	props: {
		device: {
			required: true	
		}
	},

	data () {
		return {
			name: 'Agregar'
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