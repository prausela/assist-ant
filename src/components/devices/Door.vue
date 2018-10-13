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
                        <v-icon name="door-closed" class="state" scale="10" />
                    </div>
                    <div class="close-container">
                        <v-icon name="door-open" class="door" scale="3" />
                    </div>
                </div>
                <div class="column-container">
                    <div class="image-container">
                        <v-icon name="lock" class="state" scale="10" />
                    </div>
                    <div class="close-container">
                        <v-icon name="lock-open" class="door" scale="3" />
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

    name: 'Door',

    components: {
       
    },
    props: [
    'device'
    ],
    data () {
        return {
            name: 'Door',
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
.state

.close-container
    display: flex
    flex: 1
    align-items: center
    justify-content: center
.door
    padding: 8px
    border: 1px solid black

.setting-op
    display: flex
    flex: 1
    flex-direction: column
    justify-content: space-around   
    border-top: 1px solid black
    width: 100%



.body
    display: flex
    flex: 2
    height: 100%
    align-items: center
    justify-content: space-around


.name
    flex: 1
    height: 100%
    justify-content: center

</style>
