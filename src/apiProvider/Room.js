import api from '../ApiServiceProvider.js'
import { axios } from '../ApiServiceProvider.js'
import Rooms from './Rooms.js'
import Devices from './Devices.js'

class Room{
	constructor(room){
		this.id = room.id
		this.name = room.name
	}

	get devices(){
		return Devices.getFrom(this.url + Devices.urn);
	}

	assign(device){
		return new Promise((resolve, reject) => {
			axios.post(device.url + this.urn)
			.then((response)=>{
				resolve(response)
			})
			.catch((error)=>{
				reject(error)			
			})
		})
	}

	get url(){
		return Rooms.url + this.urn
	}

	get urn(){
		return Rooms.urn + '/' + this.id
	}
}

export default Room;