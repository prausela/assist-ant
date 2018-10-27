<template>
    <div class="modal" @click.stop="closeModal">
        <div class="modal-inner" @click.stop>
            <div class="modal-header">
                {{device.name}}
                <div class="close-modal-btn" @click="closeModal">
                    <v-icon name="times-circle"  scale="1" />
                </div>

            </div>
            <div class="modal-body">
                <div class="column-container">
                    <div class="image-container">
                        <!-- <v-icon name="lightbulb" :style="{color:color}" scale="15" /> -->
                        <v-icon name="lightbulb" class="l-img" :style="{color: enabled?color: 'rgb(234,234,234'}" scale="8" />
                        
                        <!-- <img v-if="enabled" class="lightbulb-image" src="@/assets/lb-on.png"> -->
                        <!-- <img v-if="!enabled" class="lightbulb-image" src="@/assets/lb-off.png"> -->
                    </div>

                    <div class="switch-container">
                        <switches v-tooltip="!enabled ? $strings[$language].deviceTypes.device.tooltips.on : $strings[$language].deviceTypes.device.tooltips.off" class="switch" type-bold="true" theme="bulma" color="blue" @input="updateState" v-model="enabled"></switches>
                    </div>                        
                </div>
                <div class="setting-op" :class="{invisible: !enabled}">
                    <div class="color set">
                        <div class="name">Color</div>
                        <div class="sliders">
                            <slider-picker v-model="colors" @input="changedColor" />
                        </div>
                    </div>
                    <div class="brightness set">
                        <div class="name"> Brillo</div>
                        <div class="sliders-bulma">
                            <vue-slider ref="slider" @input="changedBrightness" v-model="brightness"></vue-slider>
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <cbfooter :device="device" @closeModal="closeModal" />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { Slider } from 'vue-color'    
import Switches from 'vue-switches'
import vueSlider from 'vue-slider-component'

export default {

  name: 'Lightbulb',
  components: {
    Switches,
    'slider-picker': Slider,
    vueSlider
  },
  props: [
    'device'
  ],
  data () {
    return {
        name: 'Lightbulb',
        enabled: this.device.meta.state,
        colors: this.device.meta.color,
        color: this.device.meta.color,
        brightness: this.device.meta.brightness,
        changeTimeout: null,
        initStateTimeout: null,
        initStatevalue: false,
    }
  },
  methods: {
    changedColor(colors) {
        this.color = colors.hex
        clearTimeout(this.changeTimeout)
        this.changeTimeout = setTimeout(() => {
            this.updateColor()
        }, 500);

    },
    updateState() {
        if (!this.initStatevalue) {
            console.log('ignoring initStatevalue')
            return
        }
        console.log('setting state0', this.enabled)
        this.device.setState(this.enabled).catch((error) => {
            // console.log(error)
        })
    },
    updateColor() {
        this.device.setColor(this.color).catch((error) => {
            console.log(error)
        })
    },
    changedBrightness() {
        if (!this.initStatevalue) {
            return
        }
        clearTimeout(this.changeTimeout)
        this.changeTimeout = setTimeout(() => {
            this.updateBrightness()
        }, 500);
    },
    updateBrightness() {
        if (!this.initStatevalue) {
            return
        }
        this.device.setBrightness(this.brightness).catch((error) => {
            console.log(error)
        })
    },
    closeModal(){
        this.$emit('closeMe')
    },
  },

  mounted() {
    setTimeout(() => {
        this.initStatevalue = true
    }, 250);
    // this.color = this.rgbToHex(this.colors)
  }
}
</script>

<style lang="sass" scoped>
.color
    display: flex
    flex: 1
    align-items: center
    justify-content: space-around
    position: relative
.brightness
    display: flex
    flex: 1
    align-items: center
    justify-content: space-around

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
    
.l-img
    stroke: black
.sliders
    display: flex
    height: 100%
    flex-direction: column
    justify-content: center
    align-items: center
    margin-right: 5px

.sliders-bulma
    flex: 10
.name
    display: flex
    flex: 1
    height: 100%
    justify-content: center
    align-items: center

.color::after
       content: ""
       position: absolute
       left: 50%
       bottom: 0
       height: 1px
       width: 90%
       transform: translateX(-50%)
       background-color: white
.invisible
     opacity: 0



</style>