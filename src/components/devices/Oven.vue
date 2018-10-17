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
                        <img class="oven-img" src="@/assets/devices/oven.png">
                    </div>
                    <div class="switch-container">
                        <switches v-tooltip="!enabled ? $strings[$language].deviceTypes.device.tooltips.on : $strings[$language].deviceTypes.device.tooltips.off" class="switch" type-bold="true" theme="bulma" color="blue" @input="updateState" v-model="enabled"></switches>
                        <div class="temp-input" :class="{invisible: !enabled}">
                            <div class="temp-header">Temperatura</div>
                            <div class="temp-body">
                                <input class="numberField" type="number" placeholder="°C" v-model="temperature">
                                    <a class="button is-primary" @click="setTemperature(temperature)">Guardar</a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="setting-op" :class="{invisible: !enabled}">
                    <div class="set heat">
                        <div class="name"> Calor </div>
                        <div class="body">
                            <div v-tooltip="$strings[$language].deviceTypes.oven.tooltips.heatMode.conventional" class="mode-button" :class="{active: heat == 'conventional'}" @click="setHeat('conventional')">
                                <img class="op" src="@/assets/modes/oven-conventional.png">
                            </div>
                            <div v-tooltip="$strings[$language].deviceTypes.oven.tooltips.heatMode.bottom" class="mode-button" :class="{active: heat == 'bottom'}" @click="setHeat('bottom')">
                                <img class="op" src="@/assets/modes/oven-bottom.png">
                            </div>
                            <div v-tooltip="$strings[$language].deviceTypes.oven.tooltips.heatMode.top" class="mode-button" :class="{active: heat == 'top'}" @click="setHeat('top')">
                                <img class="op" src="@/assets/modes/oven-top.png">
                            </div>
                        </div>

                    </div>
                    <div class="set grill">
                        <div class="name"> Grill </div>
                        <div class="body">
                            <div v-tooltip="$strings[$language].deviceTypes.oven.tooltips.grillMode.large" class="mode-button" :class="{active: grill == 'large'}" @click="setGrill('large')">
                                <img class="op" src="@/assets/modes/oven-top.png">
                            </div>
                            <div v-tooltip="$strings[$language].deviceTypes.device.tooltips.eco" class="mode-button" :class="{active: grill == 'eco'}" @click="setGrill('eco')">
                                <v-icon name="leaf" class="op"  scale="1" />
                            </div>
                            <div v-tooltip="$strings[$language].deviceTypes.oven.tooltips.allModes.deactivate" class="mode-button" :class="{active: grill == 'off'}" @click="setGrill('off')">
                                <div class="op">Off</div>
                            </div>
                        </div>
                    </div>
                    <div class="set conv">
                        <div class="name">Convección</div>
                        <div class="body">
                            <div v-tooltip="$strings[$language].deviceTypes.oven.tooltips.convectionMode.normal" class="mode-button" :class="{active: convection == 'normal'}" @click="setConvection('normal')">
                                <img class="op" src="@/assets/devices/fan.png">
                            </div>
                            <div v-tooltip="$strings[$language].deviceTypes.device.tooltips.eco" class="mode-button" :class="{active: convection == 'eco'}" @click="setConvection('eco')">
                                <v-icon name="leaf" class="op"  scale="1" />
                            </div>
                            <div v-tooltip="$strings[$language].deviceTypes.oven.tooltips.allModes.deactivate" class="mode-button" :class="{active: convection == 'off'}" @click="setConvection('off')">
                                <div class="op">Off</div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <cbfooter :device="device" @closeModal="closeModal" />
            </div>
        </div>
    </div>
</template>

<script>
import Switches from 'vue-switches'

export default {

    name: 'Oven',

    components: {
        Switches
    },
    props: [
    'device'
    ],
    data () {
        return {
            enabled: this.device.meta.state,
            temperature: this.device.meta.temperature,
            heat: this.device.meta.heat,
            grill: this.device.meta.grill,
            convection: this.device.meta.convection,
        }
    },
    methods:{
        closeModal(){
            this.$emit('closeMe')
        },
        updateState() {
            if (this.enabled != this.device.meta.state) {
                this.device.setState(this.enabled).catch((error) => {
                    console.log(error)
                })
            }
        },
        setTemperature(temperature){
            console.log(temperature)
            this.temperature=temperature
            this.device.setTemperature(temperature).then(()=>{
                console.log("exito")
                this.$toaster.success(this.$strings[this.$language].devices.modify.success)
            }).catch((error) => {
                if (error.message == "Unknown error") {
                    console.log(error)
                } else {
                    this.$toaster.error(error.message)
                }
            })
        },
        setHeat(newHeat) {
            this.heat = newHeat
            this.device.setHeat(newHeat).catch((error) => {
                console.log(error)
            })
        },
        setGrill(newGrill) {
            this.grill = newGrill
            this.device.setGrill(newGrill).catch((error) => {
                console.log(error)
            })
        },
        setConvection(newConvection) {
            this.convection = newConvection
            this.device.setConvection(newConvection).catch((error) => {
                console.log(error)
            })
        }

    }

}
</script>

<style lang="sass" scoped>
.invisible
     opacity: 0

.input
    display: flex
    flex: 1
    flex-direction: row


.oven-img
    width: 150px
    height: 150px
.name
    display: flex
    flex: 1
    justify-content: center
    align-items: center

.body
    display: flex
    flex: 2
    justify-content: space-between
    align-items: center
    padding: 0 20px


.set
    display: flex
    position: relative
    flex: 1

.set::after
       content: ""
       position: absolute
       left: 50%
       bottom: 0
       height: 1px
       width: 90%
       transform: translateX(-50%)
       background-color: white
.image-container
    padding: 15px   
    flex: 1
    display: flex
    align-items: center
    justify-content: center
.switch-container
    display: flex
    flex: 1
    flex-direction: column
    justify-content: center
    align-items: center
    display: flex

.switch
    display: flex
    justify-content: center
    align-items: center
    flex-direction: column
    flex: 1
    width: 100%
.form
    display: flex
    flex: 1

.form-label
    margin: 5px


.op
    width: 30px
    height: 30px
    border: 1px solid black
    padding: 3px
    cursor: pointer




</style>