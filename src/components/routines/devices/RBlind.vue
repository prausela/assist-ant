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
                            <img class="blind-img" src="@/assets/modes/blind-open.png" v-if="this.state == true ">
                            <img class="blind-img" src="@/assets/modes/blind-close.png" v-if="this.state == false ">
                            
                    </div>
                    <div class="arrow-container">
                        <div v-tooltip="state ? $strings[$language].deviceTypes.blind.tooltips.up.upped : $strings[$language].deviceTypes.blind.tooltips.up.to_up" class="arrow-s" @click="setState(true)"  :class="{active: state == true}">
                            <v-icon name="arrow-up" class="arrow" scale="3" />
                        </div>
                        <div v-tooltip="state ? $strings[$language].deviceTypes.blind.tooltips.down.to_down : $strings[$language].deviceTypes.blind.tooltips.down.downed" class="arrow-s" @click="setState(false)"   :class="{active: state == false}">
                            <v-icon name="arrow-down"  class="arrow" scale="3"  />
                        </div>
                    </div>
                </div>
                <div class="setting-op">
                    
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

export default {

    name: 'Blind',

    components: {
       
    },
    props: [
    'device', 'routine'
    ],
    data () {
        return {
            name: 'Blind',
            state: false
        }
    },
    methods:{
        closeModal(){
            this.$emit('closeMe')
        },
        setState(state) {
            if (state == this.state) {
                return
            }
            let action = "down"
            if (state) {
                action = "up"
            }
            let a = this.$api.routines.createAction(this.device, action, [])
            this.routine.addAction(a)
            this.state = state
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
            if (action.actionName == 'up') {
                this.state = true
            } else if( action.actionName == "down") {
                this.state = false

            }
        }
    })
    }
}
</script>

<style lang="sass" scoped>

.image-container
    display: flex
    flex: 1
    align-items: center
    justify-content: center
.arrow-container
    display: flex
    flex: 1
    align-items: center
    justify-content: center
    

.arrow-s
    border: 1px solid black
    margin: 2px
    &.active
        background-color: #b1aeae
        box-shadow: inset 0 0 9px rgba(0, 0, 0, 0.5)


.arrow
    padding: 8px
    margin: 2px
    cursor: pointer
    

.heigh
    display: flex
    flex: 1
    align-items: center
    justify-content: space-around
.blind-img
    width: 150px
    height: 150px

.body
    display: flex
    flex: 2
    height: 100%
    align-items: center
    justify-content: space-around
.blind-op
    width: 40px
    height: 40px
    border: 1px solid black
    align-items: center
    padding: 2px
    cursor: pointer



.name
    display: flex
    flex: 1
    height: 100%
    justify-content: center
    align-items: center

.button.is-primary
  box-shadow: inset 0 0 9px rgba(0, 0, 0, 0.5)
  background-color: rgb(0, 132, 204)
  font-size: 14px
.button.is-primary:hover
    background-color: #276cda
    border-color: transparent
    color: #fff

</style>
