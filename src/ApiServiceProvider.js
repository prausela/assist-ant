import Config from './config.js'
import Devices from './apiProvider/Devices.js'
import DevicesTypes from './apiProvider/DevicesTypes.js'
export const axios = require('axios');

let api = class {

	/* API Modules */
	constructor() {
		this.devices = new Devices();
		this.devicesTypes = new DevicesTypes();
	}

	static get devices(){
		return Devices;
	}

	/* API Conectivity Methods */

	static get baseUrl(){
		return Config.api.uri 
			+ ':' + Config.api.port
			+ '/' + Config.api.url;
	}

	static get timeout() {
		return 60 * 1000;
	}
}

export default api;