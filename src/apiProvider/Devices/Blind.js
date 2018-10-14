import Device from '../Device.js'

class Blind extends Device {

	constructor(device){
		super(device);
	}

	up(){
		return this.perform("up");
	}

	down(){
		return this.perform("down");
	}
};

export default Blind;