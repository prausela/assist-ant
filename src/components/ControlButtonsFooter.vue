<template>
    <div class="control-buttons">
        <div class="footer-icon" :class="{favorite: dev?dev.meta.favorite: false}" @click="clickedFav">
            <v-icon   name="star" scale="2" />
        </div>
        <div class="footer-icon">
            <v-icon name="pencil-alt" scale="2" />

        </div>
        <div class="footer-icon">
            <v-icon name="trash-alt" scale="2" />

        </div>


    </div>
</template>

<script>
export default {

  name: 'ControlButtonsFooter',
  props: ["device"],
  data () {
    return {
        dev: null
    }
  },
  methods: {
    clickedFav() {
        this.$emit('clickedFavorite')
        setTimeout(() => {
            this.refreshDev()            
        }, 500);
    },
    refreshDev() {
        this.dev = this.device
        this.$set(this.dev, "meta", this.device.meta)
        this.$set(this.dev.meta, "favorite", this.device.meta.favorite)
        // console.log(this.dev.meta.favorite)
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

.footer-icon:first-child
    border-right: 1px solid black

.footer-icon:nth-child(2)
    border-right: 1px solid black

</style>