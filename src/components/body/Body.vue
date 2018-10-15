<template>
    <div id="main-content">
        <div class="columns">
            <Devices/>

            <Favorites />
            <div id="history-routines">
                <div class="history">
                        <h2 class="ultima">ULTIMA ACCION</h2>
                        <v-icon name="redo-alt" class="redo" scale="1.5" />
                </div>
                <div class="routines">
                    <div class="r-header">
                        RUTINAS
                    </div>
                    <div class="r-body">
                        <div class="r-name">Nombre Rutina</div>
                        <div class="r-btn">
                            <div class="active-btn">Activar</div>
                        </div>
                </div>
                </div>
            </div>
        </div>
    </div>
</template>

 <script>
 import Devices from "./Devices.vue"
 import Favorites from "./Favorites.vue"

 export default {

  name: 'Body',
  components: {
    Devices,
    Favorites
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
        max-height: 380px
        display: flex
        flex-direction: row 
        position: relative
        align-items: stretch
        flex: 1
        justify-content: space-around
        user-select: none

    #history-routines
        display: flex
        flex-direction: column
        width: 30%
        border-radius: 5px


    .routines
        box-shadow: 2px 2px $shadowBg
        background-color:  $primaryBg
        flex: 1
        border-radius: 5px
        display: flex
        flex-direction: column


    .r-header
        flex: 1
        display: block
        font-size: 1.5em
        margin-block-start: 0.83em
        margin-block-end: 0.83em
        margin-inline-start: 0px
        margin-inline-end: 0px
        font-weight: bold
        color: rgba(0, 0, 0, 0.61)
        font-size: 17px
    .r-body
        display: flex
        flex: 2
    .r-name
        display: flex
        flex: 2
        margin-left: 7px

    .r-btn
        display: flex
        flex: 1
        cursor: pointer
     
        justify-content: center
    .active-btn
        display: fel
        background-color: $logo
        color: black
        border-radius: 5px
        height: 15%
        text-align: center
        padding: 3px


    .history
        margin-bottom: 8%
        background-color:  $primaryBg
        box-shadow: 2px 2px $shadowBg
        flex: 1
        border-radius: 5px

    .favorites-title
        margin: 17px 0

    .redo
        position: absolute
        right: 27px
        top: 20px
        cursor: pointer
    .ultima
        margin-right: 30px
        color: rgba(0, 0, 0, 0.61)
        font-size: 17px



</style>

