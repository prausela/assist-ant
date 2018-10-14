import Device from '../Device.js'

class Timer extends Device {

	constructor(device){
		super(device);
	}

	//Given time in seconds to wait. Integer 0 to 21474836
	setInterval(elapsed_time){
		return this.perform("setInterval", [ elapsed_time ]);
	}

	start(){
		return this.perform("start");
	}

	stop(){
		return this.perform("stop");
	}
};

export default Timer;