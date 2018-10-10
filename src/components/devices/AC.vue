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
                    </div>
                </div>
                <div class="setting-op">
                    <div class="fan">
                        <div class="name">Ventilador</div>
                        <div class="body">
                            <v-icon name="minus" class="mode" scale="1" />
                            <img class="fan-img" src="@/assets/modes/fan-25.png">
                            <img class="fan-img" src="@/assets/modes/fan-50.png">
                            <img class="fan-img" src="@/assets/modes/fan-75.png">

                            <img class="fan-img" src="@/assets/modes/fan-100.png">

                            <v-icon name="plus" class="mode" scale="1" />

                        </div>
                    </div>
                    <div class="modes">
                        <div class="name">Modo</div>
                        <div class="body">
                            <v-icon name="sun" class="mode" scale="2" />
                            <v-icon name="snowflake" class="mode" scale="2" />
                            <img class="fan-img3" src="@/assets/devices/fan.png">

                        </div>
                    </div>
                    <div class="swing">
                        <div class="name">Swing Vertical</div>
                        <div class="body">
                            <img class="ac-img" src="@/assets/modes/swing.png">
                            <img class="ac-img" src="@/assets/modes/swing-22.png">
                            <img class="ac-img" src="@/assets/modes/swing-45.png">

                            <img class="ac-img" src="@/assets/modes/swing-67.png">
                            <img class="ac-img" src="@/assets/modes/swing-90.png">
                        </div>
                    </div>
                    <div class="swing">
                        <div class="name">Swing Horizontal</div>
                        <div class="body">
                            <img class="ac-img" src="@/assets/modes/swing.png">
                            
                        </div>
                    </div>
                </div>    
            </div>
            <div class="modal-footer">
                <cbfooter />
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
.modal-body
    display: flex
    align-items: center
    width: 100%
.column-container
    display: flex
    justify-content: center
    width: 100%
    height: 50%

.setting-op
    display: flex
    flex-direction: column
    justify-content: space-around   
    width: 100%
    height: 50%
    border-top: 1px solid black
.ac-pimg
    width: 150px
    height: 150px
.ac-img
    border: 1px solid black
    width: 40px
    height: 40px


.swing
    display: flex
    justify-content: space-around
    align-items: center
    text-align: left
.name
    display: flex
    width: 25%
    font-size: 20px
    align-items: center
    justify-content: center

.mode
    text-align: left
    border: 1px solid black
    padding: 2px

.body
    display: flex
    width: 75%
    height: 100%
    justify-content: space-around
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
    flex: 1
    justify-content: center
    align-items: center
    display: flex
.fan
    display: flex
    align-items: center
    justify-content: space-around
.fan-img1
    width: 20px
    height: 20px
    border: 1px solid black
.fan-img2
    width: 30px
    height: 30px
    border: 1px solid black
.fan-img3
    width: 40px
    height: 40px
    border: 1px solid black

.fan-img
    width: 40px
    height: 40px
</style>