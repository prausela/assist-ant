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
                        <div class="seg-input">
                            <div class="form-label">Tiempo</div>
                            <div class="form-field">
                                <input  placeholder="Segundos">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="setting-op">
                    
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
.modal-header
    position: relative
.modal-header::after
       content: ""
       position: absolute
       left: 50%
       bottom: 0
       height: 1px
       width: 90%
       transform: translateX(-50%)
       background-color: white
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
    display: flex
    flex: 1
    flex-direction: column
    justify-content: center
    align-items: center
    display: flex
.seg-input
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


.op
    width: 30px
    height: 30px
    border: 1px solid black
    padding: 3px
</style>