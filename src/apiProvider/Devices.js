import API from '../ApiServiceProvider.js'
import { axios } from '../ApiServiceProvider.js'

class Devices{

	get url(){
		return API.baseUrl + '/devices';
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

	modify(device){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			//Remember to change to device.url
			console.log(device);
			axios.put(this.url + '/' + device.id, {
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

	delete(device){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			//Remember to change to device.url
			console.log(device.id);
			axios.delete(this.url + '/' + device.id)
			.then(function(response) {
				console.log(response);
			})
			.catch(function(error){
				console.log(error);
			});
		});
	}

}

export default Devices;