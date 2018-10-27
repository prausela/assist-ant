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
                        <img class="refri-img" src="@/assets/devices/refrigerator.png">
                    </div>
                    <div class="switch-container">
                                                
                        <div class="temp-input">
                            <div class="temp-header">Temperatura Freezer</div>
                            <div class="temp-body">
                                <input class="numberField" type="number" placeholder="°C" v-model="freezerTemperature">
                                <a class="button is-primary"  @click="setFreezerTemperature(freezerTemperature)">Guardar</a>
                            </div>
                        </div>
                         <div class="temp-input">
                            <div class="temp-header">Temperatura Heladera</div>
                            <div class="temp-body">
                                <input class="numberField" type="number" placeholder="°C" v-model="temperature">
                                <a class="button is-primary"  @click="setTemperature(temperature)">Guardar</a>
                             </div>
                        </div>
                    </div>
                    
                </div>
                <div class="setting-op">
                    <div class="op-body">
                        <div class="name"> Modo </div>
                        <div class="body">
                            <div v-tooltip="$strings[$language].deviceTypes.refrigerator.tooltips.modes.default" class="mode-button mode" :class="{active: mode == 'default'}" @click="setMode('default')">
                                Default
                            </div>
                            <div v-tooltip="$strings[$language].deviceTypes.refrigerator.tooltips.modes.party" class="mode-button" :class="{active: mode == 'party'}" @click="setMode('party')">
                                <img class="mode" src="@/assets/modes/party.png">
                            </div>
                            <div v-tooltip="$strings[$language].deviceTypes.refrigerator.tooltips.modes.vacation" class="mode-button" :class="{active: mode == 'vacation'}" @click="setMode('vacation')">
                                <v-icon name="suitcase" class="mode" scale="2" />
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
            <div class="modal-footer">
                <a @click="closeModal" class="button is-primary">Guardar</a>
                <a @click="removeFromRoutine" class="button is-primary">Sacar de la Rutina</a>
            </div>
        </div>
    </div>
</template>

<script>
import Switches from 'vue-switches'

export default {

    name: 'RRefrigerator',

    components: {
        Switches
    },
    props: [
        'device',
        'routine'
    ],
    data () {
        return {
            name: 'Heladera',
            mode: this.device.meta.mode,
            temperature:this.device.meta.temperature,
            freezerTemperature:this.device.meta.freezerTemperature
        }
    },
    methods:{
        closeModal(){
            this.$emit('closeMe')
        },
        removeFromRoutine() {
            this.routine.removeDevice(this.device)
            this.closeModal()
        },
        setMode(newMode) {
            this.mode = newMode
            let action = this.$api.routines.createAction(this.device, 'setMode', [newMode])
            this.routine.addAction(action)
        },
        setTemperature(temperature){
            if( temperature < 2 || temperature > 8) {
                this.$toaster.error(this.$strings[this.$language].deviceTypes.refrigerator.errors.invalidRange)
                return
            }
            this.temperature=temperature
            let action = this.$api.routines.createAction(this.device, 'setTemperature', [temperature])
            this.routine.addAction(action)
        },
        setFreezerTemperature(freezerTemperature){
            if( freezerTemperature < -20 || freezerTemperature > -8) {
                this.$toaster.error(this.$strings[this.$language].deviceTypes.refrigerator.errors.invalidFreezerRange)
                return
            }
            this.freezerTemperature = freezerTemperature
            let action = this.$api.routines.createAction(this.device, 'setFreezerTemperature', [freezerTemperature])
            this.routine.addAction(action)
        }

    },
    mounted() {
        this.routine.actions.forEach((action) => {
            if (action.deviceId == this.device.id) {
                console.log(action)
                if( action.actionName == "setMode") {
                    this.mode = action.params[0]
                } else if( action.actionName == "setTemperature") {
                    this.temperature = action.params[0]
                } else if( action.actionName == "setFreezerTemperature") {
                    this.freezerTemperature = action.params[0]
                }

            }
        })
    }
    


}
</script>

<style lang="sass" scoped>

.op-body
    display: flex
    justify-content: space-around
    align-items: center
    text-align: left
    border: 5px
    margin: 5px


.refri-img
    width: 80px
    height: 150px
.name
    display: flex
    flex: 1
    justify-content: center
    align-items: center

.body
    display: flex
    flex: 2
    justify-content: space-around
    align-items: center

.mode
    border: 1px solid black
    padding: 2px
    width: 30px
    height: 30px
    cursor: pointer
    font-size: 10px


.switch-container
    padding-right: 10px
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

.set
    display: flex
    flex: 1
.image-container
    padding: 15px   
    flex: 1
    display: flex
    align-items: center
    justify-content: center



</style>