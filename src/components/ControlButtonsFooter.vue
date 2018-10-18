<template>
    <div class="control-buttons">
        <div class="footer-icon button is-primary" :class="{favorite: device.meta.favorite}" @click="star">
          <v-icon name="star" scale="2" />
        </div>
        <div class="footer-icon button is-primary" @click="edit">
            <v-icon name="pencil-alt" scale="2" />
            <div v-if="verEdit" class="device">
              <EditDevice :device="device" @closeEdit="closeEdit"/>
              </div>
        </div>
        <div @click="remove" class="footer-icon button is-primary ">
            <v-icon name="trash-alt" scale="2" />
        </div>
    </div>
</template>

<script>
import EditDevice from "@/components/forms/EditDevice.vue"
export default {
  components:{
    EditDevice
  },

  name: 'ControlButtonsFooter',

  props: [
  'device'
  ],
  data () {
    return {
        verEdit:false,
        dev: null
    }
  },
  methods: {
    edit(){
      this.verEdit = true
    },
    star() {
      this.device.favorite(!this.device.meta.favorite)
    },
    remove() {
      this.$api.devices.delete(this.device).then(() => {
          this.$toaster.success(this.$strings[this.$language].devices.delete.success)
          this.$emit('closeModal')
      }).catch((error) => {
          console.log(error)
          this.$toaster.error(error)
      })
    },
    closeEdit(){
      this.verEdit = false
    }
  },
  computed: {
  },
  mounted() {

  }
}
</script>

<style lang="sass" scoped>
.control-buttons
    height: 100%
    display: flex
    justify-content: center
    width: 100%
    align-items: center
    cursor: pointer
.favorite
    color: yellow !important
.footer-icon
    flex: 1
    justify-content: center
    display: flex
    height: 100%
    align-items: center
    cursor: pointer

.footer-icon:first-child
    border-right: 1px solid grey
.footer-icon:nth-child(2)
    border-right: 1px solid grey

</style>