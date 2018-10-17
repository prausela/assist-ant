<template>
	<div class="control-buttons">
		<div class="footer-icon button is-primary" @click="edit">
			<v-icon name="pencil-alt" scale="2" />
			<div v-if="verEdit" class="device">
				<EditRoom :room="room" @closeMe="closeEdit"/>
			</div>
		</div>
		<div @click="showRemoveModal" class="footer-icon button is-primary">
			<v-icon name="trash-alt" scale="2" />
		</div>
    <DeleteDevicesModal v-if="deleteModal" @cancel="deleteModal = false" @confirm="remove(true)" @decline="remove(false)" />
  </div>
</template>

<script>
import EditRoom from "@/components/forms/EditRoom.vue"
import DeleteDevicesModal from "./DeleteDevicesModal"
export default {
  components:{
    DeleteDevicesModal,
    EditRoom
  },

  name: 'RoomFooter',

  props: [
  'room'
  ],
  data () {
    return {
        verEdit:false,
        deleteModal: false
    }
  },
  methods: {
    edit(){
      this.verEdit = true
    },
    showRemoveModal() {
      this.deleteModal = true
    },
    remove(clearDevices) {
      this.$api.rooms.delete(this.room, clearDevices).then(() => {
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