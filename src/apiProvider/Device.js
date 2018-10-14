import Devices from "./Devices.js"
import api from "@/ApiServiceProvider.js"
import { axios } from '../ApiServiceProvider.js'


class Device {
	constructor(device){
		this.id = device.id
		this.name = device.name
		this.type = device.type
		this.meta = device.meta
	}

	get url(){
		return Devices.url + '/' + this.id
	}

	perform(action, parameters){
		if(!parameters){
			parameters = [];
		}
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			axios.put(this.url + '/' + action, parameters)
			.then(function(response){
				if (!response.data.result) {
					//API rejected petition (Action was not performed)
					reject({
						message: "Unknown error"
					})
				}
				resolve(response.data);
			})
			.catch(function(error){
				console.log(error)
			});
		});
	}

	getState(){
		return this.perform("getState");
	}

	copyMeta() {
		return JSON.parse(JSON.stringify(this.meta))
	}

	updateMeta(newMeta) {
		return api.devices.modify({
			type: this.type,
			name: this.name,
			meta: newMeta,
			id: this.id
		})
	}

	favorite(value) {
		let newMeta = JSON.parse(JSON.stringify(this.meta))
		newMeta.favorite = value
		this.updateMeta(newMeta)
		
	}
}

export default Device;