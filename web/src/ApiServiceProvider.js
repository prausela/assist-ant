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
		// this.source = new EventSource(this.baseUrl + "/devices/events");
		console.log(this.baseUrl + "/devices/events")
		this.routines = new Routines()
		this.urls = {}
		
		console.log('initializing')
		
	}

	get baseUrl(){
		console.log('getting urls', this.urls)
		if (!this.urls) {
			return "http://127.0.0.1:8080/api"
		} else {
			return this.urls.uri 
				+ ':' + this.urls.port
				+ '/' + this.urls.url;
		}
	}

	get timeout() {
		return 60 * 1000;
	}

	initialize() {
		return new Promise((resolve, reject) => {
			axios.get(('./config.json')).then((response) => {
				this.urls = response.data.api
				
				this.devicesTypes.getAll()
				// this.source.addEventListener('message', (e) =>{
				// 	// Se recibio un evento (emito el refresh)
				//   console.log('new event', e.data)
				//   console.log('refreshing devices')
				//   this.eventBus.$emit('refreshDevices')

				// }, false)
				resolve()
			})
		})
	}

	setLanguage(language) {
		this.language = language
	} 

	testConnection() {
		console.log('testing connection')
		let roomsUrl = this.rooms.url
		return axios.get(roomsUrl, {
			timeout: 2000
		})
	}
}

export default new api();