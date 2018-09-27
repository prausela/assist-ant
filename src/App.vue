<template>
  <div id="app">
    <Header/>
    <LightbulbCard/>
    <Lightbulb/>
  </div>
</template>

<script>
import Header from './components/Header.vue'
import LightbulbCard from './components/cards/devices/LightbulbCard.vue'
import Lightbulb from './components/devices/Lightbulb.vue'

export default {
  name: 'app',
  components: {
    LightbulbCard,
    Lightbulb,
    Header
  }
}
</script>

<style lang="sass">
#app 
  display: flex
  flex-direction: column
  font-family: 'Avenir', Helvetica, Arial, sans-serif
  -webkit-font-smoothing: antialiased
  -moz-osx-font-smoothing: grayscale
  text-align: center
  color: #2c3e50
  padding-top: 5px
  padding-left: 5px
  display: flex
  position: relative
  justify-content: space-around

body 
  margin: 0
  position: relative


.modal-window
  width: 800px
  height: 800px
  border: 1px solid black
  padding-top: 5px
  display: flex
  flex-direction: column

.modal-header 
  font-size: 40px

.vc-slider-swatches // Para el addon de photoshop
  display: none!important

</style>
