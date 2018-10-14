import Device from '../Device.js'

class Refrigerator extends Device {

	constructor(device){
		super(device);
	}

	//Integer 2-8
	setTemperature(temperature){
		if (temperature < 2 || temperature > 8) {
			return Promise.reject();
		}
		return this.perform("setTemperature", temperature);
	}

	//Integer -20 to -8
	setFreezerTemperature(temperature){
		if (temperature < 2 || temperature > 8) {
			return Promise.reject();
		}
		return this.perform("setFreezerTemperature", temperature);
	}

	//String "default", "party", "vacation"
	setMode(mode){
		return this.perform("setMode", mode);
	}
};

export default Refrigerator;