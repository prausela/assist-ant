<template>
	<div class="header">
		<div class="title"></div>

		<div class="icon">
			<img class="icon-img" src="../assets/logo1.png">
		</div>
		<div class="info">
			<Time/>
			
		</div>
	</div>
</template>

<script>

import Time from './header/Time.vue'


export default {

  name: 'Header',
  components: {
  	Time
  },
  data () {
    return {
    	test:"hola"
    }
  }
}
</script>

<style lang="sass" scoped>
.header 
	height: 100px
	display: flex
	flex-direction: row
	justify-content: space-between
	padding: 5px 10px

.title
	display: flex
	flex: 1
	align-items: center
	font-size: 30px
.icon-img
	height: 100%
	width: 50%
	display: flex
	align-items: center
	justify-content: center


.icon
	display: flex
	flex-direction: row
	justify-content: center
	align-items: center
	flex: 2

.info 
	display: flex
	justify-content: flex-end
	align-items: center
	flex: 1
</style>