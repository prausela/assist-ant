<template>
	<div class="columns">
      <Devices/>
  		
  		<div class="favourite">
  			<h2>Destacados</h2>
  		</div>
      <div id="history-routines">
        <div class="history">
        <h2>Ultima Accion</h2>
        </div>
        <div class="routines">
          <h2>Rutinas</h2>
        </div>
      </div>
	</div>
</template>

 <script>
 import Devices from "./Devices.vue"
 export default {

  name: 'Body',
  components: {
  	Devices
  },
  data () {
    return {
    }
  },
  
}
</script>

<!-- si la tab no esta seleccionada    background-color:  rgb(193, 160, 201);
 -->
<style lang="css" scoped>




.columns{
    display:flex;
    flex-direction: row; 
    border: 3px solid black;
    height: 400px;
    position: relative;
    font-family: My Happy Ending;


}

.favourite{
	width: 30%;
	height:400px;
	float: center;
	background-color:  rgb(219, 187, 214);
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
#history-routines{
  /*display: flex;*/
}
.history{
	background-color:  rgb(219, 187, 214);
	box-shadow: 5px 10px rgb(193, 160, 201);
}

</style>

