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
		this.actions.push("getState")
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

	refreshMeta() {
		console.log('undefined method for this device')
		this.getState().then((state) => {
			let result = state.result
			console.log('printing state')
			console.log(result)
		})
	}

	delete() {
		return api.devices.delete(this)
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
				reject(error)
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
		return new Promise((resolve,reject) => {
			this.meta = newMeta
			resolve();
		})
		
	}

	favorite(value) {
		let newMeta = JSON.parse(JSON.stringify(this.meta))
		newMeta.favorite = value
		this.meta = newMeta
		api.devices.modify(this,false)
		this.updateMeta(newMeta)
		
	}
}

export default Device;