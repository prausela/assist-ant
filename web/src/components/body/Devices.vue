<template>
  <div id="devices">
    <div class="tabs">
      <div v-for="(tab,index) in tabs" :class="{selected: selectedTab == tab}" :key="index" class="devices-tab tab" @click="selectedTab = tab">{{tab.label}}</div>
    </div>
    <DevicesList :add="true" :devices="devices" v-show="selectedTab == tabs.Dispositivos" />
    <RoomsList :add="true" :rooms="rooms" v-show="selectedTab == tabs.Habitaciones" />
  </div>
</template>
<script>

import RoomsList from "./RoomsList.vue"

export default {

  name: 'Devices',
  components: {
    RoomsList
  },
  data () {
    return {
      verBotones: true, 
      devices: [],
      rooms: [],
      tabs: {
        Dispositivos: {
          label: "DISPOSITIVOS"
        },
        Habitaciones: {
          label: "HABITACIONES"
        },
      },
      selectedTab: null
    }

  },
  methods:{
    pressedButton(){
      this.verBotones = !this.verBotones
    },
    refreshDevices() {
      this.devices = this.$devices
    },
    refreshRooms() {
      this.rooms = this.$rooms
    },
  },
  mounted() {
    this.selectedTab = this.tabs.Dispositivos
    this.refreshDevices()
    this.refreshRooms() 
    this.$api.eventBus.$on('devicesRefreshed', () => {
      this.refreshDevices()
    })
    this.$api.eventBus.$on('roomsRefreshed', () => {
      this.refreshRooms()
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
  height: 450px

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
  border-bottom: 1px solid #00000082
  height: 32px
  min-height: 35px
  user-select: none
  color: rgba(0, 0, 0, 0.61)
  font-size: 10px
  .tab 
    flex: 0 1 50%
    position: relative
    display: flex
    align-items: center
    justify-content: center
    cursor: pointer
    &.selected
      background-color: #bdb9b9
      font-weight: bold
      font-size: 16px

.tab:not(:last-child)::after
  top: 0
  content: ''
  position: absolute
  right: -2px
  width: 1px
  height: 35px
  background-color: #00000082
  z-index: 5

</style>