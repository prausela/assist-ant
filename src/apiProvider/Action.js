

class Action{
	constructor(device, action, params){
		console.log('constructing action', device, action, params)
		this.deviceId = device.id
		this.actionName = action
		this.params = params
	}
}

export default Action