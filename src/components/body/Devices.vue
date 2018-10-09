<template>
  <div id="devices">
    <div class="tabs">
      <div v-for="(tab,index) in tabs" :class="{selected: selectedTab == tab}" :key="index" class="devices-tab tab" @click="selectedTab = tab">{{tab.label}}</div>
    </div>
    <div v-if="verBotones" class="devices-list">
      <template v-for="(device, index) in devices">
        <component v-if="$config.availableDevices.includes(device.typeId)" :device="device" :is="device.typeId + 'Card'" :key="index"/>
      </template>
    </div>
  </div>
</template>

<script>
import Lightbulb from "@/components/devices/Lightbulb.vue"
import testData from "@/testData.js"
import LightCard from "@/components/cards/devices/LightCard.vue"
import DoorCard from "@/components/cards/devices/DoorCard.vue"  
import GarageCard from "@/components/cards/devices/GarageCard.vue"
import TimerCard from "@/components/cards/devices/TimerCard.vue"
import OvenCard from "@/components/cards/devices/OvenCard.vue"
import ACCard from "@/components/cards/devices/ACCard.vue"

export default {
  components:{
    Lightbulb,
    LightCard,
    DoorCard,
    GarageCard,
    TimerCard,
    OvenCard,
    ACCard
  },

  name: 'Devices',

  data () {
    return {
    	verBotones: true, 
      devices: testData.devices,
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
  	}
  },
  mounted() {
    this.selectedTab = this.tabs.Dispositivos
  }
}
</script>

<style lang="sass" scoped>
#devices
  display: flex
  flex-direction: column
  width: 30%
  background-color: $primaryBg
  box-shadow: 5px 10px $shadowBg

.card-icon
  display: row
  border: 1px solid white
  margin: 8px    
  width: 100px
  height: 100px



.devices-list
  padding: 10px 0
  padding-left: 2%
  flex-wrap: wrap
  position: relative
  display: flex
  justify-content: flex-start
  overflow: auto


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
  height: 30px
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