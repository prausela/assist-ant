import Config from './config.js'
import Devices from './apiProvider/Devices.js'
import DevicesTypes from './apiProvider/DevicesTypes.js'
export const axios = require('axios');
import Vue from 'vue';

class api {

	/* API Modules */
	constructor() {
		this.eventBus = new Vue()
		this.devices = new Devices()
		this.devicesTypes = new DevicesTypes()
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