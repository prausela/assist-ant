<template>
	<div class="modal" @click.stop="closeModal">
        <div class="modal-inner" @click.stop>
            <div class="modal-header">
                Agregar a la rutina
                <div class="close-modal-btn" @click="closeModal">
                    <v-icon name="times-circle"  scale="1" />
                </div>
            </div>
            <div class="modal-body">
            	<DevicesList v-show="devices.length > 0" @devicesChanged="updateDevices" :routine="routine" :devices="devices" />
              <div v-if="devices.length == 0">No hay dispositivos disponibles para agregar</div>
            </div>
            <div class="modal-footer">
               <a @click="closeModal" class="button is-primary">Agregar</a>

            </div>
        </div>
    </div>
</template>

<script>
export default {

  name: 'AddDeviceToRoutine',
  props: {
    routine: {
      required: true
    }
  },
  data () {
    return {
      devices: []
    }
  },
  methods: {
  	closeModal(){
      this.$emit('devicesChanged')
      this.$emit('closeMe')
    },
    updateDevices() {
      let filteredDevices = this.$devices.filter((dev) => {
        // console.log(dev.id)
        let found = false
        this.routine.actions.forEach((action) => {
          // console.log(action.deviceId == dev.id)
          if (action.deviceId == dev.id) { 
            found = true
          }
        })
        return !found
      })
      this.devices = filteredDevices
    }
  },
  mounted() {
    this.updateDevices()
  },

}
</script>

<style lang="sass" scoped>

.button.is-primary
  box-shadow: inset 0 0 9px rgba(0, 0, 0, 0.5)
  background-color: rgb(0, 132, 204)
  font-size: 14px

.button.is-primary:hover
    background-color: #276cda
    border-color: transparent
    color: #fff
</style>