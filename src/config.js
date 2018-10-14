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
			defaultColor: "#EAFF4D",
			defaultBrightness: 10,
			canAdd: true,
			component: "Light"
		},
		blind: {
			label: {
				english: "Blinds",
				spanish: "Persiana",
			},
			canAdd: true,
			component: "Blind"
		},
		oven: {
			label: {
				english: "Oven",
				spanish: "Horno",
			},
			canAdd: true,
			component: "Oven"
		},
		ac: {
			label: {
				english: "AC",
				spanish: "Aire Acondicionado",
			},
			canAdd: true,
			component: "AC"
		},
		door: {
			label: {
				english: "Door",
				spanish: "Puerta",
			},
			canAdd: true,
			component: "Door"
		},
		alarm: {
			label: {
				english: "Alarm,",
				spanish: "Alarma",
			},
			canAdd: false,
			component: "Alarm"
		},
		refrigerator: {
			label: {
				english: "Refrigerator",
				spanish: "Heladera",
			},
			canAdd: true,
			component: "Refrigerator"
		},
		timer: {
			label: {
				english: "Timer",
				spanish: "Cronometro",
			},
			canAdd: false,
			component: "Timer"
		},
	},
}