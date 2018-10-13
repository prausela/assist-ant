import Device from '../Device.js'

let lamp = class Lamp extends Device {

	constructor(id, name){
		super(id, name, "go46xmbqeomjrsjr");
	}

	setState(state){
		const action = state ? "turnOn": "turnOff";
		return this.perform(action, 
			function(response){
				console.log(response);
			},
			function(error){
				console.log(error);
			});
	}

	setColor(color){
		return this.perform("setColor", 
			function(response){
				console.log(response);
			},
			function(error){
				console.log(error);
			});
	}
};

export default lamp;