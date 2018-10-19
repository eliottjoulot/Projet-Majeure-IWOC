package usermanagement.model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@SuppressWarnings("serial")
@ManagedBean
@RequestScoped
public class LoginBean implements Serializable{
	
	// Propiétés :
	private	String	login;
	private	String	pwd;
	private boolean admin;
	
	// Constructeur :
	public	LoginBean() { }
	
	// Accesseurs noramlisés :
	public	String getLogin() 			{ return login; }
	public void setLogin(String login) 	{ this.login = login; }
	public String getPwd() 				{ return pwd; }
	public void setPwd(String pwd) 		{ this.pwd = pwd; }
	public boolean getAdmin() 				{ return admin; }
	public void setAdmin(boolean admin) 		{ this.admin = admin; }
	
}