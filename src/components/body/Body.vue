<template>
	<div class="Columns">
  		<div class="Tabs">
  			<button class="tab" @click="pressedButton">Dispositivos</button>
  				<!-- <div id='dev' class="tabcontent">
  					<p>Listarlos.</p>
				</div> -->
				<table v-if="verBotones" class="Devices">
  					<button class="button">
  						<img class="card-icon" src="@/assets/lb-on.png"> 
  					</button>
  					<button>d2</button>
  					<button>d3</button>
				</table>
  			<button class="tab" onclick="openDev(event,'dev')">Pisos</button>
  			<button class="tab" onclick="openDev(event,'dev')">Habitaciones</button>		
  		</div>
  		<div class="Favourite">
  			<h2>Destacados</h2>
  		</div>
  		<div class="History">
			<h2>Ultima Accion</h2>
  		</div>
  		<div class="Routines">
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
// function openDev(evt, dev) {
//     var i, tabcontent, tablinks;
//     tabcontent = document.getElementsByClassName("tabcontent");
//     for (i = 0; i < tabcontent.length; i++) {
//         tabcontent[i].style.display = "none";
//     }
//     tablinks = document.getElementsByClassName("tab");
//     for (i = 0; i < tablinks.length; i++) {
//         tablinks[i].className = tablinks[i].className.replace(" active", "");
//     }
//     document.getElementById(cityName).style.display = "block";
//     evt.currentTarget.className += " active";
// }
</script>


<style lang="css" scoped>
.tab{
		background-color: rgb(219, 187, 214);
		color:black;
		width: 33%;
		height:40px;
}
.card-icon{
	width: 30px;
	height: 30px;
}


.Columns{
    content: "";
    display:table;
    clear: both;
    border-width: 3px;
    border-color: black;
    height: 400px;
    position: relative;

}
.Tabs button:hover{
	    background-color: rgb(193, 160, 201);
}

.Tabs button:Accion{

    background-color: rgb(193, 160, 201);
}

.Tabs{

	width: 30%;
	height:400px;
	background-color:  rgb(219, 187, 214);
	position: absolute;
  	box-shadow: 5px 10px rgb(193, 160, 201);

}

.Favourite{
	width: 30%;
	height:400px;
	float: center;
	background-color:  rgb(219, 187, 214);
	position: absolute;
	left:35%;
	box-shadow: 5px 10px rgb(193, 160, 201);
}

.Routines{
	width: 30%;
	height: 180px;
	left:69%;

	box-shadow: 5px 10px rgb(193, 160, 201);
	background-color:  rgb(219, 187, 214);
		position: absolute;


}
.History{
	width: 30%;
	height:180px;
	background-color:  rgb(219, 187, 214);
	position: absolute;
	left:69%;
	bottom: 0px;
	box-shadow: 5px 10px rgb(193, 160, 201);


}


</style>

