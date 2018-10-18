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
                    <div  class="state-container" @click="setState(true)"  v-if="this.state == false">
                        <v-icon name="door-closed" class="state" scale="10" />
                        <v-icon v-tooltip="$strings[$language].deviceTypes.door.tooltips.close" name="door-open" class="not-state" scale="3" />

                    </div>
                    <div class="state-container" @click="setState(false)"  v-if="this.state == true">
                        <v-icon name="door-open" class="state" scale="10" />
                       <v-icon v-tooltip="$strings[$language].deviceTypes.door.tooltips.open" name="door-closed" class="not-state" scale="3" />
                      
                    </div>
                </div>
                <div class="column-container">
                    <div class="state-container" @click="setLock(false)" v-if="this.lock == true">
                        <v-icon name="lock" class="state" scale="10" />
                        <v-icon v-tooltip="$strings[$language].deviceTypes.door.tooltips.lock" name="lock-open" class="not-state" scale="3" />

                    </div>
                    <div  class="state-container" @click="setLock(true)" v-if="this.lock == false">
                        <v-icon name="lock-open" class="state" scale="10" />
                        <v-icon  n v-tooltip="$strings[$language].deviceTypes.door.tooltips.unlock" name="lock" class="not-state" scale="3" />

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

export default {

    name: 'RDoor',

    components: {
       
    },
    props: [
        'device', 'routine'
    ],
    data () {
        return {
            name: 'Door',
            state: false,
            lock: false
        }
    },
    methods:{
        closeModal(){
            this.$emit('closeMe')
            this.routine.actions.forEach((action)=> {
                console.log(action.actionName)
            })
        },
        setState(state) {
            if (state == this.state) {
                return
            }
            let action = "close"
            if (state) {
                action = "open"
            }
            let a = this.$api.routines.createAction(this.device, action, [])
            this.routine.addAction(a)
            this.state = state
        },
        setLock(lock) {
            if (lock == this.lock) {
                return
            }
            let action = "unlock"
            if (lock) {
                action = "lock"
            }
            let a = this.$api.routines.createAction(this.device, action, [])
            this.routine.addAction(a)
            this.lock = lock
        },
        removeFromRoutine() {
            this.routine.removeDevice(this.device)
            this.closeModal()
        }
    },
    mounted() {
        this.routine.actions.forEach((action) => {
            if (action.deviceId == this.device.id) {
                console.log(action)
                if (action.actionName == 'close') {
                    this.state = false
                } else if( action.actionName == "open") {
                    this.state = true
                }
                if (action.actionName == 'lock') {
                    this.lock = true
                } else if( action.actionName == "unlock") {
                    this.lock = false
                }
            }
        })
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

.button.is-primary
  box-shadow: inset 0 0 9px rgba(0, 0, 0, 0.5)
  background-color: rgb(0, 132, 204)
  font-size: 14px
.button.is-primary:hover
    background-color: #276cda
    border-color: transparent
    color: #fff

</style>
