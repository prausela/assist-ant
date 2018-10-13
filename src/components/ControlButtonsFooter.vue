<template>
    <div class="control-buttons">
        <div class="footer-icon" :class="{favorite: dev?dev.meta.favorite: false}" @click="star">
          <v-icon   name="star" scale="2" />
        </div>
        <div class="footer-icon" @click="edit">
            <v-icon name="pencil-alt" scale="2" />
            <div v-if="verEdit" class="device">
              <EditDevice :device="device" @closeEdit="closeEdit"/>
              </div>
        </div>
        <div @click="remove" class="footer-icon">
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
  ]
  ,
  data () {
    return {
        verEdit:false,
        dev: null
    }
  },
  methods: {
    clickedFav() {
    },
    refreshDev() {
        this.dev = this.device
        this.$set(this.dev, "meta", this.device.meta)
        this.$set(this.dev.meta, "favorite", this.device.meta.favorite)
        // console.log(this.dev.meta.favorite)
      },
      edit(){
        this.verEdit = true
      },
      star() {

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
    favorite() {
        return this.dev && this.dev.meta && this.dev.meta.favorite
    }
  },
  watch: {
    dev() {
        console.log("dev changed")
    }
  },
  mounted() {
    this.refreshDev()
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
.favorite
    color: yellow
.footer-icon
    flex: 1
    justify-content: center
    display: flex
    height: 100%
    align-items: center
    cursor: pointer

.footer-icon:first-child
    border-right: 1px solid black
.footer-icon:nth-child(2)
    border-right: 1px solid black

</style>