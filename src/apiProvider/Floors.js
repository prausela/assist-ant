import Rooms from './Rooms.js'
import Floor from './APIRooms/Floor.js'


class Floors extends Rooms{

	getAll(){
		return this.getAllWithCategory("floor", Floor)
	}

}

export default Floors