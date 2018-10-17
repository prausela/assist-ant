import Device from '../Device.js'

class Blind extends Device {

	constructor(device){
		super(device);
		if(typeof(this.meta.state) == "undefined") {
			this.meta.state = false
		}
		this.actions.push("setState")
	}

	//Boolean true = up, false = down
	setState(state){
		return new Promise((resolve, reject) => { 
			let action = state ? "up": "down";
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

	refreshMeta() {
		this.getState().then((state) => {



			let result = state.result
			console.log(result)
			let newMeta = this.copyMeta()
			if (result.status == "opened" || result.status == "opening") {
				newMeta.state = true
			} else if (result.status == "opening") {
				newMeta.state = false
			}
			console.log('newmeta', newMeta)
			this.updateMeta(newMeta).catch((error) => {
				reject(error)
			})
		}).catch((error) => {
			console.log(error)
		})
	}
}

export default Blind;