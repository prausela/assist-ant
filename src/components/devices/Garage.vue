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
                        <img class="garage-img" src="@/assets/devices/garage.png">
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
                            <img class="garage-op" src="@/assets/modes/garage-open.png">
                            <img class="garage-op" src="@/assets/modes/garage-close.png">
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

export default {

    name: 'Garage',

    components: {
       
    },
    props: [
    'device'
    ],
    data () {
        return {
            name: 'Garage',
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
    cursor: pointer


.heigh
    display: flex
    flex: 1
    align-items: center
    justify-content: space-around
.garage-img
    width: 150px
    height: 150px

.body
    display: flex
    flex: 2
    height: 100%
    align-items: center
    justify-content: space-around
.garage-op
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

.button.is-primary
  box-shadow: inset 0 0 9px rgba(0, 0, 0, 0.5)
  background-color: rgb(0, 132, 204)
  font-size: 14px
.button.is-primary:hover
    background-color: #276cda
    border-color: transparent
    color: #fff
</style>
