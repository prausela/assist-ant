<template>
  <div id="devices">
    <div class="tabs">
      <div v-for="(tab,index) in tabs" :class="{selected: selectedTab == tab}" :key="index" class="devices-tab tab" @click="selectedTab = tab">{{tab.label}}</div>
    </div>
    <DevicesList :add="true" :devices="devices" />
  </div>
</template>

<script>
import DevicesList from "@/components/body/DevicesList.vue"
import testData from "@/testData.js"


export default {
  components:{
    DevicesList
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