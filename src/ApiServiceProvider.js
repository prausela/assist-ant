import Config from './config.js'
import Devices from './apiProvider/Devices.js'
import DevicesTypes from './apiProvider/DevicesTypes.js'
export const axios = require('axios');
import Vue from 'vue';
import Rooms from './apiProvider/Rooms.js'

class api {

	/* API Modules */
	constructor() {
		this.language = "spanish"
		this.eventBus = new Vue()
		this.devices = new Devices()
		this.devicesTypes = new DevicesTypes()
		this.rooms = new Rooms()
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

	setLanguage(language) {
		this.language = language
	} 
}

export default new api();