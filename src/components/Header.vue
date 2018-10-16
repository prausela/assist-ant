<template>
	<div class="header">
		<div class="empty"></div>
		<div class="header-icon">
			<img class="header-img" src="../assets/logo1.png">
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
.header-img
	height: 90%
	width: auto
	display: flex
	align-items: center
	justify-content: center


.header-icon
	display: flex
	flex-direction: row
	justify-content: center
	align-items: center

.info 
	display: flex
	justify-content: flex-end
	align-items: center
</style>