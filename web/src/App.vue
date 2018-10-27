<template>
  <div id="app">
    <div v-show="!connection" id="no_conectivity">
      <div id="no_conectivity_message">    
        <v-icon id="wifi" scale="10" name="wifi"/>
        <strong><p>{{false ? $strings[$language].api.now_conected : $strings[$language].api.no_conectivity}}</p></strong>
        <p>{{$strings[$language].api.wait}}</p>
      </div>
    </div>
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
    Body,
  },
  data() {
    return {
      connection: true
    }
  },
  mounted() {

    // console.log(ApiServiceProvider)
    // ApiServiceProvider.testAxios()

    this.$api.eventBus.$on('timeIsUp', () => {
      this.$toaster.info(this.$strings[this.$language].devices.timer.timeIsUp)
    })

    // this.testConnection()

    // ApiServiceProvider.devices.add({nsme: "trdt"}).then((response) => {
    //   console.log(response)
    // })
  },
  methods: {
    testConnection() {
      console.log('testing connectionn....')
      this.$api.testConnection().then(() => {
        this.connection = true
        setTimeout(() => {
          this.testConnection()
        }, 2000);
      }).catch(() => {
        this.connection = false
        setTimeout(() => {
          this.testConnection()
        }, 2000);
      })
    }
  }
}
</script>

<style lang="sass">


*
  font-family: arial
// General
#app 
  display: flex
  flex-direction: column
  
  -webkit-font-smoothing: antialiased
  -moz-osx-font-smoothing: grayscale
  text-align: center
  color: #2c3e50
  display: flex
  position: relative
  justify-content: space-around
  height: 100vh

#no_conectivity
  position: absolute
  width: 100%
  height: 100%
  z-index: 2
  color: white
  background-color: rgba(0,132,201, 0.95)

#no_conectivity_message
  position: absolute
  top: 50%
  left: 50%
  font-size: 20px
  transform: translate(-50%,-50%)
  -ms-transform: translate(-50%,-50%)
  text-align: justify
#no_conectivity_message strong
  color: white
  font-size: 25px

#no_conectivity_wait
  position: absolute
  top: 50%
  left: 50%
  font-size: 20px
  transform: translate(-50%,-50%)
  -ms-transform: translate(-50%,-50%)
  text-align: justify

#wifi
  margin-bottom: 20px

body 
  margin: 0
  position: relative
  height: 100vh


// Addons

.vc-slider-swatches // Para el addon de photoshop
  display: none!important


//  Modal
body .modal
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
  user-select: none

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
  cursor: pointer

.modal-header
  padding-top: 30px
  align-items: center
  justify-content: center
  width: 100%
  justify-content: space-around
  font-size: 40px
  user-select: none
  position: relative
  white-space: nowrap
  overflow: hidden !important
  text-overflow: ellipsis
  display: inline-block
.modal-header::after
  content: ""
  position: absolute
  left: 50%
  bottom: 0
  height: 1px
  width: 90%
  transform: translateX(-50%)
  background-color: white
    
.modal-body
  flex: 1
  display: flex
  flex-direction: column
  align-items: center
  width: 100%
.column-container
    display: flex
    justify-content: center
    width: 100%
    height: 50%
    position: relative
    flex: 1
.column-container::after
    content: ""
    position: absolute
    left: 50%
    bottom: 0
    height: 1px
    width: 90%
    transform: translateX(-50%)
    background-color: white
.setting-op
    display: flex
    flex-direction: column
    justify-content: space-around   
    flex: 1
    width: 100%
    Transition: 0.4s all
.modal-footer
  display: flex
  width: 100%
  justify-content: center
  align-items: center
  height: 50px
  border-top: 1px solid #00000085

.mode-button
    display: flex
    justify-content: center
    align-items: center
    &.active
        background-color: #b1aeae
        box-shadow: inset 0 0 9px rgba(0, 0, 0, 0.5)

.temp-input
    width: 100%
    display: flex
    flex-direction: column
    align-items: center
    justify-content: center
    flex: 1
    padding-bottom: 10px
    .form-field
        align-self: flex-end
        padding-right: 20px
.temp-header
    display: flex
    flex: 1
    width: 100%
    align-items: center
    justify-content: center
.temp-body
    display: flex
    flex: 2
    width: 100%
    align-items: center
    justify-content: center
.numberField
    height: 40px
    align-self: center
    display: flex
    flex: 1
    width: 50%
    margin-left: 25px
    margin-top: 2px
    margin-right: 5px
.save-btn
    display: flex
    flex: 1
    justify-content: left
    margin-left: 5px


.save-txt
    border: 1px solid black
    cursor: pointer
    padding: 3px
.save-txt:hover
    background-color: #b1aeae
    box-shadow: inset 0 0 9px rgba(0, 0, 0, 0.5)



.button.is-primary
  box-shadow: inset 0 0 9px rgba(0, 0, 0, 0.5) !important
  background-color: $primaryBg !important
  font-size: 14px !important
  color: black !important
.button.is-primary:hover
    background-color: #97989b !important
    border-color: transparent !important
    

.button.is-danger
  display: flex !important
  box-shadow: inset 0 0 9px rgba(0, 0, 0, 0.5) !important
  font-size: 16px 
  color: black !important



.button.is-danger:hover
    background-color: #97989b !important
    border-color: transparent !important
    


  
// Tarjetas
.device-card
  display: flex
  justify-content:center
  align-content:center
  position: relative
  flex-direction: column
  width: 30%
  height: 100px
  margin: 7px 1%

  .card-name  
    white-space: nowrap
    overflow: hidden !important
    text-overflow: ellipsis
    height: 32px
.icon-container
  align-items: center
  height: 100px
  border: 1px solid black
  display: flex
  position: relative
  padding: 5px
  border-radius: 5px
  cursor: pointer
  min-height: 60px
  justify-content: center
  &.add-container
    height: 72px  

.vue-tooltip-theme
  background: black
  color: white
  border-radius: 16px
  padding: 5px 10px 4px
  z-index: 2000

.card-icon
  max-widht: 100%
  object-fit: contain
  height: 100%
  position: relative


.card-name
  text-align: center
  margin: 5px 0px
  cursor: pointer
    
.submit-btn
  padding: 5px 15px
  border-radius: 10px
  background-color: #06de06
.empty
  min-width: 1px
  min-height: 1px

</style>
