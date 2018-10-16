<template>
	<div class="control-buttons">
		<div class="footer-icon" @click="edit">
			<v-icon name="pencil-alt" scale="2" />
			<div v-if="verEdit" class="device">
				<!-- <EditRoom :device="device" @closeEdit="closeEdit"/> -->
			</div>
		</div>
		<div @click="remove" class="footer-icon">
			<v-icon name="trash-alt" scale="2" />
		</div>
	</div>
</template>

<script>
// import EditRoom from "@/components/forms/EditRoom.vue"
export default {
  components:{
    // EditRoom
  },

  name: 'RoomFooter',

  props: [
  'room'
  ],
  data () {
    return {
        verEdit:false,
    }
  },
  methods: {
    edit(){
      this.verEdit = true
    },
    remove() {
      this.$api.rooms.delete(this.room).then(() => {
          this.$toaster.success(this.$strings[this.$language].rooms.delete.success)
          this.$emit('closeModal')
      }).catch((error) => {
          console.log(error)
          this.$toaster.error(error)
      })
    },
    closeEdit(){
      this.verEdit = false
    }
  },
  computed: {
  },
  mounted() {

  }
}
</script>

<style lang="sass" scoped>
.control-buttons
    height: 100%
    display: flex
    justify-content: center
    width: 100%
    align-items: center
    cursor: pointer
.favorite
    color: yellow
.footer-icon
    flex: 1
    justify-content: center
    display: flex
    height: 100%
    align-items: center
    cursor: pointer

.footer-icon:first-child
    border-right: 1px solid black
.footer-icon:nth-child(2)
    border-right: 1px solid black

</style>