package gestionUtilisateurs.models.dataAccess;

import java.sql.Connection;

public class UtilisateurDAO {
	
	public Connection connect;
	
	public UtilisateurDAO(){
		super();
	}
	
	public void connectDatabase(String userName, String userPassword){
		ConnectDAO.setCredentials(userName, userPassword);
		connect = ConnectDAO.getInstance();
	}
}
