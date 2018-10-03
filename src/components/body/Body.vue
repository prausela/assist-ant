<template>
	<div class="columns">
    
  		<div class="tabs">
        
        <div class="devices" @click="pressedButton">Dispositivos</div>
        <table v-if="verBotones" class="devices-list">
            
            <img class="card-icon" src="@/assets/lb-on.png"> 
            <img class="card-icon" src="@/assets/lb-on.png"> 
            <img class="card-icon" src="@/assets/lb-on.png"> 

<!--             <img class="card-icon" src="@/assets/bedroom.PNG"> 
 --><!--             <img class="card-icon" src="@/assets/cocina.PNG"> 
 -->    

        </table>
        <div class="hab" @click="pressedButton">Habitaciones</div>
        <div class="floors" @click="pressedButton">Pisos</div>

  			<!-- <button class="tab" @click="pressedButton">Dispositivos</button>
  				
				<table v-if="verBotones" class="devices">
  					<button class="button">
  						<img class="card-icon" src="@/assets/lb-on.png"> 
  					</button>
  					<button>d2</button>
  					<button>d3</button>
				</table>
  			<button class="tab" onclick="openDev(event,'dev')">Pisos</button>
  			<button class="tab" onclick="openDev(event,'dev')">Habitaciones</button>	 -->	
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

<!-- si la tab no esta seleccionada    background-color:  rgb(193, 160, 201);
 -->
<style lang="css" scoped>
.card-icon{
  display: row;
  border: 1px solid white;
margin: 8px;    
width: 100px;
  height: 100px;

}

.devices-list{
  position: absolute;
  margin-top: 20%;
  height: 80%;
  width: 100%;
  background-color: rgb(219, 187, 214);
  display: inline;

  text-align: left;
}

.floors{
  border: 1px solid white;
  height: 10%;
  display: flex;
  align-items: center;
  margin-right: 2px;
    padding: 3px;


}
.devices{
    border: 1px solid white;

      height: 10%;
    margin-left: 2px;
   display: flex;
    align-items: center;
      padding: 3px;


}
.hab{
    border: 1px solid white;

  height: 10%;
  display: flex;
  align-items: center;
    padding: 3px;


}

.tabs{
    justify-content: space-between;
  font-size: 20px;
  color:black;
  display: flex;
  flex-direction:row;
  width: 30%;
  height:400px;
  background-color:  rgb(219, 187, 214);
  position: absolute;
  box-shadow: 5px 10px rgb(193, 160, 201);
}



.columns{
    content: "";
    display:table;
    clear: both;
    border-width: 3px;
    border-color: black;
    height: 400px;
    position: relative;
      font-family: My Happy Ending;


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

