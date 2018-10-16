export default {
	api: {
		uri: 'http://127.0.0.1',
		port: 8080,
		url: 'api'
	},
	"deviceTypes": {
		"disabledDevices": ["alarm", "timer"],
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
			"component": "Oven",
			"defaults": {
				"heat": "conventional",
				"grill": "off",
				"convection": "off",
				"temperature": 200
			}
		},
		"ac": {
			"canAdd": true,
			"component": "AC",
			"defaults": {
				"temperature": 24,
				"mode": "cool",
				"verticalSwing": "auto,",
				"horizontalSwing": "auto",
				"speed": "25"
			}
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
			"component": "Refrigerator",
			"defaults": {
				"freezerTemperature": -10,
				"temperature": 6,
				"mode": "default"
			}
		},
		"timer": {
			"canAdd": false,
			"component": "Timer"
		}
	}
}