import Device from '../Device.js'
import Strings from '@/Strings.json'
import api from '@/ApiServiceProvider.js'
import config from '@/config.js'

class AC extends Device {

	constructor(device){
		super(device);
		if(typeof(this.meta.state) == "undefined") {
			this.meta.state = false
		}
		if(typeof(this.meta.temperature) == "undefined") {
			this.meta.temperature = config.deviceTypes.ac.defaultTemperature
		}
		if(typeof(this.meta.verticalSwing) == "undefined") {
			this.meta.verticalSwing = config.deviceTypes.ac.defaultVS
		}
		if(typeof(this.meta.horizontalSwing) == "undefined") {
			this.meta.horizontalSwing = config.deviceTypes.ac.defaultHS
		}
		if(typeof(this.meta.speed) == "undefined") {
			this.meta.speed = config.deviceTypes.ac.defaultSpeed
		}
		if(typeof(this.meta.mode) == "undefined") {
			this.meta.mode = config.deviceTypes.ac.defaultMode
		}
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
			if( temperature < 18 || temperature > 38) {
				reject({
					message: Strings[api.language].deviceTypes.ac.errors.invalidRange
				})
			}

			this.perform("setTemperature", [ temperature ]).then((response) => {
				let newMeta = this.copyMeta()
				newMeta.color = color
				this.updateMeta(newMeta).catch((error) => {
					reject(error)
				})
			}).catch((error) => {
				reject(error)
			})
		})
	}

	//String "cool", "heat", "fan"
	setMode(mode){
		return new Promise((resolve, reject) => {

			this.perform("setMode", [ mode ]).then((response) => {
				let newMeta = this.copyMeta()
				newMeta.color = color
				this.updateMeta(newMeta).catch((error) => {
					reject(error)
				})
			}).catch((error) => {
				reject(error)
			})
		})
	}

	//String auto, 22, 45, 67, 90
	setVerticalSwing(swing){
		return new Promise((resolve, reject) => {

			this.perform("setVerticalSwing", [ swing ]).then((response) => {
				let newMeta = this.copyMeta()
				newMeta.color = color
				this.updateMeta(newMeta).catch((error) => {
					reject(error)
				})
			}).catch((error) => {
				reject(error)
			})
		})
	}

	//String auto, -90, -45, 0, 45, 90
	setHorizontalSwing(swing){
		return new Promise((resolve, reject) => {

			this.perform("setHorizontalSwing", [ swing ]).then((response) => {
				let newMeta = this.copyMeta()
				newMeta.color = color
				this.updateMeta(newMeta).catch((error) => {
					reject(error)
				})
			}).catch((error) => {
				reject(error)
			})
		})
	}

	//String auto, 25, 50, 75, 100
	setFanSpeed(speed){
		return new Promise((resolve, reject) => {

			this.perform("setFanSpeed", [ speed ]).then((response) => {
				let newMeta = this.copyMeta()
				newMeta.color = color
				this.updateMeta(newMeta).catch((error) => {
					reject(error)
				})
			}).catch((error) => {
				reject(error)
			})
		})
	}
};

export default AC;