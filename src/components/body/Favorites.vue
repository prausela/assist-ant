<template>
  <div class="favorites">
        <h2 class="favorites-title">DESTACADOS</h2>
        <DevicesList :add="false" :devices="favoriteDevices" />
    </div>
</template>

<script>
export default {

  name: 'Favorites',
  data () {
    return {
        favoriteDevices: []
    }
  },
  methods: {
    refreshDevices() {
        this.favoriteDevices = this.$devices.filter((device) => {
            return device.meta.favorite
        })
    },
  },
  mounted() {
    this.$api.eventBus.$on('devicesRefreshed', () => {
      this.refreshDevices()
    })
  },  
}
</script>

<style lang="sass" scoped>
.favorites
  background-color: $primaryBg
  box-shadow: 2px 2px $shadowBg
  width: 30%
  border-radius: 5px
  display: flex
  flex-direction: column
  height: 450px

.favorites-title
    margin-top: 8px
    margin-bottom: 28px
    color: rgba(0, 0, 0, 0.61)
    font-size: 17px
    font-weight: bold
    border-bottom: 1px solid #0000002e

</style>