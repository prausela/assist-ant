import Vue from 'vue'
import App from './App.vue'

// Vue  Icons

import 'vue-awesome/icons'
/* Register component with one of 2 methods */
import Icon from 'vue-awesome/components/Icon'
import config from './config/config.js'
// globally (in your main .js file)
Vue.component('v-icon', Icon)
Vue.prototype.$config = config


// ControlButtonsFooter
import ControlButtonsFooter from './components/ControlButtonsFooter'
Vue.component('cbfooter', ControlButtonsFooter)


Vue.config.productionTip = false

new Vue({
  render: h => h(App)
}).$mount('#app')
