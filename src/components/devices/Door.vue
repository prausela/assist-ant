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
                    <div  class="state-container" @click="setState(false)"  v-if="this.state == true">
                        <v-icon name="door-closed" class="state" scale="10" />
                        <v-icon v-tooltip="$strings[$language].deviceTypes.door.tooltips.close" name="door-open" class="not-state" scale="3" />

                    </div>
                    <div class="state-container" @click="setState(true)"  v-if="this.state == false">
                        <v-icon name="door-open" class="state" scale="10" />
                       <v-icon v-tooltip="$strings[$language].deviceTypes.door.tooltips.open" name="door-closed" class="not-state" scale="3" />
                      
                    </div>
                </div>
                <div class="column-container">

                    <div class="state-container" @click="setLock(true)" v-if="this.lock == false">
                        <v-icon name="lock" class="state" scale="10" />
                        <v-icon v-tooltip="$strings[$language].deviceTypes.door.tooltips.lock" name="lock-open" class="not-state" scale="3" />

                    </div>
                    <div  class="state-container" @click="setLock(false)" v-if="this.lock == true">
                        <v-icon name="lock-open" class="state" scale="10" />
                        <v-icon v-tooltip="$strings[$language].deviceTypes.door.tooltips.unlock" name="lock" class="not-state" scale="3" />

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

export default {

    name: 'Door',

    components: {
       
    },
    props: [
    'device'
    ],
    data () {
        return {
            name: 'Door',
            state:this.device.meta.state,
            lock:this.device.meta.lock


        }
    },
    methods:{
        closeModal(){
            this.$emit('closeMe')
        },
        setState(state) {
            console.log(state)
            this.state=state
            this.device.setState(state).catch((error) => {
                console.log(error)
                console.log(error)
            })
        },
            setLock(lock) {
                console.log(lock)
                this.lock=lock
                this.device.setLock(lock).catch((error) => {
                    console.log(error)
                })
            }
    }
}
</script>

<style lang="sass" scoped>



.state-container
    display: flex
    flex: 1
    align-items: center
    justify-content: center
    cursor: pointer


.not-state-container
    display: flex
    flex: 1
    align-items: center
    justify-content: center
    cursor: pointer
.door
    display: flex
    flex: 1
    padding: 8px
    border: 1px solid black

.state
    display: flex
    flex: 1

.not-state
    display: flex
    flex: 1 
    border: 1px solid black   
.setting-op
    display: flex
    flex: 1
    flex-direction: column
    justify-content: space-around   
    border-top: 1px solid black
    width: 100%



.body
    display: flex
    flex: 2
    height: 100%
    align-items: center
    justify-content: space-around


.name
    flex: 1
    height: 100%
    justify-content: center

</style>
