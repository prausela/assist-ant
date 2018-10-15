import Device from '../Device.js'

class Door extends Device {

	constructor(device){
		super(device);
	}

	//Boolean true turns on, false off
	setState(state){
		return new Promise((resolve, reject) => { 
			let action = state ? "open": "close";
			this.perform(action).then((response) => {
				let newMeta = this.copyMeta()
				newMeta.state = state
				this.updateMeta(newMeta).catch((error) => {
					reject(error)
				})
			}).catch((error) => {
				reject(error)
			})
		})
	}

	//Boolean true turns on, false off
	setLock(lock){
		return new Promise((resolve, reject) => { 
			let action = lock ? "lock": "unlock";
			this.perform(action).then((response) => {
				let newMeta = this.copyMeta()
				newMeta.lock = lock
				this.updateMeta(newMeta).catch((error) => {
					reject(error)
				})
			}).catch((error) => {
				reject(error)
			})
		})
	}
}

export default Door;