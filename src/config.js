export default {
	api: {
		uri: 'http://127.0.0.1',
		port: 8080,
		url: 'api'
	},
	deviceTypes: {
		lamp: {
			label: {
				english: "Lamp",
				spanish: "Lampara",
			},
			canAdd: true
		},
		blind: {
			label: {
				english: "Blinds",
				spanish: "Persiana",
			},
			canAdd: true
		},
		oven: {
			label: {
				english: "Oven",
				spanish: "Horno",
			},
			canAdd: true
		},
		ac: {
			label: {
				english: "AC",
				spanish: "Aire Acondicionado",
			},
			canAdd: true
		},
		door: {
			label: {
				english: "Door",
				spanish: "Puerta",
			},
			canAdd: true
		},
		alarm: {
			label: {
				english: "Alarm,",
				spanish: "Alarma",
			},
			canAdd: false
		},
		refrigerator: {
			label: {
				english: "Refrigerator",
				spanish: "Heladera",
			},
			canAdd: true
		},
		timer: {
			label: {
				english: "Timer",
				spanish: "Cronometro",
			},
			canAdd: false
		},
	},
}