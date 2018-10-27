import api from '../ApiServiceProvider.js'
import { axios } from '../ApiServiceProvider.js'
import Routine from './Routine.js'
import Action from './Action.js'

class Routines {
	static get url() {
		return api.baseUrl + Routines.urn;
	}

	static get urn(){
		return '/' + 'routines';
	}

	get url(){
		return Routines.url;
	}

	createRoutine(routine) {
		return new Routine(routine)
	}

	createAction(device, action, params) {
		return new Action(device, action, params)
	}

	/*   actions:[{device: typeof Device, actionName: "actionName", actionParams: ["1234", 11]}]    */

	add(routine){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			// let actionIsValid = true
			// let actions = []
			// routine.actions.forEach((newAction) => {
			// 	if (typeof(newAction.device[newAction.actionName] == "undefined")) {
			// 		reject()
			// 		actionIsValid = false
			// 	} else if(newAction.device[newAction.actionName].length < newAction.actionParams.length){
			// 		reject()
			// 		actionIsValid = false
			// 	} else {
			// 		actions.push({
			// 			deviceId: newAction.device.id,
			// 			actionName: newAction.actionName,
			// 			params: newAction.actionParams,
			// 			meta: JSON.stringify({})
			// 		})
			// 	}
			// })
			// if(actionIsValid){
				let meta = routine.meta || JSON.stringify({})
				axios.post(Routines.url, routine)
				.then(function(response) {
					api.eventBus.$emit('refreshRoutines')
					resolve(response)
				})
				.catch(function(error){
					reject(error)
				});
			// }
		});
	}

	getAll(){
		return new Promise((resolve, reject) => {
			axios.get(this.url)
			.then(function(response) {
				let routinesObjects = []
				response.data.routines.forEach((routine)=>{
					routinesObjects.push(new Routine(routine))
				})

				resolve(routinesObjects)
			}).catch(function(error){
				reject({
					message: error
				})
			});
		});
	}

	modify(routine){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			this.clearUnusedDevices(routine).then((clearRoutine) => {
				axios.put(this.url + '/' + routine.id, routine)
				.then(function(response) {
					api.eventBus.$emit('refreshRoutines')
					resolve(response)
				})
				.catch(function(error){
					console.log(error);
				});
			})
			// }
		});
	}

	delete(routine){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			axios.delete(this.url + '/' + routine.id)
			.then(function(response) {
				//api.eventBus.$emit('refreshDevices')
				api.eventBus.$emit('refreshRoutines')
				resolve(response)
			})
			.catch(function(error){
				reject(error)
			});
		});
	}

	clearUnusedDevices(routine) {
		return new Promise((resolve, reject) => {
			api.devices.getAll().then((devices) => {
				let deviceIds = new Set()
				routine.actions.forEach((action) => {
					deviceIds.add(action.deviceId)
				})
				let idsArrays = Array.from(deviceIds)

				let deletedDevs = idsArrays.filter((devId) => {
					let found = false
					devices.forEach((device) => {
						if( device.id == devId) {
							found = true
						}
					})
					return !found
				})
				deletedDevs.forEach((deletedDevId) => {
					let modified = false
					var filteredActions = routine.actions.filter((action) => {
						if (action.deviceId == deletedDevId) {
							modified = true
							return false
						} else {
							return true
						}
					})
					if (modified) {
						routine.actions = filteredActions
					}
				})
				resolve(routine)
			}).catch((error) => {
				console.log('unabled to get devices', error)
			})
		})
	}

}

export default Routines