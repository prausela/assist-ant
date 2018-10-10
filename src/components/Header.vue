<template>
	<div class="header">
		<div class="icon">
			<img class="icon-img" src="../assets/logo.png">
		</div>
		<div class="title">Bienvenido a casa</div>
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
	align-items: center
	font-size: 30px
.icon-img
	height: 100%

.icon
	display: flex
	flex-direction: row
	justify-content: center
	align-items: center

.info 
	display: flex
	justify-content: center
	align-items: center
</style>