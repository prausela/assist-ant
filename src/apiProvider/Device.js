import Devices from "./Devices.js"
import api from "@/ApiServiceProvider.js"
import { axios } from '../ApiServiceProvider.js'
import Rooms from "./Rooms.js"


class Device {
	constructor(device){
		this.id = device.id
		this.name = device.name
		this.type = device.type
		this.meta = device.meta

		this.actions = []
		actions.push("getState")
	}

	get url(){
		return Devices.url + this.urn
	}

	get urn(){
		return '/' + this.id
	}

	assignRoom(room){
		return room.assign(this);
	}

	//Dissociates device from Room and Floor
	dissociate(){
		return new Promise((resolve, reject) => {
			axios.delete(this.url + Rooms.urn)
			.then((response) => {
				//api.eventBus.$emit('refreshDevices')
				resolve(response)
			})
			.catch((error) => {
				reject(error)
			});
		});
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