<template>
  <div id="app">
    <Header/>
    <Body/>
  </div>
</template>

<script>
import Header from './components/Header.vue'
import Body from './components/body/Body.vue'
export default {
  name: 'app',
  components: {
    Header,
    Body
  }
}
</script>

<style lang="sass">

#app 
  display: flex
  flex-direction: column
  // font-family: 'Avenir', Helvetica, Arial, sans-serif
  -webkit-font-smoothing: antialiased
  -moz-osx-font-smoothing: grayscale
  text-align: center
  color: #2c3e50
  display: flex
  position: relative
  justify-content: space-around
  height: 100vh

body 
  margin: 0
  position: relative
  height: 100vh


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

.modal
  position: fixed
  left: 0
  top: 0
  width: 100vw
  height: 100vh
  z-index: 10
  background-color: $modalBg

.modal-inner
  position: fixed
  width: 50%
  height: 50%
  margin-right: auto
  margin-left: auto

.card
  display: flex
  justify-content:center
  align-content:center
  position: relative
  flex-direction: column
  width: 30%
  height: 100px
  margin: 5px 1%



</style>
