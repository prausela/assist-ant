<template>
	<div class="header">
		<div class="icon">
			<div class="icon-label">ASSIST</div>
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

<style lang="css" scoped>
.header {
	height: 100px;
	display: flex;
	flex-direction: row;
	justify-content: space-between;
}
.title{
	display: flex;
	align-items: center;
}
.icon-img{
	height: 100%;
}
.icon{
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
}

</style>