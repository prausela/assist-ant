import API from '../ApiServiceProvider.js'
import { axios } from '../ApiServiceProvider.js'

let devices = class {

	static get getUrl(){
		return API.baseUrl + '/devices';
	}

	static add(device){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			axios.post(this.getUrl, {
				typeId: device.type,
		  		name: device.name,
		  		meta: "{}"
			})
			.then(function(response) {
				console.log(response);
			})
			.catch(function(error){
				console.log(error);
			});
		});
	}

	static getAll(){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			axios.get(this.getUrl)
			.then(function(response) {
				let devices = response.data.devices;
				devices.forEach(function(device){
					delete device.meta;
				});
				resolve({
					message: "",
					devices: devices
				});
			})
			.catch(function(error){
				console.log(error);
			});
		});
	}

	static modify(device){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			//Remember to change to device.getUrl
			console.log(device);
			axios.put(this.getUrl + '/' + device.id, {
				typeId: device.type,
		  		name: device.name,
		  		meta: "{}"
			})
			.then(function(response) {
				console.log(response);
			})
			.catch(function(error){
				console.log(error);
			});
		});
	}

	static delete(device){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			//Remember to change to device.getUrl
			console.log(device.id);
			axios.delete(this.getUrl + '/' + device.id)
			.then(function(response) {
				console.log(response);
			})
			.catch(function(error){
				console.log(error);
			});
		});
	}
}

export default devices;