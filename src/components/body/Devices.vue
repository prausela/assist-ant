<template>
  <div id="devices">
    <div class="tabs">
      <div v-for="(tab,index) in tabs" :class="{selected: selectedTab == tab}" :key="index" class="devices-tab tab" @click="selectedTab = tab">{{tab.label}}</div>
    </div>
    <DevicesList :add="true" :devices="devices" />
  </div>
</template>

<script>


export default {

  name: 'Devices',

  data () {
    return {
    	verBotones: true, 
      devices: [],
      tabs: {
        Dispositivos: {
          label: "Dispositivos"
        },
        Habitaciones: {
          label: "Habitaciones"
        },
        Pisos: {
          label: "Pisos"
        }
      },
      selectedTab: null
    }

  },
  methods:{
  	pressedButton(){
  		this.verBotones = !this.verBotones
  	},
    refreshDevices() {
      this.$api.devices.getAll().then((devices) => {
        console.log(devices)
        this.devices = devices
      })
    }
  },
  mounted() {
    this.selectedTab = this.tabs.Dispositivos
    this.refreshDevices()
    this.$api.eventBus.$on('refreshDevices', () => {
      console.log('refresh devices received')
      this.refreshDevices()
    })
  }
}
</script>

<style lang="sass" scoped>
#devices
  display: flex
  flex-direction: column
  width: 30%
  background-color: $primaryBg
  box-shadow: 2px 2px $shadowBg
  border-radius: 5px


.card-icon
  display: row
  border: 1px solid white
  margin: 8px    
  width: 100px
  height: 100px


.floors
  border: 1px solid white
  height: 10%
  display: flex
  align-items: center
  margin-right: 2px
  padding: 3px



.hab
  border: 1px solid white
  height: 10%
  display: flex
  align-items: center
  padding: 3px


.tabs
  justify-content: space-around
  font-size: 20px
  color: black
  display: flex
  flex-direction: row
  border-bottom: 1px solid black
  height: 35px
  user-select: none
  .tab 
    flex: 0 1 33%
    position: relative
    padding: 0 1rem
    display: flex
    align-items: center
    justify-content: center
    cursor: pointer
    &.selected
      background-color: #bdb9b9

.tab:not(:last-child)::after
  top: 0
  content: ''
  position: absolute
  right: -2px
  width: 1px
  height: 30px
  background-color: black
  z-index: 5

</style>