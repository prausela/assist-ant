import api from '../ApiServiceProvider.js'
import { axios } from '../ApiServiceProvider.js'

class Rooms {
	static get url() {
		return api.baseUrl + '/' + 'rooms';
	}

	get url(){
		return Rooms.url;
	}

	add(room){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			axios.post(this.url, {
		  		name: room.name,
		  		meta: room.meta
			})
			.then(function(response) {
				//api.eventBus.$emit('refreshDevices')
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
			axios.put(this.url + '/' + room.id, {
		  		name: room.name,
		  		meta: room.meta
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
			axios.delete(this.url + '/' + room.id)
			.then(function(response) {
				//api.eventBus.$emit('refreshDevices')
				resolve(response)
			})
			.catch(function(error){
				reject(error)
			});
		});
	}

}

export default Rooms;