import Config from './config.js'
import Devices from './apiProvider/Devices.js'
export const axios = require('axios');

let api = class {

	/* API Modules */

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