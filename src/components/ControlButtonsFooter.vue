<template>
    <div class="control-buttons">
        <div class="footer-icon">
            <v-icon name="star" scale="2" />

        </div>
        <div class="footer-icon">
            <v-icon name="pencil-alt" scale="2" />

        </div>
        <div class="footer-icon">
            <v-icon name="trash-alt" scale="2" />

        </div>


    </div>
</template>

<script>
export default {

  name: 'ControlButtonsFooter',

  data () {
    return {

    }
  }
}
</script>

<style lang="sass" scoped>
.control-buttons
    border-top: 1px solid black
    display: flex
    padding: 4px 0
    justify-content: center
    width: 100%
    align-items: center
.footer-icon
    flex: 1
    justify-content: center
    display: flex

.footer-icon:first-child
    border-right: 1px solid black

.footer-icon:nth-child(2)
    border-right: 1px solid black

</style>