<template>
	<div class="devices-list">
      <template v-for="(device, index) in devices">
        <component v-if="$config.availableDevices.includes(device.typeId)" :device="device" :is="device.typeId + 'Card'" :key="index"/>
      </template>
      <AddDeviceCard v-if="add" />
    </div>
</template>

<script>

import Lightbulb from "@/components/devices/Lightbulb.vue"
import LightCard from "@/components/cards/devices/LightCard.vue"
import DoorCard from "@/components/cards/devices/DoorCard.vue"  
import GarageCard from "@/components/cards/devices/GarageCard.vue"
import TimerCard from "@/components/cards/devices/TimerCard.vue"
import OvenCard from "@/components/cards/devices/OvenCard.vue"
import ACCard from "@/components/cards/devices/ACCard.vue"
import BlindCard from "@/components/cards/devices/BlindCard.vue"
import AlarmCard from "@/components/cards/devices/AlarmCard.vue"
import AddDeviceCard from "@/components/cards/devices/AddDeviceCard.vue"
import RefrigeratorCard from "@/components/cards/devices/RefrigeratorCard.vue"

export default {
  components:{
    Lightbulb,
    LightCard,
    DoorCard,
    GarageCard,
    TimerCard,
    OvenCard,
    ACCard,
    BlindCard,
    AlarmCard,
    AddDeviceCard,
    RefrigeratorCard
  },
  name: 'DevicesList',
  props: {
  	devices: {
  		required: true
  	},
  	add: {
  		required: false,
  		default: false
  	}
  },
  data () {
    return {

    }
  }
}
</script>

<style lang="sass" scoped>
.devices-list
  padding: 10px 0
  padding-left: 2%
  flex-wrap: wrap
  position: relative
  display: flex
  justify-content: flex-start
  overflow: auto
</style>