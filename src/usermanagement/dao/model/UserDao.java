package usermanagement.dao.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import usermanagement.model.UserModelBean;

public class UserDao {
	
	private Connection connection;
	private String dB_HOST;
	private String dB_PORT;
	private String dB_NAME;
	private String dB_USER;
	private String dB_PWD;
	
	public UserDao(String DB_HOST,String DB_PORT, String DB_NAME,String DB_USER,String DB_PWD) {
		dB_HOST = DB_HOST;
		dB_PORT = DB_PORT;
		dB_NAME = DB_NAME;
		dB_USER = DB_USER;
		dB_PWD = DB_PWD;
	}
	
	public void addUser(UserModelBean user) {
		try {
			System.out.println("Je passe la fin de add user");
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);
			PreparedStatement querySt= connection.prepareStatement("INSERT INTO binome01.UsersRobot (surname, lastname, login, pwd,admin) "
			+ "VALUES (?,?,?,?,false)");
			querySt.setString(1,user.getSurname());
			querySt.setString(2,user.getLastname());
			querySt.setString(3,user.getLogin());
			querySt.setString(4,user.getPwd());
			
			System.out.println("REQUEST:"+querySt.toString());
			querySt.executeUpdate();
			
			querySt.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Je passe l'erreur de add user");
		}

	}

	public ArrayList<UserModelBean> getAllUser(){
		ArrayList<UserModelBean> userList=new ArrayList<UserModelBean>();
		
		try {
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			java.sql.Statement query = null;
			ResultSet rs = null;
			query=connection.createStatement();
			rs=query.executeQuery("SELECT * FROM binome01.UsersRobot");
			
			PreparedStatement st = connection.prepareStatement("SELECT * FROM binome01.UsersRobot");
			rs = st.executeQuery();
			
			while (rs.next()){
				UserModelBean userModel = new UserModelBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5));
				System.out.println(userModel.toString());
				userList.add(userModel);
			}
			
			
			rs.close();
			query.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	public UserModelBean checkUser(String login, String pwd) {
		UserModelBean userModel=null;
		try {
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			ResultSet rs = null;		
			PreparedStatement st = connection.prepareStatement("SELECT * FROM binome01.UsersRobot WHERE (login=?) AND (pwd=?) ");
			
			st.setString(1,login);
			st.setString(2,pwd);
			
			rs = st.executeQuery();
			
			while(rs.next()){
			userModel = new UserModelBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5));
			}
			
			rs.close();
			st.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userModel;
	}

	public boolean checkLogin(String login) {
		
		boolean valid=false;
		UserModelBean userModel=null;
		try {
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+ dB_HOST + ":" + dB_PORT + "/" + dB_NAME, dB_USER, dB_PWD);

			ResultSet rs = null;		
			PreparedStatement st = connection.prepareStatement("SELECT * FROM binome01.UsersRobot WHERE login = ?;");
			
			st.setString(1,login);
			
			rs = st.executeQuery();
			
			while(rs.next()){
			userModel = new UserModelBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5));
			System.out.println(userModel.toString());
			valid=true;
			}
			
			rs.close();
			st.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return valid;
	}
}
