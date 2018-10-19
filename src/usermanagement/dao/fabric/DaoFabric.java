package usermanagement.dao.fabric;

import usermanagement.dao.model.UserDao;

public class DaoFabric {

	private static volatile DaoFabric instance = null;
	private static final String DB_HOST="db-tp.cpe.fr";
	private static final String DB_PORT="3306";
	private static final String DB_NAME="binome01";
	private static final String DB_USER="binome01";
	private static final String DB_PWD="binome01";
	
	private DaoFabric() {
		super();
		try {
		// Chargement du Driver, puis établissement de la connexion
		Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public final static DaoFabric getInstance() {
		// Le "Double-Checked Singleton"/"Singleton doublement vérifié" permet
		// d'éviter un appel coûteux à synchronized,
		// une fois que l'instanciation est faite.
		if (DaoFabric.instance == null) {
			// Le mot-clé synchronized sur ce bloc empêche toute instanciation
			// multiple même par différents "threads".
			synchronized (DaoFabric.class) {
				if (DaoFabric.instance == null) {
					DaoFabric.instance = new DaoFabric();
				}
			}
		}
	return DaoFabric.instance;

	}
	
	public UserDao createUserDao() {
		@SuppressWarnings("static-access")
		UserDao userDao = new
		UserDao(this.DB_HOST,this.DB_PORT,this.DB_NAME,this.DB_USER,this.DB_PWD);
		return userDao;
	}
}