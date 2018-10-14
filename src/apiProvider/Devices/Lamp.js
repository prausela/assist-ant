import Device from '../Device.js'

class Lamp extends Device {

	constructor(device){
		super(device);
	}

	setState(state){
		const action = state ? "turnOn": "turnOff";
		return this.perform(action);
	}

	setColor(color){
		return this.perform("setColor");
	}

	setBrightness(brightness){
		return this.perform("setBrightness");
	}
};

export default Lamp;