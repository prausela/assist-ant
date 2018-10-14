import Device from '../Device.js'

class Timer extends Device {

	constructor(device){
		super(device);
	}

	setInterval(){
		return this.perform("setInterval");
	}

	start(){
		return this.perform("start");
	}

	stop(){
		return this.perform("stop");
	}
};

export default Timer;