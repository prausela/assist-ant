import Device from '../Device.js'

class Alarm extends Device {

	constructor(device){
		super(device);
		this.actions.push("changeSecurityCode", "armStay", "armAway", "disarm")
	}

	/*
		Security codes are Strings that range from "0000" to "9999"
		Default security code is "1234"
	*/

	changeSecurityCode(old_code, new_code){
		return this.perform("changeSecurityCode", [ old_code, new_code ]);
	}

	armStay(code){
		return this.perform("armStay", [ code ]);
	}

	armAway(code){
		return this.perform("armStay", [ code ]);
	}

	disarm(code){
		return this.perform("disarm", [ code ]);
	}
};

export default Alarm;