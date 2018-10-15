import api from '../ApiServiceProvider.js'
import { axios } from '../ApiServiceProvider.js'
import Room from './APIRooms/Room.js'

class Rooms {
	static get url() {
		return api.baseUrl + Rooms.urn;
	}

	static get urn(){
		return '/' + 'rooms';
	}

	get url(){
		return Rooms.url;
	}

	static add(room){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			axios.post(this.url, {
		  		name: room.name,
		  		meta: room.meta
			})
			.then(function(response) {
				//api.eventBus.$emit('refreshDevices')
				resolve(response)
			})
			.catch(function(error){
				reject(error)
			});
		});
	}

	add(room){
		Rooms.add(room)
	}

	getAllWithCategory(category, object){
		return new Promise((resolve, reject) => {
			axios.get(this.url)
			.then(function(response) {
				let roomsObjects = []

				let a = response.data.rooms.filter((room) =>{
					return JSON.parse(room.meta).category == category;
				})
				a.forEach((room)=>{
					roomsObjects.push(new object(room))
				})
				resolve(roomsObjects)
			}).catch(function(error){
				reject({
					message: error
				})
			});
		});
	}

	getAll(){
		return this.getAllWithCategory("room", Room)
	}

	modify(rooms){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			//Remember to change to device.url
			console.log(device);
			axios.put(this.url + '/' + room.id, {
		  		name: room.name,
		  		meta: room.meta
			})
			.then(function(response) {
				console.log(response);
			})
			.catch(function(error){
				console.log(error);
			});
		});
	}

	delete(room){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			axios.delete(this.url + '/' + room.id)
			.then(function(response) {
				//api.eventBus.$emit('refreshDevices')
				resolve(response)
			})
			.catch(function(error){
				reject(error)
			});
		});
	}

}

export default Rooms