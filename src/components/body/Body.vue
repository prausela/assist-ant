<template>
    <div id="main-content">
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
<style lang="sass" scoped>
    #main-content
        flex: 1
        display: flex
        flex-direction: column
    .columns
        max-height: 600px
        display: flex
        flex-direction: row 
        position: relative
        font-family: My Happy Ending
        align-items: stretch
        flex: 1
        justify-content: space-around

    .favourite
        background-color: $primaryBg
        box-shadow: 5px 10px $shadowBg
        width: 30%



    #history-routines
        display: flex
        flex-direction: column
        width: 30%

    .routines
        margin: 5% 0
        box-shadow: 5px 10px $shadowBg
        background-color:  $primaryBg
        flex: 1
    .history
        margin: 5% 0
        background-color:  $primaryBg
        box-shadow: 5px 10px $shadowBg
        flex: 1


</style>

