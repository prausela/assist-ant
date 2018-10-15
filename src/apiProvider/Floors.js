import Rooms from './Rooms.js'
import Floor from './APIRooms/Floor.js'


class Floors extends Rooms{

	getAll(){
		return this.getAllWithCategory("floor", Floor)
	}

	delete(floor){
		return new Promise((resolve, reject)=>{
			let promises = []
			floor.roomIds.forEach((roomId)=>{
				promises.push(super.delete(roomId))
			})
			Promise.all(promises)
			.then(()=>{
				super.delete(floor.id)
				.then((response)=>{
					resolve(response.data)
				})
				.catch((error)=>{
					reject()
				})
			})
			.catch((error)=>{
				reject()
			})
		})
	}
}

export default Floors