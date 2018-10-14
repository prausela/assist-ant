import api from '../ApiServiceProvider.js'
import { axios } from '../ApiServiceProvider.js'
import Rooms from './Rooms.js'

class Room{
	constructor(){

	}

	assign(device){
		return new Promise((resolve, reject) =>{
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
		Rooms.url + '/' + this.id;
	}

	get urn(){
		Rooms.urn + '/' + this.id;
	}
}

export default Room;