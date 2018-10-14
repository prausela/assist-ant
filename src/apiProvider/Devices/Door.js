import Device from '../Device.js'

class Door extends Device {

	constructor(device){
		super(device);
	}

	open(){
		return this.perform("open");
	}

	close(){
		return this.perform("close");
	}

	lock(){
		return this.perform("lock");
	}

	unlock(){
		return this.perform("unlock");
	}
};

export default Door;