<template>
    <div class="modal-window">
        <div class="modal-header">{{name}}</div>
        <div class="modal-body">
            <div class="column-container">
                <div class="image-container">
                    <v-icon name="lightbulb" :style="{color:color}" scale="15" />

                    <!-- <img v-if="enabled" class="lightbulb-image" src="@/assets/lb-on.png"> -->
                    <!-- <img v-if="!enabled" class="lightbulb-image" src="@/assets/lb-off.png"> -->
                </div>
                <div class="switch-container">
                    <switches class="switch" type-bold="true" theme="bulma" color="blue" v-model="enabled"></switches>
                </div>
            </div>
            <div class="sliders">
                <slider-picker v-model="colors" @input="changedColor" />
            </div>
        </div>
        <div class="modal-footer">
            <cbfooter />
        </div>
    </div>
</template>

<script>
import { Slider } from 'vue-color'

import Switches from 'vue-switches'

    export default {

  name: 'Lightbulb',
  components: {
    Switches,
    'slider-picker': Slider
  },
  data () {
    return {
        name: 'Luz',
        enabled: true,
        colors: { r: 25, g: 77, b:  255, a: 0.5},
        color: null
    }
  },
  methods: {
    changedColor(colors) {
        // console.log(colors)
        // this.color = this.rgbToHex(this.hsvToRgb(colors.hsv.h))
        this.color = colors.hex
        console.log(this.color)
    },
    rgbToHex(rgb) {
        let red = rgb.r
        let green = rgb.g
        let blue = rgb.b
        var rgbe = blue | (green << 8) | (red << 16);
        return '#' + (0x1000000 + rgbe).toString(16).slice(1)
    }
  },

  mounted() {
    this.color = this.rgbToHex(this.colors)
    console.log(this.color)
  }
}
</script>

<style lang="sass" scoped>
.column-container
    display: flex
    justify-content: center

.image-container
    padding: 15px   
    height: 400px
    flex: 1
    display: flex
    justify-content: center
    align-items: center
.lightbulb-image
    height: 100%
    width: auto
.switch-container
    flex: 1
    justify-content: center
    align-items: center
    display: flex
.modal-body
    flex: 1
.sliders
    display: flex
    flex-direction: column
    justify-content: center
    align-items: center
    margin: 50px 0
</style>