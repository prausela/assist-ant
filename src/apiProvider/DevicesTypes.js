'use strict'

import api from '../ApiServiceProvider.js'
import { axios } from '../ApiServiceProvider.js'
import config from '@/config.js'

class DevicesTypes {

	

	getAll() {
		return new Promise((resolve,reject) => {
			if (this.types) {
				resolve(this.types)
			} else {
				this.downloadTypes().then((types) => {
					this.types = types
					resolve(this.types)
				}).catch((error) => {
					reject(error)
				})
			}
		})
	}

	getUrl() {
		return api.baseUrl + '/devicetypes'	
	}

	downloadTypes() {
		return new Promise ((resolve, reject) => {
			axios.get(this.getUrl()).then( (response) => {
				let types = response.data.devices
				let deviceTypes = {}
				types.forEach((type) => {
					deviceTypes[type.id] = type
					deviceTypes[type.id].label = config.deviceTypes[type.name].label
					deviceTypes[type.id].canAdd = config.deviceTypes[type.name].canAdd
					deviceTypes[type.id].component = config.deviceTypes[type.name].component
				})
				resolve(deviceTypes)
			}).catch ((error) => {
				console.log(error)
			})
		})
	}
}


export default DevicesTypes