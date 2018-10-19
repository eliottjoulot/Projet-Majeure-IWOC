/*
 * Gestion des fleches directionnels 
 * 
 * Orientation du robot :
 * 1 : bas
 * 2 : gauche
 * 3 : haut
 * 0 : droite
 */
var orientation_robot = 1;
var previous_x_robot = 0;
var previous_y_robot = 0;


function click_fleche_up() {
	if (isUpdatingCharts == false && isLocked == false) {
		isLocked = true;

		document.getElementById("up").src = "Images/Fleches/fleche_up_click.png";
		$(document).ready(function() {
			$.post("http://localhost:8080/Projet_IWOC/PostMe", {
				cmd : "CmdInfo",
				data : "UP"

			}, function(data, status) {
				alert("\nStatus: " + status);
			});
		});

		// Appel de la fonction qui va mettre à jour le canvas
		MajCanvas();
	}
}

function click_fleche_right() {
	if (isUpdatingCharts == false && isLocked == false) {
		isLocked = true;
		reset_fleche();
		document.getElementById("right").src = "Images/Fleches/fleche_right_click.png";
		$(document).ready(function() {
			$.post("http://localhost:8080/Projet_IWOC/PostMe", {
				cmd : "CmdInfo",
				data : "RIGHT"
			}, function(data, status) {
				// alert("\nStatus: " + status);
			});
		});

		// Appel de la fonction qui va mettre à jour le canvas
		orientation_robot++;
		orientation_robot = orientation_robot % 4;
		MajCanvas();
	}
}

function click_fleche_left() {
	if (isUpdatingCharts == false && isLocked == false) {
		isLocked = true;
		reset_fleche();
		document.getElementById("left").src = "Images/Fleches/fleche_left_click.png";
		// code javascript qui appelle la methode doPost de la servlet
		$(document).ready(function() {
			$.post("http://localhost:8080/Projet_IWOC/PostMe", {
				cmd : "CmdInfo",
				data : "LEFT"
			}, function(data, status) {
				// alert("\nStatus: " + status);
			});
		});

		// Appel de la fonction qui va mettre à jour le canvas
		orientation_robot--;
		if (orientation_robot == -1)
			orientation_robot = 3;
		MajCanvas();
	}
}

function click_fleche_down() {
	if (isUpdatingCharts == false && isLocked == false) {
		isLocked = true;
		reset_fleche();
		document.getElementById("down").src = "Images/Fleches/fleche_down_click.png";
		$(document).ready(function() {
			$.post("http://localhost:8080/Projet_IWOC/PostMe", {
				cmd : "CmdInfo",
				data : "DOWN"
			}, function(data, status) {
				// alert("\nStatus: " + status);
			});
		});

		// Appel de la fonction qui va mettre à jour le canvas
		MajCanvas();
	}
}

function MajCanvas() {
	$(document).ready(
			function() {
				var jsonObjSonar = null;
				// Appel de la fonction qui envoie la commande GET_SONAR
				$.post("http://localhost:8080/Projet_IWOC/PostMe", {
					cmd : "PostInfo",
					data : "GET_SONAR"
				}, function(data, status) {
					// alert("\nData sonar: " + data.x);
					// alert("\nStatus sonar: " + status);
					jsonObjSonar = data;
					var x_map_robot = jsonObjSonar["robot-x"];
					var y_map_robot = jsonObjSonar["robot-y"];
					dessine_robot(x_map_robot, y_map_robot, orientation_robot);

					// Affichage des murs
					for (var i = 0; i < 24; i++) { // 24 = nombre de cases à
						// parcourir envoyées par le
						// sonar
						if (jsonObjSonar.sonar[i].code == 1) {
							// Coordonnées de mur
							var x_map_wall = jsonObjSonar.sonar[i].x
									+ x_map_robot - 2;// Veritables
							// coordonnées dans la
							// map
							var y_map_wall = jsonObjSonar.sonar[i].y
									+ y_map_robot - 2;// Veritables
							// coordonnées dans la
							// map
							dessine_mur(x_map_wall, y_map_wall);
						}
					}
					dessine_trajectoire(previous_x_robot, previous_y_robot,
							x_map_robot, y_map_robot);
					previous_x_robot = x_map_robot;
					previous_y_robot = y_map_robot;
				}, "json");

			});
	isLocked = false;
}