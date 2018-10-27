<template>
	<div class="modal" @click.stop="closeModal">
        <div class="modal-inner" @click.stop>
            <div class="modal-header">
                {{room.name}}
                <div class="close-modal-btn" @click="closeModal">
                    <v-icon name="times-circle"  scale="1" />
                </div>
            </div>
            <div class="modal-body">
            	<DevicesList keep-alive :room="room" :add="true" :devices="room.devices"  />
            </div>
            <div class="modal-footer">
                <RoomFooter :room="room" @closeModal="closeModal" />
            </div>
        </div>
    </div>
</template>

<script>

import RoomFooter from "./RoomFooter.vue"
export default {

  name: 'Room',
  props: {
  	room: {
  		required: true
  	}
  },
  components: {
    RoomFooter
  },
  data () {
    return {

    }
  },
  methods: {
    closeModal(){
        this.$emit('closeMe')
    },
  },
}
</script>

<style lang="css" scoped>
</style>