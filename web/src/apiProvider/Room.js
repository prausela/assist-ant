import api from '../ApiServiceProvider.js'
import { axios } from '../ApiServiceProvider.js'
import Rooms from './Rooms.js'
import Devices from './Devices.js'

class Room {
	constructor(room){
		this.id = room.id
		this.name = room.name
		this.meta = room.meta
		this.devices= []
		this.downloadDevices().then((devices) =>{
			this.devices = devices
		}).catch((error) => {
			console.log(error)
		})
	}

	downloadDevices(){
		return Devices.getFrom(this.url + Devices.urn);
	}

	get url(){
		return Rooms.url + this.urn
	}

	get urn(){
		return '/' + this.id
	}

	static urn(id){
		return Rooms.urn + '/' + this.id
	}

	get deviceUrl() {
		return "/rooms/" + this.id
	}

	assign(device){
		return new Promise((resolve, reject) => {
			axios.post(device.url + this.deviceUrl)
			.then((response)=>{
				console.log("device assigned")
				console.log(response)
				resolve(response)
			})
			.catch((error)=>{
				reject(error)			
			})
		})
	}
}

export default Room