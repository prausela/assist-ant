import api from '../ApiServiceProvider.js'
import { axios } from '../ApiServiceProvider.js'
import Routines from './Routines.js'

class Routine {
	get url(){
		return Routines.url + this.urn
	}

	get urn(){
		return '/' + this.id
	}

	construct(routine){
		this.actions = routine.actions
		this.id = routine.id
		this.name = routine.name
	}

	execute(){
		return new Promise((resolve, reject) => {
			axios.put(this.url + '/' +'execute', parameters)
			.then(function(response){
				if (!response.data.result) {
					reject({
						message: "Unknown error"
					})
				}
				resolve(response.data);
			})
			.catch(function(error){
				console.log(error)
			});
		});
	}
}


export default Routine