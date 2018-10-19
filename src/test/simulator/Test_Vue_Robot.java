//package test.simulator;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//import simulator.model.*;
//
//
//public class Test_Vue_Robot {
//
//	@Test
//	public void majEnvironnement_OK() {
//		
//		System.out.println("\n Test_Vue_Robot majEnvironnement_OK\n");
//		Environnement grille= new Environnement(10,10); 
//		
//		grille=Vue_Robot.majEnvironnement(5,5,grille,Orientation.GAUCHE);
//		grille=Vue_Robot.majEnvironnement(5,5,grille,Orientation.HAUT);
//		grille=Vue_Robot.majEnvironnement(5,5,grille,Orientation.DROITE);
//		grille=Vue_Robot.majEnvironnement(5,5,grille,Orientation.BAS);
//		grille.afficherEnvironnement();
//		
//		
//		assertTrue(true);
//	}
//	
//	@Test
//	public void majEnvironnement_OK2() {
//		
//		System.out.println("\n Test_Vue_Robot majEnvironnement_OK2\n");
//		Environnement grille= new Environnement(6,6); 
//		
//		grille=Vue_Robot.majEnvironnement(5,5,grille,Orientation.GAUCHE);
//		grille=Vue_Robot.majEnvironnement(5,5,grille,Orientation.HAUT);
//		grille=Vue_Robot.majEnvironnement(5,5,grille,Orientation.DROITE);
//		grille=Vue_Robot.majEnvironnement(5,5,grille,Orientation.BAS);
//		grille.afficherEnvironnement();
//		
//		
//		assertTrue(true);
//	}
//	
//	@Test
//	public void majEnvironnement_OK3() {
//		
//		System.out.println("\n Test_Vue_Robot majEnvironnement_OK2\n");
//		Environnement grille= new Environnement(6,6); 
//		
//		grille=Vue_Robot.majEnvironnement(3,3,grille,Orientation.GAUCHE);
//		grille=Vue_Robot.majEnvironnement(3,3,grille,Orientation.GAUCHE);
//		grille.afficherEnvironnement();
//		
//		
//		assertTrue(true);
//	}
//
//}
