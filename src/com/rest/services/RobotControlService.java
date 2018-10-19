package com.rest.services;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import simulator.controler.Game_Controller;
import simulator.model.Deplacement;

import java.lang.String;

import simulator.controler.*;
import simulator.model.Environnement;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import view.*;

@Path("/cmd")
public class RobotControlService {
	
	private final static String ROBOT_SIMULATOR_LABEL="robot_simulator";
	private final static String MARCHE_LABEL="ready";
	private final static String LOGIN_LABEL="loged";
	private final static String SHOW_ROBOT="show_robot";
	private static volatile RobotControlService instance = null;
	private Game_Controller jeu;
	private boolean marche; // etat du robot
	private boolean login; // connexion ?
	
	//Inject servlet context (needed to get general context, application memory space, session memory space ...)
	@Context
	ServletContext context;
	
	//After RestService construction launches init method
		@PostConstruct
		public void init(){
			Object obj=context.getAttribute(ROBOT_SIMULATOR_LABEL);
			if(obj==null){
				
				this.jeu = new Game_Controller();
				context.setAttribute(ROBOT_SIMULATOR_LABEL, jeu);
			}else{
				this.jeu=(Game_Controller)obj;
				
			}
			
			Object obj_login=context.getAttribute(LOGIN_LABEL);
			if(obj==null){
				this.login = false;
				context.setAttribute(LOGIN_LABEL, login);
			}
			else {
				this.login=(boolean)obj_login;
			}
			
			Object obj_marche=context.getAttribute(MARCHE_LABEL);
			if(obj==null){
				this.marche = false;
				context.setAttribute(MARCHE_LABEL, marche);
			}
			else {
				this.marche=(boolean)obj_marche;
			}
		}
		
		public final static RobotControlService Instance() {
			if (RobotControlService.instance == null) {
				synchronized (RobotControlService.class) {
					if (RobotControlService.instance == null) {
						RobotControlService.instance = new RobotControlService();
					}
				}
			}
			return RobotControlService.instance;
		}

		
		@POST 
		@Produces(MediaType.TEXT_PLAIN)
		@Path("NB_COMMANDES")
		public int recupNbCommandes() {		
			return jeu.getRobot_jeu().getMesures_robot().getNbr_commande();
		}
		
		@POST 
		@Produces(MediaType.TEXT_PLAIN)
		@Path("DISTANCE")
		public int recupDistance() {		
			return jeu.getRobot_jeu().getMesures_robot().getDistance();
		}
		
		@POST 
		@Produces(MediaType.TEXT_PLAIN)
		@Path("NB_OBS_VISIBLE")
		public int recupNbObstacleVisible() {		
			return jeu.getRobot_jeu().getMesures_robot().getNbr_obs_visible();
		}
		
		@POST 
		@Produces(MediaType.TEXT_PLAIN)
		@Path("NB_OBS_RENCONTRE")
		public int recupNbObstacleRencontre() {		
			return jeu.getRobot_jeu().getMesures_robot().getNbr_obs_rencontre();
		}
		
		@POST 
		@Produces(MediaType.TEXT_PLAIN)
		@Path("START")
		public String createGame() {
			jeu=new Game_Controller();
			context.setAttribute(ROBOT_SIMULATOR_LABEL, jeu);
			return "Start Done";
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("REFRESH")
		public String refresh() {
	
			return "Start Done";
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("CHECK1")
		public String showRobot() {
			return "showRobot Done";
			
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("CHECK2")
		public String displayPath() {
			return "displayPath Done";
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("CHECK3")
		public String displayObstacles() {
			return "displayObstacles Done";
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("CHECK4")
		public String autoMapping() {
			return "auto-mapping Done";
		}
		
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("UP")
		public String goUp(String jsonData) {
			String etat="KO";
			(jeu.getEnvironnement_jeu().getEnvironnement())[15][12]=2;
			if(marche){ // Robot en marche ?  this.marche==true
	
				if(true) { // Bien connecté ?
					jeu.deplacement_robot(Deplacement.UP_ARROW);
					/*jeu.getEnvironnement_jeu().afficherEnvironnement();
					System.out.println("_________________________________________\n");
					System.out.println("Environnement du robot\n");
					jeu.getEnvironnement_robot().afficherEnvironnement();*/
					etat="OK";
				}
				
				JSONObject objAuth = new JSONObject();
				objAuth.put("UP ",etat);
				return objAuth.toJSONString();
			}
			return etat;
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("DOWN")
		public String goDown(String jsonData) {
			String etat="KO";
			(jeu.getEnvironnement_jeu().getEnvironnement())[14][12]=2;
			if(marche){ // Robot en marche ?
				
				if(true) { // Bien connecté ? this.marche==true
					jeu.deplacement_robot(Deplacement.DOWN_ARROW);
					/*jeu.getEnvironnement_jeu().afficherEnvironnement();
					System.out.println("_________________________________________\n");
					System.out.println("Environnement du robot\n");
					jeu.getEnvironnement_robot().afficherEnvironnement();*/
					etat="OK";
				}
				
				JSONObject objAuth = new JSONObject();
				objAuth.put("DOWN ",etat);
				return objAuth.toJSONString();
			}
			
			return etat;
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("LEFT")
		public String goLeft(String jsonData) {
			String etat="KO";
			(jeu.getEnvironnement_jeu().getEnvironnement())[13][12]=2;
			if(marche){ // Robot en marche ? this.marche==true
				
				if(true) { // Bien connecté ?
					jeu.deplacement_robot(Deplacement.LEFT_ARROW);
					/*jeu.getEnvironnement_jeu().afficherEnvironnement();
					System.out.println("_________________________________________\n");
					System.out.println("Environnement du robot\n");
					jeu.getEnvironnement_robot().afficherEnvironnement();*/
					etat="OK";
				}
				JSONObject objAuth = new JSONObject();
				objAuth.put("LEFT ",etat);
				return objAuth.toJSONString();
			}	
			return etat;
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("RIGHT")
		public String goRight(String jsonData) {
			String etat="KO";
			(jeu.getEnvironnement_jeu().getEnvironnement())[12][12]=2;
			if(marche){ // Robot en marche ?  this.marche==true
				
				if(true) { // Bien connecté ?
					jeu.deplacement_robot(Deplacement.RIGHT_ARROW);
					/*jeu.getEnvironnement_jeu().afficherEnvironnement();
					System.out.println("_________________________________________\n");
					System.out.println("Environnement du robot\n");
					jeu.getEnvironnement_robot().afficherEnvironnement();*/
					etat="OK";
				}
				JSONObject objAuth = new JSONObject();
				objAuth.put("RIGHT ",etat);
				return objAuth.toJSONString();
			}		
			return etat;
		}
		
		
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("ADMIN_START")
		public String admin_start() {
			this.marche = true;
			context.setAttribute(MARCHE_LABEL, marche);
			return "admin_start Done";
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("ADMIN_STOP")
		public String admin_stop() {
			this.marche = false;
			context.setAttribute(MARCHE_LABEL, marche);
			return "admin_stop Done";
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("LOGIN")
		public String login() {
			this.login = true;
			context.setAttribute(LOGIN_LABEL, login);
			return "login Done";
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("DISCONNECT")
		public String disconnect() {
			this.login = false;
			context.setAttribute(LOGIN_LABEL, login);
			return "disconnect Done";
		}
		
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("env")
		public String getEnv()
				{
			//create Json container Object
			JSONObject objContainer = new JSONObject();
			
			//create set of json objects
			JSONObject objVal1 = new JSONObject();
			objVal1.put("x",new Integer(0));
			objVal1.put("y",new Integer(0));
			objVal1.put("val","FREE");
			JSONObject objVal2 = new JSONObject();
			objVal2.put("x",new Integer(0));
			objVal2.put("y",new Integer(1));
			objVal2.put("val","WALL");
			JSONObject objVal3 = new JSONObject();
			objVal3.put("x",new Integer(1));
			objVal3.put("y",new Integer(1));
			objVal3.put("val","ROBOT");
			
			
			//create a json list
			JSONArray list = new JSONArray();
			//add json objects to jsonlist
			list.add(objVal1);
			list.add(objVal2);
			list.add(objVal3);
			
			//add jsonlist to json container
			objContainer.put("data", list);
			
			//return json string of the json container
			return objContainer.toJSONString();
			
			
			//ALTERNATIVE send direct a json String
			//return "{\"data\":[{\"x\":0,\"y\":0,\"val\":\"FREE\"},{\"x\":0,\"y\":1,\"val\":\"WALL\"},{\"x\":1,\"y\":1,\"val\":\"ROBOT\"}]}";
		}
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("map")
		public String getMap()
				{
					String map=Affichage_Environnement.creation_matrice_JSON(jeu.getEnvironnement_jeu().multiplicationTableau(jeu.getRobot_jeu().getEnvi_robot().getEnvironnement()),jeu.getRobot_jeu().getX_robot(),jeu.getRobot_jeu().getY_robot(),jeu.getRobot_jeu().getMesures_robot().historique_deplacement);
					return map;
				}

	

}
