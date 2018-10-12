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
                            <img class="blind-img" src="@/assets/devices/blind.png">
                    </div>
                    <div class="arrow-container">
                        <v-icon name="arrow-up" class="arrow" scale="3" />
                        <v-icon name="arrow-down"  class="arrow" scale="3" border=1px />
                    </div>
                </div>
                <div class="setting-op">
                    <div class="heigh">
                        <div class="name">
                            Modo
                        </div>
                        <div class="body">
                            <img class="blind-op" src="@/assets/modes/blind-open.png">
                            <img class="blind-op" src="@/assets/modes/blind-close.png">
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
.arrow
    padding: 8px
    border: 1px solid black
    margin: 2px

.setting-op
    display: flex
    flex: 1
    flex-direction: column
    justify-content: space-around   
    width: 100%

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


.name
    display: flex
    flex: 1
    height: 100%
    justify-content: center
    align-items: center

</style>
