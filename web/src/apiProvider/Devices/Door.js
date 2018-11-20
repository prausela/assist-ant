import Device from '../Device.js'

class Door extends Device {

	constructor(device){
		super(device)

		if(typeof(this.meta.state) == "undefined") {
			this.meta.state = false
		}

		if(typeof(this.meta.lock) == "undefined") {
			this.meta.lock = false
		}

		this.actions.push("setState", "setLock")
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
				}).then(() => {
					resolve()
				})
			}).catch((error) => {
				reject(error)
			})
		})
	}

	refreshMeta() {
		return new Promise((resolve,reject) => {
			this.getState().then((state) => {
				let result = state.result
				let newMeta = this.copyMeta()
				if (result.status == "closed") {
					newMeta.state = false
				} else if (result.status == "opened") {
					newMeta.state = true
				}
				if (result.lock == "locked") {
					newMeta.lock = true
				} else if (result.lock == "unlocked") {
					newMeta.lock = false
				}
				console.log(state)
				console.log('newmeta', newMeta)
				this.meta = newMeta
				resolve()
				this.updateMeta(newMeta).catch((error) => {
					console.log(error)
				})
			}).catch((error) => {
				console.log(error)
			})
		})
	}
}

export default Door;