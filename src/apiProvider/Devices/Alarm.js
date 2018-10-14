import Device from '../Device.js'

class Alarm extends Device {

	constructor(device){
		super(device);
	}

	changeSecurityCode(){
		return this.perform("changeSecurityCode");
	}

	armStay(){
		return this.perform("armStay");
	}

	armAway(){
		return this.perform("armStay");
	}

	disarm(){
		return this.perform("disarm");
	}
};

export default Alarm;