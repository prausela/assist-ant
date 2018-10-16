import api from '../ApiServiceProvider.js'
import { axios } from '../ApiServiceProvider.js'
import Room from './Room.js'
import Strings from '@/Strings.json'

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

	add(room){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			let meta = room.meta || JSON.stringify({})
			console.log(meta)
			axios.post(Rooms.url, {
		  		name: room.name,
		  		meta: meta
			})
			.then(function(response) {
				api.eventBus.$emit('refreshRooms')
				resolve(response)
			})
			.catch(function(err){
				let message = Strings[api.language].rooms.add["addErr" + err.response.data.error.code]
				if (!message) {
					message = Strings[api.language].rooms.add.unknownError
				}
				console.log(message)
				reject({
					message: message
				})
			});
		});
	}

	getAllWithCriteria(criteria, object){
		return new Promise((resolve, reject) => {
			axios.get(this.url)
			.then(function(response) {
				let roomsObjects = []

				let a = response.data.rooms.filter((room) =>{
					return criteria(JSON.parse(room.meta));
				})
				a.forEach((room)=>{
					let r = new object(room) 
					r.meta = JSON.parse(r.meta)
					roomsObjects.push(r)
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
		return this.getAllWithCriteria((meta)=>{
			return !meta.category }, Room)
	}

	modify(room){
		console.log(room)
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			//Remember to change to device.url
			axios.put(this.url + '/' + room.id, {
		  		name: room.name,
		  		meta: room.meta
			})
			.then(function(response) {
				api.eventBus.$emit('refreshRooms')
				resolve(response)
				console.log(response);
			})
			.catch(function(error){
				let message = Strings[api.language].rooms.add["addErr" + err.response.data.error.code]
				if (!message) {
					message = Strings[api.language].rooms.add.unknownError
				}
				console.log(message)
				reject({
					message: message
				})
			});
		});
	}

	delete(room, clearDevices){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			if (clearDevices) {
				let promises = []
				room.devices.forEach((device) => {
					promises.push(device.delete())
				})
				Promise.all(promises).then(() => {
					axios.delete(this.url + '/' + room.id)
					.then(function(response) {
						api.eventBus.$emit('refreshRooms')
						resolve(response)
					})
					.catch(function(error){
						reject(error)
					});
				})
			} else {
				axios.delete(this.url + '/' + room.id)
				.then(function(response) {
					api.eventBus.$emit('refreshRooms')
					resolve(response)
				})
				.catch(function(error){
					reject(error)
				});
				
			}
		});
	}

}

export default Rooms