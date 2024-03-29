import api from '../ApiServiceProvider.js'
import { axios } from '../ApiServiceProvider.js'
import Routines from './Routines.js'

class Routine {
	get url(){
		return Routines.url + this.urn
	}

	get urn(){
		return '/' + this.id
	}

	constructor(routine){
		if (routine) {
			this.actions = routine.actions
			this.id = routine.id
			this.name = routine.name
		} else {
			this.actions = []
		}
	}

	execute(){
		return new Promise((resolve, reject) => {
			api.routines.clearUnusedDevices(this).then((clearRoutine) => {
				console.log('clear routines:')
				if (clearRoutine.actions.length == 0) {
					resolve()
					return
				} else {
					this.actions = clearRoutine.actions
					api.routines.modify(this).then(() => {
						axios.put(this.url + '/' +'execute', {})
						.then((response) => {
							if (!response.data.result) {
								reject({
									message: "Unknown error"
								})
							}
							let deviceIds = new Set()
							this.actions.forEach((action) => {
								deviceIds.add(action.deviceId)
							})
							api.devices.refreshDevices(deviceIds)
							
							resolve(response.data);
						})
						.catch(function(error){
							console.log(error)
						});
					})
				}
			})
		});
	}

	addAction(action) {
		console.log('adding action', action)
		let reverseAction = null
		switch (action.actionName) {
			case 'turnOn': 
				reverseAction = 'turnOff'
				break;
			case 'turnOff': 
				reverseAction = 'turnOn'
				break;
			case 'open': 
				reverseAction = 'close'
				break;
			case 'close': 
				reverseAction = 'open'
				break;
			case 'lock': 
				reverseAction = 'unlock'
				break;
			case 'unlock': 
				reverseAction = 'lock'
				break;
			case 'setColor': 
				reverseAction = 'setColor'
				break;
			case 'setTemperature': 
				reverseAction = 'setTemperature'
				break;
			case 'setFreezerTemperature': 
				reverseAction = 'setFreezerTemperature'
				break;
			case 'setVerticalSwing': 
				reverseAction = 'setVerticalSwing'
				break;
			case 'setHorizontalSwing': 
				reverseAction = 'setHorizontalSwing'
				break;
			case 'setMode': 
				reverseAction = 'setMode'
				break;
			case 'setFanSpeed': 
				reverseAction = 'setFanSpeed'
				break;
			case 'setConvection': 
				reverseAction = 'setConvection'
				break;
			case 'setHeat': 
				reverseAction = 'setHeat'
				break;
			case 'setGrill': 
				reverseAction = 'setGrill'
				break;
			case 'up':
				reverseAction = 'down'
				break;
			case 'down': 
				reverseAction = 'up'
				break;
		}
		let filteredActions = this.actions.filter((eAction) => {
				if (eAction.actionName == reverseAction && action.deviceId == eAction.deviceId) {
				return false 
			}

			return true
		})
		this.actions = filteredActions
		this.actions.push(action)
	}
	removeDevice(device) {
		let filteredActions = this.actions.filter((action) => {
			return !(action.deviceId == device.id)
		})
		this.actions = filteredActions
	}
}


export default Routine