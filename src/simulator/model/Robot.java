package simulator.model;

import simulator.model.Vue_Robot;

public class Robot {
	private int x_robot;
	private int y_robot;
	
	private Environnement envi_robot; //matrice 0 case non vu, 1 case vu
	private Orientation orient_robot;
	private Mesures mesures_robot;
	private int[][]masque;

	
	public Robot(int x_robot,int y_robot, Orientation orient_robot, int x_matrice, int y_matrice){
		this.x_robot=x_robot;
		this.y_robot=y_robot;
		this.envi_robot=new Environnement(x_matrice,y_matrice);
		this.orient_robot=orient_robot;
		this.mesures_robot = new Mesures();
	}
	
	public int[] deplacement_ontab(Deplacement arrow){ //vérifie la sortie de case
		int [] tab_coord_temp;
		tab_coord_temp = new int [2];
		tab_coord_temp[0]=-1;
		tab_coord_temp[1]=-1;
		
		if(Deplacement.LEFT_ARROW.equals(arrow) && y_robot >=1 ) {
			this.orient_robot=Orientation.GAUCHE;
			tab_coord_temp[0]=x_robot;
			tab_coord_temp[1]=y_robot-1;
		}
		if(Deplacement.RIGHT_ARROW.equals(arrow) && y_robot < envi_robot.getTaille_y()) {
			this.orient_robot=Orientation.DROITE;
			tab_coord_temp[0]=x_robot;
			tab_coord_temp[1]=y_robot+1;
		}
		if(Deplacement.DOWN_ARROW.equals(arrow) && x_robot >=1) {
			this.orient_robot=Orientation.BAS;
			tab_coord_temp[0]=x_robot+1;
			tab_coord_temp[1]=y_robot;
		}
		if(Deplacement.UP_ARROW.equals(arrow) && x_robot < envi_robot.getTaille_x() ) {		
			this.orient_robot=Orientation.HAUT;
			tab_coord_temp[0]=x_robot-1;
			tab_coord_temp[1]=y_robot;
		}
		
		if(tab_coord_temp[0]!=-1 && tab_coord_temp[1]!=-1){
			mesures_robot.majCommande();
			
		}
		
		return tab_coord_temp;
	}
	
	public void deplacement_case(int case_jeu, int tab_coord[]){
		if(case_jeu == 1){
			x_robot = tab_coord[0];
			y_robot = tab_coord[1];
			mesures_robot.addHistorique(tab_coord);
			mesures_robot.majDistance();
		}
		
	}
	
	public void majMesures(int nbr_obstacle_visible, int nbr_obs_rencontre){
		mesures_robot.setNbr_obs_visible(nbr_obstacle_visible);
		mesures_robot.setNbr_obs_rencontre(nbr_obs_rencontre);
	}
	
	
	
	
	public void majEnvi_robot(int x_robot, int y_robot,Orientation orientation){
		this.envi_robot=Vue_Robot.majEnvironnement(x_robot,y_robot,this.envi_robot,orientation);
		
	}
	
	//getter setter
	public int getX_robot() {
		return x_robot;
	}

	public int getY_robot() {
		return y_robot;
	}

	public Environnement getEnvi_robot() {
		return envi_robot;
	}
	
	public int[][] getMasque(){
		return masque;
	}

	public Orientation getOrient_robot() {
		return orient_robot;
	}
	
	public Mesures getMesures_robot(){
		return this.mesures_robot;
	}

	public void setX_robot(int x_robot) {
		this.x_robot = x_robot;
	}

	public void setY_robot(int y_robot) {
		this.y_robot = y_robot;
	}

	public void setEnvi_robot(Environnement envi_robot) {
		this.envi_robot = envi_robot;
	}

	public void setOrient_robot(Orientation orient_robot) {
		this.orient_robot = orient_robot;
	}

	public void setMesures_robot(Mesures mesures_robot) {
		this.mesures_robot = mesures_robot;
	}
	
	public void majMasque() {
		this.masque=Vue_Robot.orienter_masque(this.orient_robot);
	}
	
	
	

}
