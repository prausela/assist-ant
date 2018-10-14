import Device from '../Device.js'

class AC extends Device {

	constructor(device){
		super(device);
	}

	setState(state){
		const action = state ? "turnOn": "turnOff";
		return this.perform(action);
	}

	setTemperature(){
		return this.perform("setTemperature");
	}

	setMode(){
		return this.perform("setMode");
	}

	setVerticalSwing(){
		return this.perform("setVerticalSwing");
	}

	setHorizontalSwing(){
		return this.perform("setHorizontalSwing");
	}

	setFanSpeed(){
		return this.perform("setFanSpeed");
	}
};

export default AC;