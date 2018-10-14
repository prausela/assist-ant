import Device from '../Device.js'

class Refrigerator extends Device {

	constructor(device){
		super(device);
	}

	setTemperature(){
		return this.perform("setTemperature");
	}

	setFreezerTemperature(){
		return this.perform("setFreezerTemperature");
	}

	setMode(){
		return this.perform("setMode");
	}
};

export default Refrigerator;