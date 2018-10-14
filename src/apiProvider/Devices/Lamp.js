import Device from '../Device.js'

class Lamp extends Device {

	constructor(device){
		super(device);
	}

	//Returns a boolean. If the state hasn't change returns false otherwise true.
	setState(state){
		const action = state ? "turnOn": "turnOff";
		return this.perform(action);
	}

	setColor(color){
		return this.perform("setColor", [ color ]);
	}

	setBrightness(brightness){
		return this.perform("setBrightness", [ brightness ]);
	}
};

export default Lamp;