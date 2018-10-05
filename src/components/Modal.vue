<template>
	<div id="modal">
		<div id="modal-inner">

		</div>
	</div>
</template>

<script>
export default {

  name: 'Modal',

  data () {
    return {

    }
  }
}
</script>

<style lang="sass" scoped>
	#modal
		position: fixed
		width: 100vw
		height: 100vh
		background: red
		z-index: 10
		background-color: $modalBg
	#modal-inner
		position: fixed
		width: 50%
		height: 50%
		margin-right: auto
		margin-left: auto


</style>