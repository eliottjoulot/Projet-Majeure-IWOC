//package test.simulator;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//import simulator.model.*;
//import simulator.controler.Game_Controller;
//
//public class Test_Game_Controller {
//
//	@Test
//	public void Creation_deplacement_ok() {
//		System.out.println("_________________________________________\n");
//		System.out.println("_________________________________________\n");
//		System.out.println("_________________________________________\n");
//		System.out.println("_________________________________________\n");
//		System.out.println("_________________________________________\n");
//		System.out.println("_________________________________________\n");
//		System.out.println("_________________________________________\n");
//		System.out.println("_________________________________________\n");
//		System.out.println("Test_Game_Controller Creation_deplacement_ok\n");
//		System.out.println("_________________________________________\n");
//		Game_Controller jeu = new Game_Controller();
//		System.out.println("Environnement du robot\n");
//		
//		jeu.getEnvironnement_robot().afficherEnvironnement();
//		System.out.println(jeu.getRobot_jeu().getX_robot());
//		System.out.println(jeu.getRobot_jeu().getY_robot());
//		
//		jeu.deplacement_robot(Deplacement.DOWN_ARROW);
//		System.out.println(jeu.getRobot_jeu().getX_robot());
//		System.out.println(jeu.getRobot_jeu().getY_robot());
//		System.out.println("Environnement du jeu\n");
//		jeu.getEnvironnement_jeu().afficherEnvironnement();
//		System.out.println("_________________________________________\n");
//		System.out.println("Environnement du robot\n");
//		jeu.getEnvironnement_robot().afficherEnvironnement();
//		System.out.println("_________________________________________\n");
//		System.out.println("Mesures\n");
//		jeu.getRobot_jeu().getMesures_robot().afficherMesures();
//		
//		
//		System.out.println("_________________________________________\n");
//		jeu.deplacement_robot(Deplacement.DOWN_ARROW);
//		System.out.println(jeu.getRobot_jeu().getX_robot());
//		System.out.println(jeu.getRobot_jeu().getY_robot());
//		System.out.println("Environnement du jeu\n");
//		jeu.getEnvironnement_jeu().afficherEnvironnement();
//		System.out.println("_________________________________________\n");
//		System.out.println("Environnement du robot\n");
//		jeu.getEnvironnement_robot().afficherEnvironnement();
//		System.out.println("_________________________________________\n");
//		System.out.println("Mesures\n");
//		jeu.getRobot_jeu().getMesures_robot().afficherMesures();
//		
//		jeu.deplacement_robot(Deplacement.RIGHT_ARROW);
//		System.out.println(jeu.getRobot_jeu().getX_robot());
//		System.out.println(jeu.getRobot_jeu().getY_robot());
//		System.out.println("Environnement du jeu\n");
//		jeu.getEnvironnement_jeu().afficherEnvironnement();
//		System.out.println("_________________________________________\n");
//		System.out.println("Environnement du robot\n");
//		jeu.getEnvironnement_robot().afficherEnvironnement();
//		System.out.println("_________________________________________\n");
//		System.out.println("Mesures\n");
//		jeu.getRobot_jeu().getMesures_robot().afficherMesures();
//		
//		jeu.deplacement_robot(Deplacement.RIGHT_ARROW);
//		System.out.println(jeu.getRobot_jeu().getX_robot());
//		System.out.println(jeu.getRobot_jeu().getY_robot());
//		System.out.println("Environnement du jeu\n");
//		jeu.getEnvironnement_jeu().afficherEnvironnement();
//		System.out.println("_________________________________________\n");
//		System.out.println("Environnement du robot\n");
//		jeu.getEnvironnement_robot().afficherEnvironnement();
//		System.out.println("_________________________________________\n");
//		System.out.println("Mesures\n");
//		jeu.getRobot_jeu().getMesures_robot().afficherMesures();
//		
//		assertTrue(true);
//	}
//
//}
