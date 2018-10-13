'use strict'

import API from '../ApiServiceProvider.js'
import { axios } from '../ApiServiceProvider.js'
import config from '@/config.js'

class DevicesTypes {

	getUrl() {
		return API.baseUrl + '/devicetypes'	
	}

	getAll() {
		return new Promise ((resolve, reject) => {
			axios.get(this.getUrl()).then( (response) => {
				let types = response.data.devices
				let deviceTypes = {}
				types.forEach((type) => {
					deviceTypes[type.id] = type
					deviceTypes[type.id].label = config.deviceTypes[type.name].label
					deviceTypes[type.id].canAdd = config.deviceTypes[type.name].canAdd
				})
				resolve(deviceTypes)
			}).catch ((error) => {
				console.log(error)
			})
		})
	}
}


export default DevicesTypes