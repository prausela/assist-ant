import Devices from "./Devices.js"
import { axios } from '../ApiServiceProvider.js'


class Device {
	constructor(device){
		this.id = device.id;
		this.name = device.name;
		this.type = device.type;
		this.meta = device.meta;
	}

	get url(){
		return Devices.url + '/' + this.id;
	}

	perform(action){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			axios.put(this.url + '/' + action)
			.then(function(response){
				console.log(response);
				resolve(response.data);
			})
			.catch(function(error){
				console.log(error);
			});
		});
	}
}

export default Device;