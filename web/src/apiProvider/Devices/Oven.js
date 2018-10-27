import Device from '../Device.js'
import Strings from '@/Strings.json'
import api from '@/ApiServiceProvider.js'
import config from '@/config.js'

class Oven extends Device {

	constructor(device){
		super(device);
		if(typeof(this.meta.state) == "undefined") {
			this.meta.state = false
		}
		if(typeof(this.meta.temperature) == "undefined") {
			this.meta.temperature = config.deviceTypes.oven.defaults.temperature
		}
		if(typeof(this.meta.heat) == "undefined") {
			this.meta.heat = config.deviceTypes.oven.defaults.heat
		}
		if(typeof(this.meta.grill) == "undefined") {
			this.meta.grill = config.deviceTypes.oven.defaults.grill
		}
		if(typeof(this.meta.convection) == "undefined") {
			this.meta.convection = config.deviceTypes.oven.defaults.convection
		}
		this.actions.push("setState", "setTemperature", "setHeat", "setGrill", "setConvection")

	}

	//Boolean true turns on, false off
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

	//Integer between 18 and 38
	setTemperature(temperature){
		return new Promise((resolve, reject) => {
			if( temperature < 90 || temperature > 230) {
				reject({
					message: Strings[api.language].deviceTypes.oven.errors.invalidRange
				})
			} else {
				this.perform("setTemperature", [ temperature ]).then((response) => {
					let newMeta = this.copyMeta()
					newMeta.temperature = temperature
					this.updateMeta(newMeta).catch((error) => {
						reject(error)
					}).then (() => {
						resolve()
					})
				}).catch((error) => {
					reject(error)
				})
			}
		})
	}



	//String "conventional", "bottom", "top"
	setHeat(heat_mode){
		return new Promise((resolve, reject) => {

			this.perform("setHeat", [ heat_mode ]).then((response) => {
				let newMeta = this.copyMeta()
				newMeta.heat = heat_mode
				this.updateMeta(newMeta).catch((error) => {
					reject(error)
				})
			}).catch((error) => {
				reject(error)
			})
		})
	}

	//String "large", "eco", "off"
	setGrill(grill_mode){
		return new Promise((resolve, reject) => {
			this.perform("setGrill", [ grill_mode ]).then((response) => {
				let newMeta = this.copyMeta()
				newMeta.grill = grill_mode
				this.updateMeta(newMeta).catch((error) => {
					reject(error)
				})
			}).catch((error) => {
				reject(error)
			})
		})
	}

	//String "normal", "eco", "off"
	setConvection(convection_mode){
		return new Promise((resolve, reject) => {
			this.perform("setConvection", [ convection_mode ]).then((response) => {
				let newMeta = this.copyMeta()
				newMeta.convection = convection_mode
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
			if (result.heat) {
				newMeta.heat = result.heat
			}
			if (result.status== "on") {
				newMeta.state = true
			}
			if (result.status== "off") {
				newMeta.state = false
			}
			if (result.temperature) {
				newMeta.temperature = result.temperature
			}
			if (result.grill) {
				newMeta.grill = result.grill
			}
			if (result.convection) {
				newMeta.convection = result.convection
			}
			this.updateMeta(newMeta).catch((error) => {
				reject(error)
			})
		}).catch((error) => {
			console.log(error)
		})
	}

};

export default Oven;