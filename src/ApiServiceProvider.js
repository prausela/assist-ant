const axios = require('axios');
import Config from "./config.js"
// import Floor from "./apiProvider/Floor";
import Devices from "./apiProvider/Devices.js"

var api = class {
	constructor() {
		this.devices = Devices
	}

	testAxios() {
		console.log(this)
		console.log(this.baseUrl());
		axios({
			method: 'get',
			url: this.baseUrl() + '/devices'
		}).then(function(response){
			console.log(response.data);
		});
	}

	baseUrl() {
		
		return Config.api.uri + ':' + Config.api.port + Config.api.url; 
	}

	static get timeout() {
		return 60 * 1000;
	}
	/*
	static fetch(url, init) {
	    return new Promise(function(resolve, reject) {
	      var timeout = setTimeout(function() {
	        reject(new Error('Time out'));
	      }, api.timeout);

	      fetch(url, init)
	      .then(function(response) {
	        clearTimeout(timeout);
	          if (!response.ok)
	            reject(new Error(response.statusText));

	          return response.json();
	      })
	      .then(function(data) {
	          resolve(data);
	      })
	      .catch(function(error) {
	          reject(error);
	      });
	    });
	}
	*/
}

export default new api()
