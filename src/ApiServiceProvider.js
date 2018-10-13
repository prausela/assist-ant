import Config from './config.js'
import Devices from './apiProvider/Devices.js'
import DevicesTypes from './apiProvider/DevicesTypes.js'
export const axios = require('axios');
import Vue from 'vue';

class api {

	/* API Modules */
	constructor() {
		this.devices = new Devices()
		this.devicesTypes = new DevicesTypes()
		this.eventBus = new Vue()
	}

	get baseUrl(){
		return Config.api.uri 
			+ ':' + Config.api.port
			+ '/' + Config.api.url;
	}

	get timeout() {
		return 60 * 1000;
	}

	initialize() {
		this.devicesTypes.getAll()
	}
}

export default new api();