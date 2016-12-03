var app01 = new Vue({
	el: '#app01',
	data: {
		message: 'Type in the box',
		locations: '',
		row_id: 0
	},
	methods: {
		update_message: function() {
			var payload = "";
			var response = "";
			var request = new XMLHttpRequest();
			request.onreadystatechange = function() {
				if (request.readyState == 4 && request.status == 200) {
					response = JSON.parse(request.responseText);
					app01.locations = response;
				}
			}
			request.open("POST", "http://localhost:8080/resource", true);
			request.setRequestHeader("Authorization", "Basic " + btoa("user:49a1dacf-6082-4ee2-948f-fabc064ed9a3"));
			request.setRequestHeader("Content-Type", "application/json");
			payload = "{\"name\":\"" + this.message + "\"}";
			request.send(payload);
		},
		edit_row: function(id) {
			console.log("edit row with id " + id);
		}
	}
});