import Device from '../Device.js'
import Strings from '@/Strings.json'
import api from '@/ApiServiceProvider.js'
import config from '@/config.js'

class Refrigerator extends Device {

	constructor(device){
		super(device);
		if(typeof(this.meta.temperature) == "undefined") {
			this.meta.temperature = config.deviceTypes.refrigerator.defaults.temperature
		}
		if(typeof(this.meta.freezerTemperature) == "undefined") {
			this.meta.freezerTemperature = config.deviceTypes.refrigerator.defaults.freezerTemperature
		}
		if(typeof(this.meta.mode) == "undefined") {
			this.meta.mode = config.deviceTypes.refrigerator.defaults.mode
		}
	}


	//Integer between 2 and 8
	setTemperature(temperature){
		return new Promise((resolve, reject) => {
			if( temperature < 2 || temperature > 8) {
				reject({
					message: Strings[api.language].deviceTypes.refrigerator.errors.invalidRange
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

	//Integer between -20 and -8
	setFreezerTemperature(freezerTemperature){
		return new Promise((resolve, reject) => {
			if( freezerTemperature < -20 || freezerTemperature > -8) {
				reject({
					message: Strings[api.language].deviceTypes.refrigerator.errors.invalidFreezerRange
				})
			} else {
				this.perform("setFreezerTemperature", [ freezerTemperature ]).then((response) => {
					let newMeta = this.copyMeta()
					newMeta.freezerTemperature = freezerTemperature
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
	

	//String "default", "party", "vacation"
	setMode(mode){
		return new Promise((resolve, reject) => {
			this.perform("setMode", [ mode ]).then((response) => {
				let newMeta = this.copyMeta()
				newMeta.mode = mode
				this.updateMeta(newMeta).catch((error) => {
					reject(error)
				})
			}).catch((error) => {
				reject(error)
			})
		})
	}
};

export default Refrigerator;