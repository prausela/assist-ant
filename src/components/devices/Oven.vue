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
                        <img class="oven-img" src="@/assets/oven.png">
                    </div>
                    <div class="switch-container">
                        <switches class="switch" type-bold="true" theme="bulma" color="blue" v-model="enabled"></switches>
                    </div>
                </div>
                <div class="setting-op">
                    <div class="swing">
                       Swing
                    </div>
                    <div class="modes">
                        Mode
                        <v-icon name="sun" class="mode" scale="2" />
                        <v-icon name="snowflake" class="mode" scale="2" />
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

    name: 'Oven',

    components: {
        Switches
    },
    props: [
    'device'
    ],
    data () {
        return {
            name: 'Horno',
            enabled: true,

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

.oven-img
    width: 150px
    height: 150px
.swing
    text-align: left
.mode
    text-align: left
    border: 1px solid black
    padding: 2px

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
</style>