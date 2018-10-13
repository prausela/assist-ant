import Device from '../Device.js'

class Lamp extends Device {

	constructor(id, name){
		super(id, name, "go46xmbqeomjrsjr");
	}

	setState(state){
		const action = state ? "turnOn": "turnOff";
		return this.perform(action);
	}

	setColor(color){
		return this.perform("setColor");
	}

	setBrightness(brightness){
		return this.perform("setBrightness").then(function(data){console.log(data)});
	}

	getState(){
		return this.perform("getState").then(function(data){console.log(data)});
	}
};

export default Lamp;