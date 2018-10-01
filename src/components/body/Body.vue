<template>
	<div class="Columns">
  		<div class="Tabs">
  			<h2>Dispositivos</h2>
  			<table class="Devices">
  				<button class="button">
  					<img class="card-icon" src="@/assets/lb-on.png"> 
  				</button>
  				<button>d2</button>
  				<button>d3</button>
			</table>
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


<style lang="css" scoped>

.card-icon{
	width: 30px;
	height: 30px;
}
.Devices button{
	background-color: rgb(219, 187, 214);
	padding:30px 30px; 

}

.Columns{
    content: "";
    display:table;
    clear: both;
    border-width: 3px;
    border-color: black;
    height: 400px;
}

.Tabs{
	width: 33%;
	height:400px;
	background-color:  rgb(219, 187, 214);
	float: left;
  	border: 1px solid black;
}

.Favourite{
	width: 33%;
	height:400px;
	background-color:  rgb(219, 187, 214);
	float: left;
	border: 1px solid black;


}

.History{
	width: 33%;
	height:200px;
	background-color:  rgb(219, 187, 214);
	float: right;
	border: 1px solid black;
}

.Routines{
	width: 33%;
	height: 200px;
	float: right;
	border: 1px solid black;
	background-color:  rgb(219, 187, 214);

}


</style>

