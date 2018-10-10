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
                    
                </div>
                <div class="setting-op">
                    <div class="set freeze">
                        <div class="name"> Temperatura Freezer </div>
                        <div class="body">
                            
                        </div>

                    </div>
                    <div class="set temp">
                        <div class="name"> Temperatura Heladera </div>
                        <div class="body">
                        </div>
                    </div>
                    <div class="set mode">
                        <div class="name"> Mode </div>
                        <div class="body">
                            <v-icon name="suitcase" class="suitcase" scale="2" />
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
    flex: 1
    justify-content: center
    width: 100%

.setting-op
    display: flex
    flex: 1
    flex-direction: column
    justify-content: space-around   
    width: 100%
   

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

.suitcase
    border: 1px solid black
    padding: 2px



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