import Devices from "./Devices.js"
import { axios } from '../ApiServiceProvider.js'

const devices = new Devices();

class Device {
	constructor(id, name, type){
		this.id = id;
		this.name = name;
		this.type = type;
	}

	get url(){
		return devices.url + '/' + this.id;
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