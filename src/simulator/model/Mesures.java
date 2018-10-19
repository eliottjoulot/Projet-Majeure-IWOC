package simulator.model;

import java.util.ArrayList;

public class Mesures {
	private int nbr_commande=0;
	private int nbr_obs_rencontre=0;
	private int nbr_obs_visible=0;
	private int distance=0;
	
	public ArrayList<int[]> historique_deplacement=new ArrayList<int[]>();
	
	public int getNbr_commande(){
		return this.nbr_commande;
	}
	
	public int getNbr_obs_rencontre(){
		return this.nbr_obs_rencontre;
	}
	
	public int getNbr_obs_visible(){
		return this.nbr_obs_visible;
	}
	
	public int getDistance(){
		return this.distance;
	}
	
	public void majCommande(){
		nbr_commande += 1;
	}
	
	public void majRencontre(){
		nbr_obs_rencontre += 1;
	}
	
	public void majVisible(){
		nbr_obs_visible += 1;
	}
	
	public void majDistance(){
		distance += 1;
	}
	
	
	
	public void setNbr_Commande(int nbr_commande){
		this.nbr_commande=nbr_commande;
	}
	
	public void setNbr_obs_rencontre(int nbr_obstacle_rencontre) {
		this.nbr_obs_rencontre = nbr_obstacle_rencontre;
	}
	
	public void setNbr_obs_visible (int nbr_obs_visible){
	   this.nbr_obs_visible=nbr_obs_visible;
	}
	
	public void setDistance(int distance){
		this.distance = distance;
	}
	
	public void addHistorique(int tab_coord[]) {
		historique_deplacement.add(tab_coord);
	}
	
	public void afficherMesures() {
            System.out.print("distance="+distance+ " ");
            System.out.print("nbr_commande="+nbr_commande+ " ");
            System.out.print("nbr_obs_rencontre="+nbr_obs_rencontre+ " ");
            System.out.print("nbr_obs_visible="+nbr_obs_visible+ " \n ");
		
	}

}
