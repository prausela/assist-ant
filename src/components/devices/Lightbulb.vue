<template>
    <div class="modal" @click.stop="closeModal">
        <div class="modal-inner" @click.stop>
            <div class="modal-header">
                {{name}}
                <div class="close-modal-btn" @click="closeModal">
                    <v-icon name="times-circle"  scale="1" />
                </div>

            </div>
            <div class="modal-body">
                <div class="column-container">
                    <div class="image-container">
                        <!-- <v-icon name="lightbulb" :style="{color:color}" scale="15" /> -->
                        <v-icon name="lightbulb" :style="{color: enabled?color: 'black'}" scale="8" />
                        
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
        // this.color = this.rgbToHex(this.hsvToRgb(colors.hsv.h))
        this.color = colors.hex
    },
    rgbToHex(rgb) {
        let red = rgb.r
        let green = rgb.g
        let blue = rgb.b
        var rgbe = blue | (green << 8) | (red << 16);
        return '#' + (0x1000000 + rgbe).toString(16).slice(1)
    },
    closeModal(){
        this.$emit('closeMe')
    }
  },

  mounted() {
    this.color = this.rgbToHex(this.colors)
  }
}
</script>

<style lang="sass" scoped>
.modal
    display: flex
    justify-content: center
    align-items: center

.modal-inner
    display: flex
    height: 500px
    width: 500px
    flex-direction: column
    align-items: center
    justify-content: space-around
    border: 1px solid black
    background-color: $primaryBg
.close-modal-btn
    position
.modal-header
    display: flex
    align-items: center
    justify-content: center
    width: 100%
    justify-content: space-around

.modal-body
    display: flex
    flex-direction: column
    align-items: center
.modal-footer
    display: flex
    width: 100%
    justify-content: center
    align-items: center

.column-container
    display: flex
    justify-content: center
    width: 100%



.image-container
    padding: 15px   
    flex: 1
    display: flex
    align-items: center
    justify-content: center
.lightbulb-image
    height: 100%
    width: auto
.switch-container
    flex: 1
    justify-content: center
    align-items: center
    display: flex
    

.sliders
    display: flex
    flex-direction: column
    justify-content: center
    align-items: center
    margin: 50px 0

</style>