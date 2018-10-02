<template>
	<div class="columns">
    
  		<div class="tabs">
  			<button class="tab" @click="pressedButton">Dispositivos</button>
  				
				<table v-if="verBotones" class="devices">
  					<button class="button">
  						<img class="card-icon" src="@/assets/lb-on.png"> 
  					</button>
  					<button>d2</button>
  					<button>d3</button>
				</table>
  			<button class="tab" onclick="openDev(event,'dev')">Pisos</button>
  			<button class="tab" onclick="openDev(event,'dev')">Habitaciones</button>		
  		</div>
  		<div class="favourite">
  			<h2>Destacados</h2>
  		</div>
  		<div class="history">
			<h2>Ultima Accion</h2>
  		</div>
  		<div class="routines">
  			<h2>Rutinas</h2>
  		</div>
	</div>
</template>

 <script>
 export default {

  name: 'Body',
  components: {
  	
  },
  data () {
    return {
    	test:"hola",
    	verBotones: false
    }
  },
  methods:{
  	pressedButton(){
  		this.verBotones = !this.verBotones
  	}
  }
}
</script>


<style lang="css" scoped>

.tabs{
  width: 30%;
  height:400px;
  background-color:  rgb(219, 187, 214);
  position: absolute;
  box-shadow: 5px 10px rgb(193, 160, 201);
}


.card-icon{
	width: 30px;
	height: 30px;
}


.columns{
    content: "";
    display:table;
    clear: both;
    border-width: 3px;
    border-color: black;
    height: 400px;
    position: relative;

}

.favourite{
	width: 30%;
	height:400px;
	float: center;
	background-color:  rgb(219, 187, 214);
	position: absolute;
	left:35%;
	box-shadow: 5px 10px rgb(193, 160, 201);
}

.routines{
	width: 30%;
	height: 180px;
	left:69%;

	box-shadow: 5px 10px rgb(193, 160, 201);
	background-color:  rgb(219, 187, 214);
		position: absolute;


}
.history{
	width: 30%;
	height:180px;
	background-color:  rgb(219, 187, 214);
	position: absolute;
	left:69%;
	bottom: 0px;
	box-shadow: 5px 10px rgb(193, 160, 201);
}

</style>

