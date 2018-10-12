import Api from "../ApiServiceProvider.js"


class Devices {
	getUrl() {
		return Api.baseUrl() + "/devices";
	}

	add(device) {
		return new Promise ((resolve, reject) => {
			setTimeout(() => {
				resolve(true)
			}, 5000);
		})
		
	}
}

export default new Devices