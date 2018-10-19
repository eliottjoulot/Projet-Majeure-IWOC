//code flèches directionelles

document.onkeydown = function(e) {
    switch (e.keyCode) {
        case 37:
        	$.post("rest/cmd/LEFT",
    				{},
    				function(data,status){
    					//alert("Post Done received data: " + data + "\nStatus: " + status);
    				}); 
    		maj_map();
            break;
        case 38:
    		$.post("rest/cmd/UP",
    				{},
    				function(data,status){
    					//alert("Post Done received data: " + data + "\nStatus: " + status);
    				});  
    		maj_map();
            break;
        case 39: 
        	$.post("rest/cmd/RIGHT",
    				{},
    				function(data,status){
    					//alert("Post Done received data: " + data + "\nStatus: " + status);
    				});    
    		maj_map();
            break;
        case 40:

        		$.post("rest/cmd/DOWN",
        				{},
        				function(data,status){
        					//alert("Post Done received data: " + data + "\nStatus: " + status);
        				});  
        		maj_map();
        		
            break;
    }
};