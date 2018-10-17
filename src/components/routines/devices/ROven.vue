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
                    <a @click="closeModal" class="button is-primary">Guardar</a>
                    <a @click="removeFromRoutine" class="button is-danger">Sacar de la Rutina</a>
                </div>
        </div>
    </div>
</template>

<script>
import Switches from 'vue-switches'

export default {

    name: 'ROven',

    components: {
        Switches
    },
    props: [
    'device',
    'routine'
    ],
    data () {
        return {
            enabled: this.device.meta.state,
            temperature: this.device.meta.temperature,
            heat: this.device.meta.heat,
            grill: this.device.meta.grill,
            convection: this.device.meta.convection,
            initStateTimeout: null,
            initStatevalue: false
        }
    },
    mounted() {
        setTimeout(() => {
            this.initStatevalue = true
        }, 250);
        this.routine.actions.forEach((action) => {
            if (action.deviceId == this.device.id) {
                if (action.actionName == 'turnOn') {
                    this.enabled = true
                } else if( action.actionName == "setTemperature") {
                    this.temperature = action.params[0]
                } else if( action.actionName == "setHeat") {
                    this.heat = action.params[0]
                } else if( action.actionName == "setGrill") {
                    this.grill = action.params[0]
                } else if( action.actionName == "setConvection") {
                    this.convection = action.params[0]
                }
            }
        })
    },
    methods:{
        closeModal(){
            this.$emit('closeMe')
        },
        removeFromRoutine() {
            this.routine.removeDevice(this.device)
            this.closeModal()
        },
        updateState() {
            let action = null
            if (!this.initStatevalue) {
                return
            }
            if (this.enabled) {
                action = this.$api.routines.createAction(this.device, 'turnOn', [])
            } else {
                action = this.$api.routines.createAction(this.device, 'turnOff', [])            
            }
            console.log(action)
            this.routine.addAction(action)
        },
        setTemperature(temperature){
            if( temperature < 90 || temperature > 230) {
                this.$toaster.error(this.$strings[this.$language].deviceTypes.oven.errors.invalidRange)
                return
            }
            this.temperature=temperature
            let action = this.$api.routines.createAction(this.device, 'setTemperature', [temperature])
            this.routine.addAction(action)
        },
        setHeat(newHeat) {
            this.heat = newHeat
            let action = this.$api.routines.createAction(this.device, 'setHeat', [newHeat])
            this.routine.addAction(action)
        },
        setGrill(newGrill) {
            this.grill = newGrill
            let action = this.$api.routines.createAction(this.device, 'setGrill', [newGrill])
            this.routine.addAction(action)
        },
        setConvection(newConvection) {
            this.convection = newConvection
            let action = this.$api.routines.createAction(this.device, 'setConvection', [newConvection])
            this.routine.addAction(action)
        }

    }

}
</script>

<style lang="sass" scoped>
.invisible
     opacity: 1

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

.button.is-primary
  box-shadow: inset 0 0 9px rgba(0, 0, 0, 0.5)
  background-color: rgb(0, 132, 204)
  font-size: 14px
.button.is-primary:hover
    background-color: #276cda
    border-color: transparent
    color: #fff


</style>