import Device from '../Device.js'
import config from '@/config.js'

class Lamp extends Device {

	constructor(device){
		super(device)
		if(typeof(this.meta.state) == "undefined") {
			this.meta.state = false
		}
		if(typeof(this.meta.color) == "undefined") {
			this.meta.color = config.deviceTypes.lamp.defaultColor
		}
		if(typeof(this.meta.brightness) == "undefined") {
			this.meta.brightness = config.deviceTypes.lamp.defaultBrightness
		}
		this.actions.push("setState", "setColor", "setBrightness")
	}

	//Returns a boolean. If the state hasn't change returns false otherwise true.
	setState(state){
		return new Promise((resolve, reject) => { 
			const action = state ? "turnOn": "turnOff";
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

	setColor(color){
		return new Promise((resolve, reject) => {
			this.perform("setColor", [color]).then((response) => {
				let newMeta = this.copyMeta()
				newMeta.color = color
				console.log(newMeta)
				this.updateMeta(newMeta).catch((error) => {
					reject(error)
				})
			}).catch((error) => {
				reject(error)
			})
		})
	}

	setBrightness(brightness){
		return new Promise((resolve, reject) => {
			this.perform("setBrightness", [brightness]).then((response) => {
				let newMeta = this.copyMeta()
				newMeta.brightness = brightness
				console.log(newMeta)
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
			if (result.color) {
				newMeta.color = result.color
			}
			if (result.status == "on") {
				newMeta.state = true
			}
			if (result.status == "off") {
				newMeta.state = false
			}
			if (result.brightness) {
				newMeta.brightness = result.brightness
			}
			this.updateMeta(newMeta).catch((error) => {
				reject(error)
			})
		}).catch((error) => {
			console.log(error)
		})
	}
};

export default Lamp;