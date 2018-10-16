import Config from './config.js'
import Devices from './apiProvider/Devices.js'
import DevicesTypes from './apiProvider/DevicesTypes.js'
export const axios = require('axios');
import Vue from 'vue';
import Rooms from './apiProvider/Rooms.js'
import Routines from './apiProvider/Routines.js'

class api {

	/* API Modules */
	constructor() {
		this.language = "spanish"
		this.eventBus = new Vue()
		this.devices = new Devices()
		this.devicesTypes = new DevicesTypes()
		this.rooms = new Rooms()
		this.source = new EventSource(this.baseUrl + "/devices/events");
		this.routines = new Routines()
		
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
		this.source.addEventListener('message', (e) =>{
			// Se recibio un evento (emito el refresh)
		  console.log('new event', e.data)
		  this.eventBus.$emit('refreshDevices')


		  // Para Timers, avisar que se terminó
		  if (e.data.event == "timeIsUp") {
		  	this.eventBus.$emit("timeIsUp", e.data.deviceId)
		  }


		}, false)
	}

	setLanguage(language) {
		this.language = language
	} 
}

export default new api();