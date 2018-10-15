import Device from '../Device.js'

class Blind extends Device {

	constructor(device){
		super(device);
		if(typeof(this.meta.state) == "undefined") {
			this.meta.state = false
		}
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
}

export default Blind;