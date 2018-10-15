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
                  <NumericKeyboard/>
                <div class="column-container">
                    <div class="image-container">
                        <img class="alarm-img" src="@/assets/devices/alarm.png">
                    </div>
                    <div class="arm">

                        <div class="submit-btn" @click="arm('stay')">Stay</div>

                      
                        <div class="submit-btn" @click="arm('Away')">Away</div>
                        <div class="submit-btn" @click="disarm()">Disarm</div>
                        </div>
                    </div>
                    <div class="setting-op">
                        <div class="btn">
                            <div class="change-btn">Nuevo Codigo</div>
                        </div>
                        <div class="btn">
                            <div class="change-btn">Cambiar Codigo</div>
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
import NumericKeyboard from "@/components/devices/NumericKeyboard.vue"
export default {

    name: 'Alarm',

    components: {
        Switches,
        NumericKeyboard
    },
    props: [
    'device'
    ],
    data () {
        return {
            name: 'Alarm',
            enabled: false,

        }
    },
    methods:{
        closeModal(){
            this.$emit('closeMe')
        }
    },
}
</script>

<style lang="sass" scoped>




.btn
    display: flex
    flex: 1
    justify-content: center
    align-items: center
.change-btn
    display: flex
    background-color: $logo
    color: black
    width: 30%
    align-items: center
    justify-content: space-around
    padding: 5px 15px;
    border-radius: 10px;
    height: 28px
    cursor: pointer


   

.alarm-img
    width: 150px
    height: 100px
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
.arm
    display: flex
    flex: 1
    flex-direction: column
    justify-content: space-around
    align-items: center

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

.submit-btn
    background-color: $logo
    color: black
    width: 30%
    cursor: pointer

</style>