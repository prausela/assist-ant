

class Action{
	construct(device, action, params){
		this.deviceId = device.id
		this.actionName = action
		this.params = params
	}
}

export default Action