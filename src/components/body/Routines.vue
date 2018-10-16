<template>
	<div class="routines">
        <div class="r-header">
            RUTINAS
        </div>
        <div class="r-body">
            <div class="r-name">Nombre Rutina</div>
            <div class="r-btn">
                <a class="button is-primary">Activar</a>
            </div>
         </div>
         <div class="r-footer">
         	<a class="button is-link">Agregar Rutina</a>
         </div>
    </div>
</template>

<script>
import AddRoutine from "@/components/routines/AddRoutine.vue"
export default {

  name: 'Routines',
  components: {
  	AddRoutine
  },
  data () {
    return {

    }
  }
}
</script>

<style lang="sass" scoped>


.routines
    box-shadow: 2px 2px $shadowBg
    background-color:  $primaryBg
    flex: 5
    border-radius: 5px
    display: flex
    flex-direction: column


.r-header
    display: block
    font-size: 1.5em
    margin-block-start: 0.83em
    margin-block-end: 0.83em
    margin-inline-start: 0px
    margin-inline-end: 0px
    font-weight: bold
    color: rgba(0, 0, 0, 0.61)
    font-size: 17px
    height: 30px
.r-body
    display: flex
    flex: 1
.r-footer
 	padding: 10px 0
.r-name
    display: flex
    flex: 2
    margin-left: 7px

.r-btn
    display: flex
    flex: 1
    cursor: pointer
 
    justify-content: center
</style>