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
                        <v-icon name="lightbulb" :style="{color: enabled?color: 'black'}" scale="8" />
                        
                        <!-- <img v-if="enabled" class="lightbulb-image" src="@/assets/lb-on.png"> -->
                        <!-- <img v-if="!enabled" class="lightbulb-image" src="@/assets/lb-off.png"> -->
                    </div>
                    <div class="switch-container">
                        <switches class="switch" type-bold="true" theme="bulma" color="blue" @input="updateState" v-model="enabled"></switches>
                    </div>
                </div>
                <div class="sliders">
                    <slider-picker v-model="colors" @input="changedColor" />
                </div>
            </div>
            <div class="modal-footer">
                <cbfooter :device="device" @closeModal="closeModal" />
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
  props: [
    'device'
  ],
  data () {
    return {
        name: 'Lightbulb',
        enabled: this.device.meta.state,
        colors: this.device.meta.color,
        color: this.device.meta.color,
        changeTimeout: null
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
        this.device.setState(this.enabled).catch((error) => {
            // console.log(error)
        })
    },
    updateColor() {
        this.device.setColor(this.color).catch((error) => {
            console.log(error)
        })
    },
    closeModal(){
        this.$emit('closeMe')
    },
  },

  mounted() {
    // this.color = this.rgbToHex(this.colors)
  }
}
</script>

<style lang="sass" scoped>



.modal-body
    flex-direction: column

.modal-footer
    display: flex
    width: 100%
    justify-content: center
    align-items: center
    height: 50px
    border-top: 1px solid black

.column-container
    display: flex
    justify-content: center
    width: 100%
    position: relative
  


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