<template>
  <div id="app">
    <Header/>
    <Body/>
  </div>
</template>

<script>
import Header from './components/Header.vue'
import Body from './components/body/Body.vue'
import AddDevice from './components/devices/AddDevice.vue'

export default {
  name: 'app',
  components: {
    Header,
    Body,
    AddDevice
  }
}
</script>

<style lang="sass">


// General
#app 
  display: flex
  flex-direction: column
  *
       font-family: arial
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


// Addons

.vc-slider-swatches // Para el addon de photoshop
  display: none!important


//  Modal
.modal
  position: fixed
  left: 0
  top: 0
  width: 100vw
  height: 100vh
  z-index: 10
  background-color: $modalBg
  display: flex
  justify-content: center
  align-items: center
.modal-inner
  position: fixed
  margin-right: auto
  margin-left: auto
  height: 500px
  width: 500px
  flex-direction: column
  align-items: center
  justify-content: space-between
  border: 1px solid black
  background-color: $primaryBg
  display: flex
  flex-direction: column

.close-modal-btn
  position: absolute
  right: 20px
  top: 5px

.modal-header
  padding-top: 30px
  display: flex
  align-items: center
  justify-content: center
  width: 100%
  justify-content: space-around
  font-size: 40px

.modal-body
  flex: 1
  display: flex
  flex-direction: column
  align-items: center
.modal-footer
  display: flex
  width: 100%
  justify-content: center
  align-items: center
  height: 50px
  border-top: 1px solid black
  
// Tarjetas
.card
  display: flex
  justify-content:center
  align-content:center
  position: relative
  flex-direction: column
  width: 30%
  height: 100px
  margin: 5px 1%

    
.icon-container
  justify-content: center
  align-content: center
  min-height: 60px
  height: 60px
  border: 1px solid black
  display: flex
  position: relative
  padding: 5px

.submit-btn
  padding: 5px 15px
  border-radius: 10px
  background-color: #06de06

</style>
