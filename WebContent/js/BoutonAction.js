/*
 * Gestion des boutons
 * 
 */
var show_robot = new Boolean(true);
var show_obstacle = new Boolean(true);
var show_path = new Boolean(true);

function maj_map() {
  var c = $("canvas")[0].getContext("2d");
  
  var scene = {
    layers: [], 
    renderLayer: function(layer) {
      // data: [array of tiles, 1-based, position of sprite from top-left]
      // height: integer, height in number of sprites
      // name: "string", internal name of layer
      // opacity: integer
      // type: "string", layer type (tile, object)
      // visible: boolean
      // width: integer, width in number of sprites
      // x: integer, starting x position
      // y: integer, starting y position
      if (layer.type !== "tilelayer" || !layer.opacity) { return; }
      var s = c.canvas.cloneNode(),
          size = scene.data.tilewidth;
      s = s.getContext("2d");
      if (scene.layers.length < scene.data.layers.length) {
        layer.data.forEach(function(tile_idx, i) {
          if (!tile_idx) { return; }
          if(layer.name=="robot"&&!show_robot) {return ;}
          if(layer.name=="Obstacles"&&!show_obstacle) {return ;}
          if(layer.name=="chemin"&&show_path) {return ;}
          var img_x, img_y, s_x, s_y,
              tile = scene.data.tilesets[0];
          tile_idx--;
          img_x = (tile_idx % (tile.imagewidth / size)) * size;
          img_y = ~~(tile_idx / (tile.imagewidth / size)) * size;
          s_x = (i % layer.width) * size;
          s_y = ~~(i / layer.width) * size;
          s.drawImage(scene.tileset, img_x, img_y, size, size,
                      s_x, s_y, size, size);
        });
        scene.layers.push(s.canvas.toDataURL());
        c.drawImage(s.canvas, 0, 0);
      }
      else {
        scene.layers.forEach(function(src) {
          var i = $("<img />", { src: src })[0];
          c.drawImage(i, 0, 0);
        });
      }
    },
    renderLayers: function(layers) {
      layers = $.isArray(layers) ? layers : this.data.layers;
      layers.forEach(this.renderLayer);
    },
    loadTileset: function(json) {
      this.data = json;
      this.tileset = $("<img />", { src: json.tilesets[0].image })[0]
      this.tileset.onload = $.proxy(this.renderLayers, this);
    },
    load: function(name) {
      return $.ajax({
        url: "\/ProjetMajeureIWOC/rest/\cmd/map",
        dataType: "text json"
      }).done($.proxy(this.loadTileset, this));
    }
  };

  scene.load("pkm");
};






$(document).ready(function(){
	// ____________ CHECK 1 ____________
	$("#checkbox1").click(function(){
		show_robot=!show_robot;
		$.post("rest/cmd/CHECK1",
				{},
				function(data,status){
					alert("Post Done received data: " + data + "\nStatus: " + status);
				});    
		maj_map();
		});
	
	// ____________ CHECK 2 ____________
	$("#checkbox2").click(function(){
		show_path=!show_path;
		$.post("rest/cmd/CHECK2",
				{},
				function(data,status){
					alert("Post Done received data: " + data + "\nStatus: " + status);
				});   
		maj_map();
		});
	
	// ____________ CHECK 3 ____________
	$("#checkbox3").click(function(){
		show_obstacle=!show_obstacle;
		$.post("rest/cmd/CHECK3",
				{},
				function(data,status){
					alert("Post Done received data: " + data + "\nStatus: " + status);
				});    
		maj_map();
		});
	
	// ____________ CHECK 4 ____________
	$("#checkbox4").click(function(){
		$.post("rest/cmd/CHECK4",
				{},
				function(data,status){
					alert("Post Done received data: " + data + "\nStatus: " + status);
				});    
		});
	
	// ____________ UP ____________
	$("#ButtonUp").click(function(){
		$.post("rest/cmd/UP",
				{},
				function(data,status){
					//alert("Post Done received data: " + data + "\nStatus: " + status);
				}); 
		maj_map();
		});
	
	// ____________ DOWN ____________
	$("#ButtonDown").click(function(){
		$.post("rest/cmd/DOWN",
				{},
				function(data,status){
					//alert("Post Done received data: " + data + "\nStatus: " + status);
				});  
		maj_map();
		});
	
	// ____________ LEFT ____________
	$("#ButtonLeft").click(function(){
		$.post("rest/cmd/LEFT",
				{},
				function(data,status){
					//alert("Post Done received data: " + data + "\nStatus: " + status);
				});  
		maj_map();
		});
	
	// ____________ RIGHT ____________
	$("#ButtonRight").click(function(){
		$.post("rest/cmd/RIGHT",
				{},
				function(data,status){
					//alert("Post Done received data: " + data + "\nStatus: " + status);
				});    
		maj_map();
	});
	
	// ____________ START ____________
	$("#ButtonStart").click(function(){
		$.post("rest/cmd/START",
				{},
				function(data,status){
					alert("Post Done received data: " + data + "\nStatus: " + status);
				});    
	});
	  
	// ____________ RESET ____________
	$("#ButtonReset").click(function(){
		$.post("rest/cmd/START",
				{},
				function(data,status){
					alert("Post Done received data: " + data + "\nStatus: " + status);
				});    
	});
		
	// ____________ STOP ____________
	$("#ButtonStop").click(function(){
		$.post("rest/cmd/STOP",
				{},
				function(data,status){
					alert("Post Done received data: " + data + "\nStatus: " + status);
				});    
	});
		
	
	// ____________ ADMIN START ____________
	$("#ButtonAdminStart").click(function(){
		$.post("rest/cmd/ADMIN_START",
				{},
				function(data,status){
					alert("Post Done received data: " + data + "\nStatus: " + status);
				});    
	});
	
	// ____________ ADMIN STOP ____________
	$("#ButtonAdminStop").click(function(){
		$.post("rest/cmd/ADMIN_STOP",
				{},
				function(data,status){
					alert("Post Done received data: " + data + "\nStatus: " + status);
				});    
	});
	
	
	
	// ____________ LOGIN ____________
	$("#ButtonDisconnect").click(function(){
		$.post("rest/cmd/LOGIN",
				{},
				function(data,status){
					alert("Post Done received data: " + data + "\nStatus: " + status);
				});    
	});
	
	// ____________ DISCONNECT ____________
	$("#ButtonDisconnect").click(function(){
		$.post("rest/cmd/DISCONNECT",
				{},
				function(data,status){
					alert("Post Done received data: " + data + "\nStatus: " + status);
				});    
	});
	
});


