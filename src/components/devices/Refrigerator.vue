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
                <cbfooter :device="device" @closeModal="closeModal" />
            </div>
        </div>
    </div>
</template>

<script>
import Switches from 'vue-switches'

export default {

    name: 'Refrigerator',

    components: {
        Switches
    },
    props: [
    'device'
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
        setMode(newMode) {


            this.mode = newMode
            this.device.setMode(newMode).catch((error) => {
                console.log(error)
            })
        },
        setTemperature(temperature){
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
        setFreezerTemperature(freezerTemperature){
            this.freezerTemperature=freezerTemperature
            this.device.setFreezerTemperature(freezerTemperature).then(()=>{
                console.log("exito")
                this.$toaster.success(this.$strings[this.$language].devices.modify.success)
            }).catch((error) => {
                if (error.message == "Unknown error") {
                    console.log(error)
                } else {
                    this.$toaster.error(error.message)
                }
            }) 
        }

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