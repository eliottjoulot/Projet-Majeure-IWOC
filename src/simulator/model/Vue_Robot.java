package simulator.model;


import simulator.model.Environnement;
import simulator.model.Orientation;

public class Vue_Robot {
	//private static int masque[][];
	
	/*public void Vue_Robot(Environnement env_robot, Orientation orientation) {
		this.orientation=orientation;
		this.env_robot=env_robot;
		int [][] masque={
		        { 0, 1, 0} , // tableau [0] de int
		        { 1, 1, 1}, // tableau [1] de int
		        { 1, 1, 1}, // tableau [1] de int
		        { 0, 1, 0} // tableau [1] de int
		    };
		this.masque=masque;
		
	}*/
		public static int[][] orienter_masque(Orientation orientation) {
			int masque[][]={
				    { 0, 1, 0} , // tableau [0] de int
				    { 1, 1, 1}, // tableau [1] de int
				    { 1, 1, 1}, // tableau [2] de int
				    { 0, 1, 0} // tableau [3] de int
				};
			
			if ( orientation==Orientation.DROITE||orientation==Orientation.GAUCHE) {
				masque=new int[][]{
				        { 0, 1, 1, 0} , // tableau [0] de int
				        { 1, 1, 1, 1}, // tableau [1] de int
				        { 0, 1, 1, 0}, // tableau [2] de int
				    };
			}
			return masque;
		}
		
		public static Environnement majEnvironnement(int x_robot, int y_robot, Environnement env_robot,Orientation orientation) {
			int [][] masque=orienter_masque(orientation);
			for(int j = 0; j < masque[0].length; j++){					
	            for(int i = 0; i < masque.length; i++){ 
	            	if(masque[i][j]==1) {
	            		if(orientation==Orientation.HAUT) {
	            			if(env_robot.isCoordIn(x_robot+i-2, y_robot+j-1)) {
	            				env_robot.setCellule(x_robot+i-2, y_robot+j-1);
	            			}
	            		}
	            		if(orientation==Orientation.BAS) {
	            			if(env_robot.isCoordIn(x_robot+i-1, y_robot+j-1)) {
	            				env_robot.setCellule(x_robot+i-1, y_robot+j-1);
	            			}
	            		}
	            		if(orientation==Orientation.DROITE) {
	            			if(env_robot.isCoordIn(x_robot+i-1, y_robot+j-1)) {
	            				env_robot.setCellule(x_robot+i-1, y_robot+j-1);
	            			}
	            		}
	            		if(orientation==Orientation.GAUCHE) {
	            			if(env_robot.isCoordIn(x_robot+i-1, y_robot+j-2)) {
	            				env_robot.setCellule(x_robot+i-1, y_robot+j-2);
	            			}
	            		}
	            	}
	            	
	            }
			}
			return env_robot;
		}
		
		public static int majObstacle_rencontre(Environnement env_jeu, Environnement env_robot){
			int nb_obstacle=0;
			for(int i = 0; i < env_jeu.getTaille_x(); i++){					
	            for(int j = 0; j < env_jeu.getTaille_y(); j++){
	            	if(env_jeu.getCellule(i, j)==3) {
	            		if(env_robot.getCellule(i,j)==1)
	            				nb_obstacle++;	
	            	}
	            }
			}
			return nb_obstacle;
		}
		
		public static int majObstacle_visible(Environnement env_jeu, int x_robot, int y_robot, Orientation orientation_robot){
			int obstacle_visible=0;
			int masque[][]=Vue_Robot.orienter_masque(orientation_robot);
			for(int j = 0; j < masque[0].length; j++){					
	            for(int i = 0; i < masque.length; i++){ 
	            	if(masque[i][j]==1) {
	            		if(orientation_robot==Orientation.HAUT) {
	            			if(env_jeu.isCoordIn(x_robot+i-2, y_robot+j-1)) {
	            				if(env_jeu.getCellule(x_robot+i-2, y_robot+j-1)==3) {
	            					obstacle_visible++;
	            				}
	            			}
	            		}
	            		if(orientation_robot==Orientation.BAS) {
	            			if(env_jeu.isCoordIn(x_robot+i-1, y_robot+j-1)) {
	            				if(env_jeu.getCellule(x_robot+i-1, y_robot+j-1)==3) {
	            					obstacle_visible++;
	            				}
	            			}
	            		}
	            		if(orientation_robot==Orientation.DROITE) {
	            			if(env_jeu.isCoordIn(x_robot+i-1, y_robot+j-1)) {
	            				if(env_jeu.getCellule(x_robot+i-1, y_robot+j-1)==3) {
	            					obstacle_visible++;
	            				}
	            			}
	            		}
	            		if(orientation_robot==Orientation.GAUCHE) {
	            			if(env_jeu.isCoordIn(x_robot+i-1, y_robot+j-2)) {
	            				if(env_jeu.getCellule(x_robot+i-1, y_robot+j-2)==3) {
	            					obstacle_visible++;
	            				}
	            			}
	            		}
	            	}
	            	
	            }
			}
			System.out.println("\n obstacle visible vue robot : " + obstacle_visible +" \n");
			return obstacle_visible;
		}
		
		
		/*public static void main(String[] args) {		//test (a mettre en commentaire)
			Environnement grille= new Environnement(10,10); 
				
			grille=majEnvironnement(5,5,grille,Orientation.GAUCHE);
			grille=majEnvironnement(5,5,grille,Orientation.HAUT);
			grille=majEnvironnement(5,5,grille,Orientation.DROITE);
			grille=majEnvironnement(5,5,grille,Orientation.BAS);
			grille.afficherEnvironnement();
		}*/

}
