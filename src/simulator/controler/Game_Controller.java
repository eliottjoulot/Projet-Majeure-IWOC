package simulator.controler;

import simulator.model.*;

public class Game_Controller {
	
	private int x_depart=1;
	private int y_depart=1;
	private int x_matrice=30;
	private int y_matrice=40;
	private double proba=0.1;
	private Orientation orientation_depart=Orientation.BAS;
	private Robot robot_jeu;
	private Environnement environnement_jeu;
	
	public Game_Controller() {
		this.robot_jeu = new Robot(x_depart,y_depart,orientation_depart,x_matrice,y_matrice);
		this.environnement_jeu = new Environnement(x_matrice,y_matrice,proba);
		this.robot_jeu.majEnvi_robot(robot_jeu.getX_robot(),robot_jeu.getY_robot(),robot_jeu.getOrient_robot());
		System.out.println("Je passe ici \n");
	}
	
	public void deplacement_robot(Deplacement arrow){
		int [] tab_coord_temp;
		tab_coord_temp = new int [2];
		tab_coord_temp = robot_jeu.deplacement_ontab(arrow);
		
		if(tab_coord_temp[0] != -1 && tab_coord_temp[1] != -1){
			int case_jeu;
			case_jeu=environnement_jeu.getCellule(tab_coord_temp[0], tab_coord_temp[1]);
			this.robot_jeu.deplacement_case(case_jeu, tab_coord_temp);
		}
		
		//Dans tous les cas mise a jour de la vue
		this.robot_jeu.majEnvi_robot(this.robot_jeu.getX_robot(),this.robot_jeu.getY_robot(),this.robot_jeu.getOrient_robot());
		
		
		int nbr_obstacle_visible = Vue_Robot.majObstacle_visible(this.environnement_jeu, this.robot_jeu.getX_robot(),
				this.robot_jeu.getY_robot(), this.robot_jeu.getOrient_robot());
		System.out.println("\n" + nbr_obstacle_visible +" \n");
		
		int nbr_obstacle_rencontre = Vue_Robot.majObstacle_rencontre(this.environnement_jeu, this.robot_jeu.getEnvi_robot());
		
		//TODO maj compteur obstacle vu et visible
		this.robot_jeu.majMesures(nbr_obstacle_visible, nbr_obstacle_rencontre);
		this.robot_jeu.getMesures_robot().afficherMesures();
	}
	



	//Une méthode permettant de retourner ce que perçoit le capteur de vision du robot
	public void majMasque_robot(){
		this.robot_jeu.majMasque();
		}
	
	
	//Une méthode permettant de récupérer l’environnement utilisé Env.
	public Environnement getEnvironnement_jeu() {
		return this.environnement_jeu;
	}
	
	//Une méthode permettant de récupérer l’environnement perçu par le Robot
	public Environnement getEnvironnement_robot(){
		return this.robot_jeu.getEnvi_robot();
	}



	//Getters
	//Setters
	//Utiles?
	
	public int getX_depart() {
		return x_depart;
	}

	public void setX_depart(int x_depart) {
		this.x_depart = x_depart;
	}

	public int getY_depart() {
		return y_depart;
	}

	public void setY_depart(int y_depart) {
		this.y_depart = y_depart;
	}

	public int getX_matrice() {
		return x_matrice;
	}

	
	public void setX_matrice(int x_matrice) {
		this.x_matrice = x_matrice;
	}

	public int getY_matrice() {
		return y_matrice;
	}
	
	public void setY_matrice(int y_matrice) {
		this.y_matrice = y_matrice;
	}
	
	public double getProba() {
		return proba;
	}
	
	public void setProba(double proba) {
		this.proba = proba;
	}

	public Orientation getOrientation_depart() {
		return orientation_depart;
	}

	public void setOrientation_depart(Orientation orientation_depart) {
		this.orientation_depart = orientation_depart;
	}

	public Robot getRobot_jeu() {
		return robot_jeu;
	}
	
	public void setRobot_jeu(Robot robot_jeu) {
		this.robot_jeu = robot_jeu;
	}

	public void setEnvironnement_jeu(Environnement environnement_jeu) {
		this.environnement_jeu = environnement_jeu;
	}
	
	
}
