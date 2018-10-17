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
			axios.put(this.url + '/' +'execute', parameters)
			.then(function(response){
				if (!response.data.result) {
					reject({
						message: "Unknown error"
					})
				}
				resolve(response.data);
			})
			.catch(function(error){
				console.log(error)
			});
		});
	}

	addAction(action) {
		let reverseAction = null
		switch (action.actionName) {
			case 'turnOn': 
				reverseAction = 'turnOff'
				break;
			case 'turnOff': 
				reverseAction = 'turnOn'
				break;
			case 'setColor': 
				reverseAction = 'setColor'
				break;
		}

		let filteredActions = this.actions.filter((eAction) => {
			return eAction.actionName != reverseAction

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