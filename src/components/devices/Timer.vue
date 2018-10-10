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
                    </div>
                </div>
                <div class="setting-op">
                    <div class="set heat">
                        <div class="name"> Heat </div>
                        <div class="body">
                            <img class="op" src="@/assets/modes/oven-conventional.png">
                            <img class="op" src="@/assets/modes/oven-bottom.png">
                            <img class="op" src="@/assets/modes/oven-top.png">
                        </div>

                    </div>
                    <div class="set grill">
                        <div class="name"> Grill </div>
                        <div class="body">
                           <div>Large</div>
                            <v-icon name="leaf" class="op"  scale="1" />
                        </div>
                    </div>
                    <div class="set conv">
                        <div class="name"> Convection </div>
                        <div class="body">
                            <div>Normal</div>
                            <v-icon name="leaf" class="op"  scale="1" />

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
    flex: 1
    justify-content: center
    width: 100%

.setting-op
    display: flex
    flex: 1
    flex-direction: column
    justify-content: space-around   
    width: 100%
   

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
    flex: 1
    justify-content: center
    align-items: center
    display: flex

.op
    width: 30px
    height: 30px
    border: 1px solid black
    padding: 3px
</style>