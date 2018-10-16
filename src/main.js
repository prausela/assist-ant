import Vue from 'vue'
import App from './App.vue'


// Registering Components
import 'vue-awesome/icons'
import Icon from 'vue-awesome/components/Icon'
Vue.component('v-icon', Icon)
import Icono from "./components/Icon.vue"
Vue.component('icono', Icono)
// Bulma
import './../node_modules/bulma/css/bulma.css';


// ControlButtonsFooter
import ControlButtonsFooter from './components/ControlButtonsFooter'
Vue.component('cbfooter', ControlButtonsFooter)

import DevicesList from "@/components/body/DevicesList.vue"
Vue.component('DevicesList', DevicesList)


// Toaster
import Toaster from 'v-toaster'
import 'v-toaster/dist/v-toaster.css'
Vue.use(Toaster, {timeout: 5000})


// Downloading Api Data
import config from './config.js'
import ApiServiceProvider from './ApiServiceProvider'
import Strings from './Strings.json'
ApiServiceProvider.initialize()
Vue.prototype.$strings = Strings
Vue.prototype.$api = ApiServiceProvider
Vue.prototype.$config = config

Vue.prototype.$refreshDeviceTypes = function() {
	Vue.prototype.$api.devicesTypes.getAll().then((deviceTypes) => {
		Vue.prototype.$deviceTypes = deviceTypes
	})
}
Vue.prototype.$refreshDeviceTypes()


Vue.prototype.$refreshDevices = function() {
	Vue.prototype.$api.devices.getAll().then((devices) => {
		Vue.prototype.$devices = devices
		ApiServiceProvider.eventBus.$emit('devicesRefreshed')
	})
}
Vue.prototype.$refreshDevices()

ApiServiceProvider.eventBus.$on('refreshDevices', () => {
  Vue.prototype.$refreshDevices()
})

Vue.prototype.$refreshRooms = function() {
	Vue.prototype.$api.rooms.getAll().then((rooms) => {
		Vue.prototype.$rooms = rooms
		ApiServiceProvider.eventBus.$emit('roomsRefreshed')
		console.log("Rooms refreshsed")
	})
}
Vue.prototype.$refreshRooms()

ApiServiceProvider.eventBus.$on('refreshRooms', () => {
  Vue.prototype.$refreshRooms()
})

Vue.prototype.$language = "spanish"




Vue.config.productionTip = false

new Vue({
  render: h => h(App)
}).$mount('#app')
