import Devices from "./Devices.js"
import api from "@/ApiServiceProvider.js"
import { axios } from '../ApiServiceProvider.js'


class Device {
	constructor(device){
		this.id = device.id;
		this.name = device.name;
		this.type = device.type;
		this.meta = device.meta;
	}

	get url(){
		return Devices.url + '/' + this.id;
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
					reject(new Error());
				}
				resolve(response.data);
			})
			.catch(function(error){
				console.log(error);
			});
		});
	}

	getState(){
		return this.perform("getState");
	}

	favorite(value) {
		let modifiedMeta = JSON.parse(JSON.stringify(this.meta))
		modifiedMeta.favorite = value
		console.log('favoriting', value)

		api.devices.modify({
			type: this.type,
			name: this.name,
			meta: modifiedMeta,
			id: this.id
		})
	}
}

export default Device;