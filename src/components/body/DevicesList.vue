<template>
	<div class="devices-list">
    <template v-for="(device, index) in devices">
      <component @devicesChanged="$emit('devicesChanged')" v-if="device && device.type" :device="device" :routine="routine" :is="device.type.component + 'Card'" :key="index" :openModals="openModals"/>
    </template>
    <AddDeviceCard @devicesChanged="$emit('devicesChanged')" :routine="routine" :room="room" v-if="add" />
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
import AddRoomCard from "@/components/cards/devices/AddRoomCard.vue"

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
    RefrigeratorCard,
    AddRoomCard
  },
  name: 'DevicesList',
  props: {
  	devices: {
  		required: true
  	},
  	add: {
  		required: false,
  		default: false
  	},
    openModals: {
      required: false,
      default: true
    },
    room: {
      required: false,
      deafult: null
    },
    routine: {
      default: null,
      required: false
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
  padding-left: 2%
  flex-wrap: wrap
  position: relative
  display: flex
  justify-content: flex-start
  overflow: auto
  width: 100%
</style>