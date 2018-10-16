import Device from '../Device.js'

class Timer extends Device {

	constructor(device){
		super(device);
	}

	//Given time in seconds to wait. Integer 0 to 21474836
	setInterval(elapsed_time){
		return this.perform("setInterval", [ elapsed_time ]);
	}

	//Boolean true turns on, false off
	getState(){
		return new Promise((resolve, reject) => { 
			this.perform('getState').then((response) => {
				if (response.result.status == "inactive") {
					response.result.status = false
				} else {
					response.result.status = true
				}
				resolve(response.result)
			}).catch((error) => {
				reject(error)
			})
		})
	}

	start(){
		return this.perform("start")
	}

	stop(){
		return this.perform("stop");
	}
};

export default Timer;