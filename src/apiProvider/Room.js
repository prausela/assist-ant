var room = class {
	static get url() {
    return api.baseUrl + "rooms/";
  }

  static add(room) {
   return api.fetch(api.room.url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json; charset=utf-8'
      },
      body: JSON.stringify(room)
    });
  }

  static modify(room) {
    return api.fetch(api.room.url + room.id, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json; charset=utf-8'
		},
		body: JSON.stringify(room)
		});
	}

	static delete(id) {
		return api.fetch(api.room.url + id, {
			method: 'DELETE',
		});
	}

	static get(id) {
		return api.fetch(api.room.url + id);
	}

	static getAll() {
		return api.fetch(api.room.url);
	}
}