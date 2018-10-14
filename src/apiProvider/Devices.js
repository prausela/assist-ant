import api from '../ApiServiceProvider.js'
import { axios } from '../ApiServiceProvider.js'
import Lamp from './Devices/Lamp.js'
import Device from './Device.js'

class Devices{
	static get url() {
		return api.baseUrl + '/devices';
	}

	get url(){
		return api.baseUrl + '/devices';
	}

	add(device){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			axios.post(this.url, {
				typeId: device.type,
		  		name: device.name,
		  		meta: device.meta
			})
			.then(function(response) {
				api.eventBus.$emit('refreshDevices')
				resolve(response)
			})
			.catch(function(error){
				reject(error)
			});
		});
	}

	getAll(){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			axios.get(this.url)
			.then(function(response) {
				let devices = response.data.devices;
				let devicesObjects = []
				api.devicesTypes.getAll().then((types) => {
					devices.forEach((device) => {
						device.type = types[device.typeId]
						device.meta = JSON.parse(device.meta) || {}
						let deviceObj = {}
						switch (device.type.name) {
							case "lamp":
								deviceObj = new Lamp(device)
								break;
							default:
								deviceObj = new Device(device)
						}
						devicesObjects.push(deviceObj)
					})
					resolve(devicesObjects);
				})
			}).catch(function(error){
				reject({
					message: error
				})
			});
		});
	}

	modify(device){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			//Remember to change to device.url
			console.log(device);
			axios.put(this.url + '/' + device.id, {
				typeId: device.type,
		  		name: device.name,
		  		meta: device.meta
			})
			.then(function(response) {
				console.log(response);
			})
			.catch(function(error){
				console.log(error);
			});
		});
	}

	delete(device){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			//Remember to change to device.url
			axios.delete(this.url + '/' + device.id)
			.then(function(response) {
				api.eventBus.$emit('refreshDevices')
				resolve(response)
			})
			.catch(function(error){
				reject(error)
			});
		});
	}

}

export default Devices;