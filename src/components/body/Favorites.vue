<template>
	<div class="favorites">
        <h2 class="favorites-title">Destacados</h2>
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

.favorites-title
    margin: 3px 0

</style>