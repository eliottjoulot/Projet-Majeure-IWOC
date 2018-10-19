$(document).ready(function() {	

	
	$("#ButtonGo").click(function() {
		$.post("rest/index/GO", {}, function(data, status) {
			//alert("Post Done received data: " + data + "\nStatus: " + status);
		});

	});
	$("#ButtonStop").click(function() {

		$.post("rest/index/STOP", {}, function(data, status) {
			//alert("Post Done received data: " + data + "\nStatus: " + status);
		});

	});

	
});