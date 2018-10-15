import Room from '../Room.js'

class Floor extends Room {
	constructor(floor){
		super(floor);
		this.rooms = []
		let newMeta = JSON.parse(this.meta)
		newMeta.category = "floor"
		newMeta.rooms = this.rooms
		this.meta = JSON.stringify(this.meta)
	}

	add(room){
		this.rooms.push(room.id)
		Rooms.add(room)
	}

	/*get rooms(){
		let petitions = []
		this.rooms.forEach((room)=>{
			petitions.push(axios.get(room.url))
		})
		axios.all(petitions)
		.then()
	}*/
}

export default Floor