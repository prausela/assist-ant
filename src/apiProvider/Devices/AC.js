import Device from '../Device.js'

class AC extends Device {

	constructor(device){
		super(device);
	}

	//Boolean true turns on, false off
	setState(state){
		const action = state ? "turnOn": "turnOff";
		return this.perform(action);
	}

	//Integer between 18 and 38
	setTemperature(temperature){
		if (temperature < 18 || temperature > 38) {
			return Promise.reject();
		}
		return this.perform("setTemperature", [ temperature ]);
	}

	//String "cool", "heat", "fan"
	setMode(mode){
		return this.perform("setMode", [ mode ]);
	}

	//String auto, 22, 45, 67, 90
	setVerticalSwing(swing){
		return this.perform("setVerticalSwing", [ swing ]);
	}

	//String auto, -90, -45, 0, 45, 90
	setHorizontalSwing(swing){
		return this.perform("setHorizontalSwing", [ swing ]);
	}

	//String auto, 25, 50, 75, 100
	setFanSpeed(speed){
		return this.perform("setFanSpeed", [ speed ]);
	}
};

export default AC;