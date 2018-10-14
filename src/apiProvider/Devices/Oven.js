import Device from '../Device.js'

class Oven extends Device {

	constructor(device){
		super(device);
	}

	setState(state){
		const action = state ? "turnOn": "turnOff";
		return this.perform(action);
	}

	//Integer 90-230
	setTemperature(temperature){
		if (temperature < 90 || temperature > 230) {
			return Promise.reject();
		}
		return this.perform("setTemperature", [ temperature ]);
	}

	//String "conventional", "bottom", "top"
	setHeat(heat_mode){
		return this.perform("setHeat", [ heat_mode ]);
	}

	//String "large", "eco", "off"
	setGrill(grill_mode){
		return this.perform("setGrill", [ grill_mode ]);
	}

	//String "normal", "eco", "off"
	setConvection(convection_mode){
		return this.perform("setConvection", [ convection_mode ]);
	}
};

export default Oven;