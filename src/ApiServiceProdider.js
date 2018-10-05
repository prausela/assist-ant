const axios = require('axios');

import Floor from "./apiProvider/Floor"

var api = class {
	static get baseUrl() {
    	return "http://127.0.0.1:8080/api/";
	}

	static get timeout() {
		return 60 * 1000;
	}
}

export default new api {
	
}
