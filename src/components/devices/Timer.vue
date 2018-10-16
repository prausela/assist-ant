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
                        <v-icon name="stopwatch" class="card-icon" scale="10" />
                    </div>

                    <div class="switch-container">
                        <switches class="switch" type-bold="true" theme="bulma" color="blue" v-model="enabled"></switches>
                        <div class="temp-input">
                            <div class="temp-header">Set Tiempo</div>
                            <div class="temp-body">
                                <input class="numberField" type="number" placeholder="°C" v-model="this.perform("start")">
                                <div class="save-btn">
                                    <div class="save-txt" @click="this.perform('start')">
                                        Comenzar
                                    </div>
                                </div>
                                <div class="save-btn">
                                    <div class="save-txt" @click="this.perform('stop')">
                                        Parar
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="setting-op">
                    <div v-show="enabled">{{remainingTime}}</div>
                        
                    <div>
                        <button :disabled="enabled" @click="start">Empezar!</button>
                        <button :disabled="!enabled" @click="stop">Detener</button>
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
    name: 'Timer',
    components: {
        Switches
    },
    props: [
    'device'
    ],
    data () {
        return {
            name: 'Timer',
            enabled: false,
            seconds: 300,
            targetTime: 0,
            remainingTime: 0,
            interval: null
        }
    },
    mounted() {
        this.device.getState().then((deviceInfo) => {
            console.log(deviceInfo)
            if (deviceInfo.status) {
                this.enabled = deviceInfo.status
                this.targetTime = this.calculateTargetMs(deviceInfo.remaining)
                this.seconds = deviceInfo.interval
                this.startInterval()    
            }
        })
    },
    methods:{
        closeModal(){
            this.$emit('closeMe')
        },
        start() {
            
            this.device.setInterval(this.seconds).catch((error) => {
                console.log(error)
            }).then(() => {
                console.log('starting')
                this.device.start().then(() => {
                    this.enabled = true
                    this.targetTime = this.calculateTargetMs(this.seconds)
                    this.startInterval()
                })
            })

        },
        startInterval() {
            this.interval = setInterval(() => {
                this.updateTime()
            }, 50);
        },
        calculateTargetMs(seconds) {
            let now = new Date()
            let nowMs = now.valueOf()
            let targetMs = nowMs + seconds * 1000
            return targetMs
        },
        stop() {
            this.device.setInterval(this.seconds).catch((error) => {
                console.log(error)
            }).then(() => {
                this.device.start().then(() => {
                    this.enabled = true

                })
            })
        },
        updateTime() {
            if (!this.enabled ) { return 0}
            let now = new Date()
            let nowMs = now.valueOf()


            let msDiff = this.targetTime - nowMs

            this.remainingTime =  (msDiff / 1000).toFixed(2)
        }
    },
}
</script>

<style lang="sass" scoped>
  

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
    justify-content: space-around
    align-items: center


.set
    display: flex
    flex: 1
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
.seg-input
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


.op
    width: 30px
    height: 30px
    border: 1px solid black
    padding: 3px
</style>