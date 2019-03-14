package gestionUtilisateurs.models.dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Représente une connection à la base de données
 * Classe basée sur le design pattern singleton
 * qui garantie l'utilisation d'une seule instance de l'objet.
 * 
 * Tous les constituants de cette classe sont statiques
 * 
 * @author Zanati
 *
 */
public class ConnectDAO {
	/**
	 * URL de connection
	 */
	private static String url = "jdbc:mysql://localhost/gsb-frais";
	
	/**
	 * Nom du user
	 */
	private static String user = "";
	
	/**
	 * Mot de passe du user
	 */
	private static String passwd = "";
	
	
	/**
	 * Objet de connection
	 */
	private static Connection connect = null;
	
	/**
	 * 
	 * Méthode de paramétrage des identifiants
	 * et mot de passe pour s'identifier à la base de données
	 * 
	 * @param userName pseudo de l'utilisateur
	 * @param userPassword mot de passe de l'utilisateur
	 */
	public static void setCredentials(String userName, String userPassword)
	{
		user = userName;
		passwd = userPassword;
	}
	
	/**
	 * Méthode qui va nous retourner notre instance
	 * et la créer si elle n'existe pas...
	 * @return un objet de connection
	 */
	public static Connection getInstance(){
		if (connect == null){
			try{
				connect = DriverManager.getConnection(url, user, passwd);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return connect;
	}
	
	/**
	 * Méthode qui met fin à la connection
	 */
	public static void close(){
		if(connect != null){
			try{
				connect.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
}
