<template>
  <div id="devices">
    <div class="tabs">
      <div class="devices-tab tab" @click="pressedButton">Dispositivos</div>
      <div class="hab-tab tab" @click="pressedButton">
        Habitaciones
      </div>
      <div class="floors-tab tab" @click="pressedButton">
        Pisos
      </div>	  	
    </div>
    <div v-if="verBotones" class="devices-list">
      <template v-for="(device, index) in devices">
        <component v-if="$config.availableDevices.includes(device.typeId)" :is="device.typeId + 'Card'" :key="index"/>
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

export default {
  components:{
    Lightbulb,
    LightCard,
    DoorCard,
    GarageCard
  },

  name: 'Devices',

  data () {
    return {
    	verBotones: true, 
      devices: testData.devices
    }

  },
  methods:{
  	pressedButton(){
  		this.verBotones = !this.verBotones
  	}
  },
  mounted() {
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
  text-align: left
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
  .tab 
    flex: 0 1 25%
    position: relative
    padding: 0 1rem
    display: flex
    align-items: center
    justify-content: center
    cursor: pointer

.tab:not(:last-child)::after
  top: 0
  content: ''
  position: absolute
  right: -2px
  width: 1px
  height: 30px
  background-color: black

</style>