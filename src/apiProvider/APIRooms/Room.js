import APIRoom from '../APIRoom.js'


class Room extends APIRoom {
	constructor(room){
		super(room);
		this.floor = room.floor;
		let newMeta = JSON.parse(this.meta)
		newMeta.category = "room"
		if (this.floor) {
			newMeta.floor = this.floor;
		}
		this.meta = JSON.stringify(this.meta)
	}

	assign(device){
		super.assign(device);
		if(this.floor){
			APIRoom.assign(device, APIRoom.urn(this.floor))
		}
	}
}

export default Room