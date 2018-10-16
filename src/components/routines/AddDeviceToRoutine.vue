<template>
	<div class="modal" @click.stop="closeModal">
        <div class="modal-inner" @click.stop>
            <div class="modal-header">
                Agregar Dispositivo a la rutina
                <div class="close-modal-btn" @click="closeModal">
                    <v-icon name="times-circle"  scale="1" />
                </div>
            </div>
            <div class="modal-body">
            	<DevicesList :devices="$devices" />
            </div>
        </div>
    </div>
</template>

<script>
export default {

  name: 'AddDeviceToRoutine',

  data () {
    return {

    }
  },
  methods: {
  	closeModal(){
        this.$emit('closeMe')
    },
  }
}
</script>

<style lang="css" scoped>
</style>