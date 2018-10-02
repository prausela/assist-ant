import Vue from 'vue'
import App from './App.vue'
import {Tabs, Tab} from 'vue-tabs-component';
 
Vue.component('tabs', Tabs);
Vue.component('tab', Tab);


// Vue  Icons

import 'vue-awesome/icons'
/* Register component with one of 2 methods */
import Icon from 'vue-awesome/components/Icon'
// globally (in your main .js file)
Vue.component('v-icon', Icon)


// ControlButtonsFooter
import ControlButtonsFooter from './components/ControlButtonsFooter'
Vue.component('cbfooter', ControlButtonsFooter)


Vue.config.productionTip = false

new Vue({
  render: h => h(App)
}).$mount('#app')
