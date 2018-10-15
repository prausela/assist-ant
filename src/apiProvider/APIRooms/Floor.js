import APIRoom from '../APIRoom.js'
import Rooms from '../Rooms.js'

class Floor extends APIRoom {
	constructor(floor){
		super(floor);
		this.roomIds = []
		let newMeta = JSON.parse(this.meta)
		newMeta.category = "floor"
		newMeta.rooms = this.roomIds
		this.meta = JSON.stringify(this.meta)
	}

	add(room){
		this.roomIds.push(room.id)
		let meta = JSON.parse.room.meta
		meta.floor = this.id
		room.meta = JSON.stringify(meta)
		Rooms.add(room)
	}

	get rooms(){
		return new Promise((resolve, reject) => {
			axios.get(this.url)
			.then(function(response) {
				let roomsObjects = []

				let rooms = response.data.rooms.filter((room) =>{
					return JSON.parse(room.meta).category == category && this.roomIds.includes(room.id)
				})
				rooms.forEach((room)=>{
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
}

export default Floor