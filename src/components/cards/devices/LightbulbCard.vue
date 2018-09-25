<template>
	<div class="card">
		<div class="icon-container">
			<img class="card-icon" src="@/assets/lb-on.png">
		</div>
		<div class="name">{{name}}</div>
	</div>
</template>

<script>
export default {

  name: 'LightbulbCard',

  data () {
	return {
		name: 'Luz'
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
	width: 300px
.icon-container
	justify-content: center
	align-content: center
	height: 300px
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
	margin: 5px 0px
</style>