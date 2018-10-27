<template>
	<div>
		<v-icon name="clock" scale="2" />
		<div>Hora: {{time}}</div>
	</div>
</template>

<script>
export default {

  name: 'Time',

  data () {
    return {
    	time: ""
    }
  },
  methods: {
	updateTime() {
  		var d = new Date();
		var hr = d.getHours();
		var min = d.getMinutes();
		if (min < 10) {
		    min = "0" + min;
		}
		this.time = hr + ":" + min
  	}
  },
  mounted() {
  	this.updateTime()
  	setInterval(() => {
  		this.updateTime()
  	}, 1000);
  },
  computed: {
  
  }
}
</script>

<style lang="css" scoped>
</style>