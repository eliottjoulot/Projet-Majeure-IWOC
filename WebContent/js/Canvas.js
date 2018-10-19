/**
 * Gestion du Canvas
 */

setInterval(function(){$.get("rest/cmd/trajectoire",function(data, status) { 
	var c=document.getElementById("mon_canvas");
    var context=c.getContext("2d");
    var RobotButton=document.getElementById("RobotButton");
    var TrajectoireButton=document.getElementById("TrajectoireButton");
    var ObstaclesButton=document.getElementById("ObstaclesButton");

    context.clearRect(0,0,mon_canvas.width,mon_canvas.height);
    context.beginPath(); 

// Rectangle et position départ
context.strokeStyle='black';
context.strokeRect(0,0,400,400);

context.closePath();

context.beginPath(); 
context.moveTo(data.data[0].value[0]*40+10,data.data[1].value[0]*40+10);

var x_robot;
var y_robot;
/*************************AFFICHAGE TRAJECTOIRE*************************/

	for(j in data.data[0].value){
		context.fillStyle='green';
		context.fillRect((data.data[0].value[j])*40,(data.data[1].value[j])*40,40,40);
		context.fillRect((data.data[0].value[j])*40,(data.data[1].value[j])*40,40,40);
		}
	
/*************************AFFICHAGE TRAJECTOIRE*************************/
if(TrajectoireButton.checked){
	for(j in data.data[0].value){

		context.lineTo((data.data[0].value[j])*40+20,(data.data[1].value[j])*40+20);
		context.moveTo((data.data[0].value[j])*40+20,(data.data[1].value[j])*40+20);
		context.strokeStyle="#33CCFF";
		context.stroke(); 
	}
}

 /**************************AFFICHAGE ROBOT******************************/
if(RobotButton.checked){
	for(j in data.data[0].value){
		x_robot=(data.data[0].value[j])*40;
		y_robot=(data.data[1].value[j])*40;
	}
	DessinerTriangle(x_robot,y_robot,data.data[4].value,context);
}
	
context.beginPath(); 
	
/**************************AFFICHAGE OBSTACLES********************************/
if(ObstaclesButton.checked){	
for(i in data.data[2].value){
		context.fillStyle="#CCCCCC";
		context.fillRect((data.data[2].value[i])*40,(data.data[3].value[i])*40,40,40);
		// alert("Tracer trajectoire IN FOR, x: "+data.data[0].value[j]+"
		// y:"+data.data[1].value[k]);
		context.stroke(); 
	}
}
	
	context.closePath();
	context.beginPath(); 
})},100);

setInterval(function(data, status) {
	/** ***************************AUTO MAPPING*******************************/
	/*if (AutoMapping.checked) {
		$.ajax({
			url : 'rest/cmd/AUTOMAPPING', // La ressource ciblée
			type : 'POST', // Le type de la requête HTTP.
			data : "{\"login\":" + $.cookie('login') + ",\"token\":\""+ $.cookie('token')+"\"}",
			success : function(data, status) {
				// alert("AutoMapping OK");

			}
		})
	}*/
		 
}, 100);

function DessinerTriangle(x_robot,y_robot,orientation,context){
	context.fillStyle='black';
	context.save();	
	x_robot=x_robot+10;
	y_robot=y_robot+10;
	switch(orientation){
	case "S":
		context.moveTo(x_robot,y_robot);
		context.lineTo(x_robot+20,y_robot);
		context.lineTo(x_robot+10,y_robot+20);
		
		break;
	case "N":
		context.moveTo(x_robot,y_robot+10);
		context.lineTo(x_robot+20,y_robot+10);
		context.lineTo(x_robot+10,y_robot-10);	
		break;
	case "W":
		context.moveTo(x_robot+10,y_robot+20);
		context.lineTo(x_robot+10,y_robot);
		context.lineTo(x_robot-10,y_robot+10);
		break;
	case "E":
		context.save();	
		context.moveTo(x_robot-10,y_robot+20);
		context.lineTo(x_robot-10,y_robot);
		context.lineTo(x_robot+10,y_robot+10);	
		break;
	default:
		alert("Erreur Triangle dessin!");
	}
	context.fill();
	context.restore();
	context.closePath();
	return ;
};
