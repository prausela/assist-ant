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
                <cbfooter :device="device" @closeModal="closeModal" />
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
    'device'
    ],
    data () {
        return {
            name: 'Blind',
            state: this.device.meta.state

        }
    },
    methods:{
        closeModal(){
            this.$emit('closeMe')
        },
        setState(state) {
            console.log(this.state)
            this.state=state
            this.device.setState(state).catch((error) => {
                console.log(error)
            })
        }
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



</style>
