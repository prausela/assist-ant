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
                    <div class="switch-container">
                        
                        <div class="temp-input">
                            <div class="form-label">Temperatura Heladera</div>
                            <div class="form-field">
                                <input  placeholder="°C">
                            </div>
                        </div>
                        <div class="temp-input">
                            <div class="form-label">Temperatura Freezer</div>
                            <div class="form-field">
                                <input  placeholder="°C">
                            </div>
                        </div>
                    </div>
                    
                </div>
                <div class="setting-op">
                    <div class="op-body">
                        <div class="name"> Modo </div>
                        <div class="body">
                            <v-icon name="suitcase" class="mode" scale="2" />
                            <img class="mode" src="@/assets/modes/party.png">

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



.column-container
    display: flex
    flex: 1
    justify-content: center
    width: 100%
    position: relative
.column-container::after
    content: ""
    position: absolute
    left: 50%
    bottom: 0
    height: 1px
    width: 90%
    transform: translateX(-50%)
    background-color: white

.setting-op
    display: flex
    flex: 1
    flex-direction: column
    justify-content: space-around   
    width: 100%
.op-body
    display: flex
    justify-content: space-around
    align-items: center
    text-align: left
    border: 5px
    margin: 5px


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

.mode
    border: 1px solid black
    padding: 2px
    width: 30px
    height: 30px

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