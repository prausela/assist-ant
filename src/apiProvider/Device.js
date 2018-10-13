import Devices from "./Devices.js"
import { axios } from '../ApiServiceProvider.js'

let device = class Device {
	constructor(id, name, type){
		this.id = id;
		this.name = name;
		this.type = type;
	}

	get getUrl(){
		return Devices.getUrl + '/' + this.id;
	}

	perform(action, if_ok, if_error){
		// eslint-disable-next-line
		return new Promise((resolve, reject) => {
			axios.put(this.getUrl + '/' + action)
			.then(if_ok)
			.catch(if_error);
		});
	}
}

export default device;