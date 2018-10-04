<template>
	<div id="devices">
		<div class="tabs">
	        
	        <div class="devices-tab" @click="pressedButton">Dispositivos</div>
	        <div class="hab-tab" @click="pressedButton">Habitaciones</div>
	        <div class="floors-tab" @click="pressedButton">Pisos</div>


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
	    <div v-if="verBotones" class="devices-list">
	        
	        <img class="card-icon" src="@/assets/lb-on.png"> 
	        <img class="card-icon" src="@/assets/lb-on.png"> 
	        <img class="card-icon" src="@/assets/lb-on.png"> 

	<!--             <img class="card-icon" src="@/assets/bedroom.PNG"> 
	--><!--             <img class="card-icon" src="@/assets/cocina.PNG"> 
	-->    

	    </div>
	</div>
</template>

<script>
export default {

  name: 'Devices',

  data () {
    return {
    	verBotones: true
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
#devices{
	display: flex;
	flex-direction: column;
}
.card-icon{
  display: row;
  border: 1px solid white;
  margin: 8px;    
  width: 100px;
  height: 100px;

}

.devices-list{
  position: relative;
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
</style>