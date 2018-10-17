import api from '../ApiServiceProvider.js'
import { axios } from '../ApiServiceProvider.js'
import config from '@/config.js'
import AC from './Devices/AC.js'
import Alarm from './Devices/Alarm.js'
import Blind from './Devices/Blind.js'
import Door from './Devices/Door.js'
import Lamp from './Devices/Lamp.js'
import Oven from './Devices/Oven.js'
import Refrigerator from './Devices/Refrigerator.js'
import Timer from './Devices/Timer.js'
import Strings from '@/Strings.json'
import Device from './Device.js'

class Devices{
	static get url() {
		return api.baseUrl + Devices.urn;
	}

	static get urn(){
		return '/' + 'devices';
	}

	get url(){
		return Devices.url;
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
				if (device.room) {
					let newDev = new Device(response.data.device)
					newDev.dissociate().then(() => {
						device.room.assign(newDev).then(() => {
							api.eventBus.$emit('refreshDevices')
							api.eventBus.$emit('refreshRooms')
							resolve(response)
						})
					})
				} else {
					api.eventBus.$emit('refreshDevices')
					resolve(response)
				}
			})
			.catch((err) => {
				let message = Strings[api.language].api.devices["addErr" + err.response.data.error.code]
				if (!message) {
					message = Strings[api.language].api.devices.unknownError
				}
				console.log(message)
				reject({
					message: message
				})
			})
		})
	}

	static getFrom(url){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			axios.get(url)
			.then((response) => {
				let devices = response.data.devices;
				let devicesObjects = []
				api.devicesTypes.getAll().then((types) => {
					devices.forEach((device) => {
						device.type = types[device.typeId]
						device.meta = JSON.parse(device.meta) || {}
						let deviceObj = Devices.initDevice(device)
						if (deviceObj) {
							devicesObjects.push(deviceObj)
						}
					})
					resolve(devicesObjects);
				})
			}).catch((error) => {
				reject({
					message: error
				})
			});
		});
	}

	getAll(){
		return Devices.getFrom(this.url);
	}

	static initDevice(device) {
		let deviceObj = {}
		if (!device.type) {
			return null
		}
		switch (device.type.name) {
			case "ac":
				deviceObj = new AC(device)
				break;
			case "alarm":
				deviceObj = new Alarm(device)
				break;
			case "blind":
				deviceObj = new Blind(device)
				break;
			case "door":
				deviceObj = new Door(device)
				break;
			case "lamp":
				deviceObj = new Lamp(device)
				break;
			case "oven":
				deviceObj = new Oven(device)
				break;
			case "refrigerator":
				deviceObj = new Refrigerator(device)
				break;
			case "timer":
				deviceObj = new Timer(device)
				break;
			default:
				deviceObj = new Device(device)
		}

		return deviceObj
	}

	modify(device, clearRoom){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			//Remember to change to device.url
			axios.put(this.url + '/' + device.id, {
				typeId: device.type.id,
		  		name: device.name,
		  		meta: JSON.stringify(device.meta)
			})
			.then(function(response) {
				let newDev = new Device(device)
				if (device.room) {
					newDev.dissociate().then(() => {
						device.room.assign(newDev).then(() => {
							api.eventBus.$emit('refreshDevices')
							api.eventBus.$emit('refreshRooms')
							resolve(response)
						})
					})
				} else {
					if (clearRoom) {
						newDev.dissociate().then(() => {
							api.eventBus.$emit('refreshDevices')
							api.eventBus.$emit('refreshRooms')
							resolve(response)
						}).catch((error) => {
							console.log("error")
						})  
					} else {
						api.eventBus.$emit('refreshDevices')
						api.eventBus.$emit('refreshRooms')
						resolve(response)
					}
				}
			})
			.catch(function(error){
				console.log(error)
				reject(error)
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
				api.eventBus.$emit('refreshRooms')
				resolve(response)
			})
			.catch(function(error){
				reject(error)
			});
		});
	}

}

export default Devices;