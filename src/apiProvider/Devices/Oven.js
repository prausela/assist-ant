import Device from '../Device.js'

class Oven extends Device {

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

	setHeat(){
		return this.perform("setHeat");
	}

	setGrill(){
		return this.perform("setGrill");
	}

	setConvection(){
		return this.perform("setConvection");
	}
};

export default Oven;