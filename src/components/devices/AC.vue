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
                        <switches class="switch" type-bold="true" theme="bulma" color="blue" v-model="enabled"></switches>
                        <div class="temp-input">
                            <div class="form-label">Temperatura</div>
                            <div class="form-field">
                                <input  placeholder="°C">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="setting-op" :class="{invisible: !enabled}">
                    <div class="op-body">
                        <div class="name">Ventilador</div>
                        <div class="body">
                            <v-icon name="minus" class="mode" scale="1" />
                            <img class="fan-img" src="@/assets/modes/fan-25.png">
                           <!--  <img class="fan-img" src="@/assets/modes/fan-50.png">
                            <img class="fan-img" src="@/assets/modes/fan-75.png">

                            <img class="fan-img" src="@/assets/modes/fan-100.png"> -->

                            <v-icon name="plus" class="mode" scale="1" />
                            <div class="empty"></div>
                            <div class="empty"></div>
                            <div class="empty"></div>

                        </div>
                    </div>
                    <div class="op-body">
                        <div class="name">Modo</div>
                        <div class="body">
                            <v-icon name="sun" class="ac-img"  />
                            <v-icon name="snowflake" class="ac-img"  />
                            <img class="fan-img3 ac-img" src="@/assets/devices/fan.png">
                            <div class="empty"></div>
                            <div class="empty"></div>
                            <div class="empty"></div>


                        </div>
                    </div>
                    <div class="op-body">
                        <div class="name">Swing Vertical</div>
                        <div class="body">
                            <img class="ac-img" src="@/assets/modes/swing.png">
                            <img class="ac-img" src="@/assets/modes/swing-22.png">
                            <img class="ac-img" src="@/assets/modes/swing-45.png">
                            <img class="ac-img" src="@/assets/modes/swing-67.png">
                            <img class="ac-img" src="@/assets/modes/swing-90.png">
                            <div class="empty"></div>

                        </div>
                    </div>
                    <div class="op-body">
                        <div class="name">Swing Horizontal</div>
                        <div class="body">
                            <img class="ac-img" src="@/assets/modes/h-auto.png">
                            <img class="ac-img" src="@/assets/modes/h--90.png">
                            <img class="ac-img" src="@/assets/modes/h--45.png">
                            <img class="ac-img" src="@/assets/modes/h-0.png">
                            <img class="ac-img" src="@/assets/modes/h-45.png">                            
                            <img class="ac-img" src="@/assets/modes/h-90.png">                            
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

    name: 'AC',

    components: {
        Switches
    },
    props: [
    'device'
    ],
    data () {
        return {
            name: 'AC',
            enabled:true
        }
    },
    methods:{
        closeModal(){
            this.$emit('closeMe')
        }
    }
}
</script>

<style lang="sass" scoped>


.invisible
     opacity: 0



.ac-pimg
    width: 150px
    height: 150px
.ac-img
    border: 1px solid black
    width: 30px
    height: 30px
    cursor: pointer



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
</style>