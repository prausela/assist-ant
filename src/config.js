export default {
	api: {
		uri: 'http://127.0.0.1',
		port: 8080,
		url: 'api'
	},
	"deviceTypes": {
		"lamp": {
			"defaultColor": "#EAFF4D",
			"defaultBrightness": 10,
			"canAdd": true,
			"component": "Light"
		},
		"blind": {
			"canAdd": true,
			"component": "Blind"
		},
		"oven": {
			"canAdd": true,
			"component": "Oven"
		},
		"ac": {
			"canAdd": true,
			"component": "AC",
			"defaultTemperature": 24,
			"defaultMode": "cool",
			"defaultVS": "auto,",
			"defaultHS": "auto",
			"defaultSpeed": "auto"
		},
		"door": {
			"canAdd": true,
			"component": "Door"
		},
		"alarm": {
			"canAdd": false,
			"component": "Alarm"
		},
		"refrigerator": {
			"canAdd": true,
			"component": "Refrigerator"
		},
		"timer": {
			"canAdd": false,
			"component": "Timer"
		}
	}
}