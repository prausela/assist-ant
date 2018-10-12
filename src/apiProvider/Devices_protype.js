
/*
	All API conectivity classes will contain a Hash ["id" : "name"] to 
	enable name given operations

	The API objects name will be used as its identifyier, therefore
	NO TWO DEVICES CAN HAVE THE SAME NAME
	NO TWO ROOMS CAN HAVE THE SAME NAME
	NO TWO FLOORS CAN HAVE THE SAME NAME

*/

var api = "";

//
//
//	Devices
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

/*
	Adds new device to the API and returns a Device class object which could be 
	instance of any of the following types: 

	Blind, Lamp, Oven, AC, Door, Alarm, Timer or Refrigerator
*/
api.devices.add(
	{
		"type" : "blind/lamp/oven/ac/door/alarm/timer/refrigerator",
		"name" : "String",
		"quick_access" : "true/false"
	}
){
	axios({
	  method: 'post',
	  url: api.baseUrl + "devices,
	  data: {
  		"typeId": "go46xmbqeomjrsjr",
  		"name": "table lamp 4",
  		"meta": "{}"
		}
	});
}

/*
	Makes changes to the specified device given as first parameter the current name 
	of the device and the new values as second parameter
*/
room.devices.modify(name,
	{
		"type" : "blind/lamp/oven/ac/door/alarm/timer/refrigerator",
		"name" : "String",
		"quick_access" : "true/false"
	}
);

//Deletes device given its name
api.devices.delete(name);

//Gets device by its name
api.devices.get(name){
	axios({
			method: 'get',
			url: api.getUrl + 'devices',
			responseType: 'stream'
		}).then(function(response){
			console.log(response.data);
		});
}

//Gets every device registered in the API
api.devices.getAll();


//
// Device Object
//
//
//
	
device.assignRoom(room);
device.assignFloor(floor);
device.unlinkRoom(room);
device.unlinkFloor(floor);

//
//	Blinds
//

//
//	Lamps 
//

//
//	Ovens
//

//
//	Air Conditioners
//

//
//	Alarms
//

//
//	Timers
//


//
//
//	Rooms
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

//Adds a new room to the API
api.rooms.add(
	{
		"name" : "String"
	}
);

//Given a rooms name, the specified properties can be changed
api.rooms.modify(name,
	{
		"name" : "String"
	}
);

/*
	Given a rooms name, deletes the room from the API. 
	It should be specified if room devices shall be kept
*/
api.rooms.delete(name, keep_devices);

//Given a rooms name returns the room object corresponding to it
api.rooms.get(name);

//Gets all rooms in the API as an Array of room objects
api.rooms.getAll();

//
//	Room Devices
//
/*
	A room is returned as an Object with the following associated methods
	to interact with it

	The variables floor and room can be replaced with a chained method call.

	***************************************** example ************************************
	**                                                                                  **
	** api.rooms.get({"name" : "kitchen" }).devices.unlink({"name" : "kitchen_light"}); **
	**                                                                                  **
	**************************************************************************************
*/

/*
	Adds a new device to the specified room.
	Returns a Device class object
*/
room.devices.add(
	{
		"type" : "blind/lamp/oven/ac/door/alarm/timer/refrigerator",
		"name" : "String",
		"quick_access" : "true/false"
	}
);
/*
	Makes changes to the specified device given as first parameter the current name 
	of the device and the new values as second parameter
*/
room.devices.modify(name,
	{
		"type" : "blind/lamp/oven/ac/door/alarm/timer/refrigerator",
		"name" : "String",
		"quick_access" : "true/false"
	}
);

//Given device is no longer linked to the room
room.devices.unlinkRoom(name);

//Deletes given device from Devices (it also unlinks it from the room)
room.devices.delete(name);

//Gets a device from the room
room.devices.get(name);

//Gets all devices from the room
room.devices.getAll();


//
//
//	Floors
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

//Adds to the API a new floor with the given name. Returns a Floor class object (chainable)
api.floors.add(
	{
		"name" : "String"
	}
);

/*
	Makes changes to the specified floor given as first parameter the current name 
	of the floor and the new values as second parameter
*/
api.floors.modify(name, 
	{ 
		"name" : "String" 
	}
);

/*
	Deletes floor, given its name, from the API.
	It should be specified wether the linked rooms
	and their respective devices should be kept.
	Keeping is global to the object, it cannot be performed in a
	per case basis.
*/ 
api.floors.delete(name, keep_rooms, keep_devices);

//Given a name gets the asociated floor
api.floors.get(name);

//Gets every floor in the API as an Array
api.floors.getAll();

//
//	Floor Rooms
//
/*
	A floor is returned as an Object with the following associated methods
	to interact with it

	The variables floor and room can be replaced with a chained method call.

	*********************************** example **************************************
	**                                                                              **
	** api.floors.get({"name" : "first_floor" }).rooms.unlink({"name" : "toilet"}); **
	**                                                                              **
	**********************************************************************************
*/

/*
	Adds a new room to the floor.
	The room is added to the API global room Hash.
	Returns a Room class object
*/

floor.rooms.add(
	{
		"name" : "String"
	}
);

/*
	Makes changes to the specified room given as first parameter the current name 
	of the room and the new values as second parameter
*/
floor.rooms.modify(name,
	{
		"name" : "String"
	}
);

//Given room is no longer linked to the floor
floor.rooms.unlink(name);

//Deletes given room from Rooms (it also unlinks it from the floor)
floor.rooms.delete(name, keep_devices);

/*
	Gets a room from the floor. 
	Returns a Room type object.
*/
floor.rooms.get(name);

//Gets all rooms from the floor
floor.rooms.getAll();


//
//
//	Routines
//
//
//
//
//
//
//
//
//
//