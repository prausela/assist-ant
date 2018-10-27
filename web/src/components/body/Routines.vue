<template>
	<div class="routines">
        <AddRoutine :currRoutine="selectedRoutine" @closeMe="showAddRoutine = false; selectedRoutine = null" v-if="showAddRoutine"/>
        <div class="r-header">
            RUTINAS
        </div>
        <div class="r-body">
          <div class="routines-list" >
            <div class="routine-item" :key="id" v-for="(routine, id) in routines">
              <div @click="selectRoutine(routine)" class="r-name">{{routine.name}}</div>
              <div class="r-btn">
                  <a @click="executeRoutine(routine)" class="button is-primary">Activar</a>
              </div>
            </div>
          </div>
         </div>
         <div class="r-footer">
         	<a class="button is-primary" @click="showAddRoutine = true">Agregar Rutina</a>
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
      showAddRoutine: false,
      routines: [],
      selectedRoutine: null
    }
  },
  mounted() {
    this.$api.eventBus.$on('routinesRefreshed', () => {
      this.refreshRoutines()
    })
    this.refreshRoutines()
  },
  methods: {
    refreshRoutines() {
      this.routines = this.$routines
    },
    selectRoutine(routine) {
      this.selectedRoutine = routine
      this.showAddRoutine = true
    },
    executeRoutine(routine) {
      routine.execute().then(() => {
        this.$toaster.success(this.$strings[this.$language].routines.execute.success)
      }).catch((error) => {

        console.log(error)
        this.$toaster.error(this.$strings[this.$language].routines.execute.fail)
      })
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
    border-bottom: 1px solid #0000002e
    margin-top: 8px
    margin-bottom: 28px
.r-body
    display: flex
    flex: 1
    justify-content: center
.r-footer
 	padding: 10px 0
  border-top: 1px solid #0000002e
.r-name
  display: flex
  margin-left: 7px
  cursor: pointer
  border: 1px solid black
  padding: 5px
  border-radius: 5px


.r-btn
    display: flex
    cursor: pointer
 
    justify-content: center
.routines-list
  display: flex
  flex-direction: column
  width: 90%

.routine-item
  margin: 5px 0
  display: flex
  justify-content: space-between
  width: 100%
.button.is-link
 
  box-shadow: inset 0 0 9px rgba(0, 0, 0, 0.5) !important
  background-color: $shadowBg !important
  font-size: 14px !important
  color: black !important
.button.is-link:hover
    background-color: #97989b !important
    border-color: transparent !important
    color: #fff
</style>