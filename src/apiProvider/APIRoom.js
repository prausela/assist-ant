import api from '../ApiServiceProvider.js'
import { axios } from '../ApiServiceProvider.js'
import Rooms from './Rooms.js'
import Devices from './Devices.js'

class APIRoom {
	constructor(room){
		this.id = room.id
		this.name = room.name
		this.meta = room.meta
	}

	get devices(){
		return Devices.getFrom(this.url + Devices.urn);
	}

	assign(device){
		return APIRoom.assign(device, this.urn)
	}

	get url(){
		return Rooms.url + this.urn
	}

	get urn(){
		return Rooms.urn + '/' + this.id
	}

	static urn(id){
		return Rooms.urn + '/' + id
	}

	static assign(device, urn){
		return new Promise((resolve, reject) => {
			axios.post(device.url + urn)
			.then((response)=>{
				resolve(response)
			})
			.catch((error)=>{
				reject(error)			
			})
		})
	}
}

export default APIRoom