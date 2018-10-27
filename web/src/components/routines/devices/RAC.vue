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
                        <img class="ac-pimg" src="@/assets/devices/AC.png">
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
                    <div class="op-body">
                        <div class="name">Ventilador</div>
                        <div class="body">
                            <div v-tooltip="$strings[$language].deviceTypes.ac.tooltips.fan.down" class="minus-container" @click="setFanSpeed('-25')">
                               <v-icon name="minus" class="mode" scale="1" />
                           </div>

                           <img v-tooltip="$strings[$language].deviceTypes.ac.tooltips.fan.strength.twenty_five" class="fan-img" src="@/assets/modes/fan-25.png" v-if="this.speed == '25' ">
                           <img v-tooltip="$strings[$language].deviceTypes.ac.tooltips.fan.strength.fifty" class="fan-img" src="@/assets/modes/fan-50.png" v-if="this.speed == '50' ">
                           <img v-tooltip="$strings[$language].deviceTypes.ac.tooltips.fan.strength.seventy_five" class="fan-img" src="@/assets/modes/fan-75.png" v-if="this.speed == '75' ">

                           <img v-tooltip="$strings[$language].deviceTypes.ac.tooltips.fan.strength.hundred" class="fan-img" src="@/assets/modes/fan-100.png" v-if="this.speed == '100' ">

                           <img v-tooltip="$strings[$language].deviceTypes.ac.tooltips.fan.strength.auto" class="fan-img" src="@/assets/modes/fan-auto.png" v-if="this.speed == 'auto' ">
                           <div v-tooltip="$strings[$language].deviceTypes.ac.tooltips.fan.up" class="plus-container" @click="setFanSpeed('25')">

                            <v-icon name="plus" class="mode" scale="1" />
                        </div>
                        <div v-tooltip="$strings[$language].deviceTypes.ac.tooltips.fan.strength.auto" class="fan-auto" @click="setFanSpeed('auto')" :class="{active: speed == 'auto'}">Auto</div>
                        <div class="empty"></div>
                        <div class="empty"></div>

                    </div>
                </div>
                    <div class="op-body">
                        <div class="name">Modo</div>
                        <div class="body">
                            <!-- String "cool", "heat", "fan" -->
                            <div v-tooltip="$strings[$language].deviceTypes.ac.tooltips.modes.heatMode" class="mode-button" :class="{active: mode == 'heat'}" @click="setMode('heat')"><v-icon name="sun" class="ac-img"  /></div>
                            <div v-tooltip="$strings[$language].deviceTypes.ac.tooltips.modes.coldMode" class="mode-button" :class="{active: mode == 'cool'}" @click="setMode('cool')" ><v-icon name="snowflake" class="ac-img"  /></div>
                            <div v-tooltip="$strings[$language].deviceTypes.ac.tooltips.modes.fanMode" class="mode-button" :class="{active: mode == 'fan'}"  @click="setMode('fan')"><img class="fan-img3 ac-img" src="@/assets/devices/fan.png"> </div>
                            <div class="empty"></div>
                            <div class="empty"></div>
                            <div class="empty"></div>


                        </div>
                    </div>
                    <div class="op-body">
                        <div class="name">Swing Vertical</div>
                        <div class="body">
                            <img v-tooltip="$strings[$language].deviceTypes.ac.tooltips.vertical.auto" class="ac-img" src="@/assets/modes/swing.png" :class="{active: verticalSwing == 'auto'}" @click="setVerticalSwing('auto')">
                            <img v-tooltip="$strings[$language].deviceTypes.ac.tooltips.vertical.twenty_two" class="ac-img" src="@/assets/modes/swing-22.png" :class="{active: verticalSwing == '22'}" @click="setVerticalSwing('22')">
                            <img v-tooltip="$strings[$language].deviceTypes.ac.tooltips.vertical.forty_five" class="ac-img" src="@/assets/modes/swing-45.png" :class="{active: verticalSwing == '45'}" @click="setVerticalSwing('45')">
                            <img v-tooltip="$strings[$language].deviceTypes.ac.tooltips.vertical.sixty_seven" class="ac-img" src="@/assets/modes/swing-67.png" :class="{active: verticalSwing == '67'}" @click="setVerticalSwing('67')">
                            <img v-tooltip="$strings[$language].deviceTypes.ac.tooltips.vertical.ninty" class="ac-img" src="@/assets/modes/swing-90.png" :class="{active: verticalSwing == '90'}" @click="setVerticalSwing('90')">
                            <div class="empty"></div>

                        </div>
                    </div>
                    <div class="op-body">
                        <div class="name">Swing Horizontal</div>
                        <div class="body">  
                            <img v-tooltip="$strings[$language].deviceTypes.ac.tooltips.horizontal.auto" class="ac-img" src="@/assets/modes/h-auto.png" :class="{active: horizontalSwing == 'auto'}" @click="setHorizontalSwing('auto')" >
                            <img v-tooltip="$strings[$language].deviceTypes.ac.tooltips.horizontal.minus_ninty" class="ac-img" src="@/assets/modes/h--90.png" :class="{active: horizontalSwing == '-90'}" @click="setHorizontalSwing('-90')">
                            <img v-tooltip="$strings[$language].deviceTypes.ac.tooltips.horizontal.minus_forty_five" class="ac-img" src="@/assets/modes/h--45.png" :class="{active: horizontalSwing == '-45'}" @click="setHorizontalSwing('-45')">
                            <img v-tooltip="$strings[$language].deviceTypes.ac.tooltips.horizontal.cero" class="ac-img" src="@/assets/modes/h-0.png" :class="{active: horizontalSwing == '0'}" @click="setHorizontalSwing('0')">
                            <img v-tooltip="$strings[$language].deviceTypes.ac.tooltips.horizontal.forty_five" class="ac-img" src="@/assets/modes/h-45.png" :class="{active: horizontalSwing == '45'}" @click="setHorizontalSwing('45')">                            
                            <img v-tooltip="$strings[$language].deviceTypes.ac.tooltips.horizontal.ninty" class="ac-img" src="@/assets/modes/h-90.png" :class="{active: horizontalSwing == '90'}" @click="setHorizontalSwing('90')">                            
                        </div>
                    </div>
                </div>    
            </div>
                <div class="modal-footer">
                    <a @click="closeModal" class="button is-primary">Guardar</a>
                    <a @click="removeFromRoutine" class="button is-primary ">Sacar de la Rutina</a>
                </div>
        </div>
    </div>
</template>

<script>
import Switches from 'vue-switches'

export default {

    name: 'AC',

    components: {
        Switches
    },
    props: [
    'device',
    'routine'
    ],
    data () {
        return {
            name: 'AC',
            enabled: false,
            temperature: this.$config.deviceTypes.ac.defaults.temperature,
            mode: this.$config.deviceTypes.ac.defaults.mode,
            horizontalSwing: this.$config.deviceTypes.ac.defaults.horizontalSwing,
            verticalSwing: this.$config.deviceTypes.ac.defaults.verticalSwing,
            speed: this.$config.deviceTypes.ac.defaults.speed,
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
                console.log(action)
                if (action.actionName == 'turnOn') {
                    this.enabled = true
                } else if( action.actionName == "setMode") {
                    this.mode = action.params[0]
                } else if( action.actionName == "setTemperature") {
                    this.temperature = action.params[0]
                } else if( action.actionName == "setVerticalSwing") {
                    this.verticalSwing = action.params[0]
                } else if( action.actionName == "setHorizontalSwing") {
                    this.horizontalSwing = action.params[0]
                } else if( action.actionName == "setFanSpeed") {
                    this.speed = action.params[0]
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
            if (!this.initStatevalue) {
                return
            }

            let action = null
            if (this.enabled) {
                action = this.$api.routines.createAction(this.device, 'turnOn', [])
            } else {
                action = this.$api.routines.createAction(this.device, 'turnOff', [])            
            }
            console.log(action)
            this.routine.addAction(action)
        },
        setTemperature(temperature){
            if( temperature < 18 || temperature > 38) {
                this.$toaster.error(this.$strings[this.$language].deviceTypes.ac.errors.invalidRange)
                return
            }
            this.temperature=temperature
            let action = this.$api.routines.createAction(this.device, 'setTemperature', [temperature])
            this.routine.addAction(action)
        },
        setMode(newMode) {
            this.mode = newMode
            let action = this.$api.routines.createAction(this.device, 'setMode', [newMode])
            this.routine.addAction(action)
        },
        setVerticalSwing(newVS){
            this.verticalSwing=newVS
            let action = this.$api.routines.createAction(this.device, 'setVerticalSwing', [newVS])
            this.routine.addAction(action)
        },
        setHorizontalSwing(newHS){
            this.horizontalSwing=newHS
            let action = this.$api.routines.createAction(this.device, 'setHorizontalSwing', [newHS])
            this.routine.addAction(action)
        },
        setFanSpeed(newFS){

            console.log(this.speed)
            if(newFS=='auto'){
                this.speed=newFS
            }
            else if(newFS=='-25'){
                if(this.speed=='auto'){
                    this.speed='25'
                }
                this.speed= parseInt(this.speed)

                if(this.speed!=25){
                    this.speed-=25
                    this.speed=this.speed.toString()
                }
            }
            else if(newFS=='25'){
                if(this.speed=='auto'){
                    this.speed='0'
                }
                this.speed= parseInt(this.speed)

                if(this.speed!=100){
                    this.speed+=25
                    this.speed=this.speed.toString()
                }
            }  

            let action = this.$api.routines.createAction(this.device, 'setFanSpeed', [this.speed])
            this.routine.addAction(action)

        }
    }
}
</script>

<style lang="sass" scoped>
.fan-auto
    display: flex
    align-items: center
    border: 1px solid black
    height: 100%
    cursor: pointer
    &.active
        background-color: #b1aeae
        box-shadow: inset 0 0 9px rgba(0, 0, 0, 0.5)

.invisible
    opacity: 1



.ac-pimg
    width: 150px
    height: 150px
.ac-img
    border: 1px solid black
    width: 30px
    height: 30px
    cursor: pointer
    &.active
        background-color: #b1aeae
        box-shadow: inset 0 0 9px rgba(0, 0, 0, 0.5)



.op-body
    display: flex
    justify-content: space-around
    align-items: center
    text-align: left
    border: 5px
    margin: 5px
    position: relative
.op-body::after
    content: ""
    position: absolute
    left: 50%
    bottom: -5px
    height: 1px
    width: 90%
    transform: translateX(-50%)
    background-color: white
.name
    display: flex
    width: 25%
    font-size: 15px
    align-items: center
    justify-content: center

.mode
    text-align: left
    border: 1px solid black
    padding: 2px
    cursor: pointer

.body
    display: flex
    width: 75%
    height: 100%
    justify-content: space-between
    align-items: center


.modes
    display: flex
    align-items: center
    justify-content: space-around

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
.temp-input
    width: 100%
    display: flex
    flex-direction: column
    align-items: center
    justify-content: center
    flex: 1
    padding-bottom: 10px
    .form-field
        align-self: flex-end
        padding-right: 20px
        input

.switch
    padding: 0 15px
    display: flex
    justify-content: center
    align-items: center
    flex-direction: column
    flex: 1
.form
    display: flex
    flex: 1

.form-label
    margin: 5px
    cursor: context-menu
.fan
    display: flex
    align-items: center
    justify-content: space-around

.fan-img3
    width: 32px
    height: 32px
    border: 1px solid black

.fan-img
    width: 35px
    height: 35px
.empty
    width: 35px
    height: 35px
    border: 1px 
.mode-button
    display: flex
    justify-content: center
    align-items: center
    &.active
        background-color: #b1aeae
        box-shadow: inset 0 0 9px rgba(0, 0, 0, 0.5)



</style>