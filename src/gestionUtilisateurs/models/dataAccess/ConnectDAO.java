package gestionUtilisateurs.models.dataAccess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
	
	public static void generateJDBCUrl() {
		String urlGeneree = "";
		String conf_base = "./gestion_utilisateur.conf";
		HashMap<String, String> mapConfiguration = new HashMap<String, String>();
		BufferedReader reader;
		
		try {
			// Instanciation du lecteur de fichier
			// Ouverture du fichier de configuration en lecture
			reader = new BufferedReader(new FileReader(conf_base));
			String line = reader.readLine();
			
			while (line != null) {
				String str;
				// Elimination des commentaires
				if (!line.contains("#") && !line.contentEquals("")) {
					// Separation variable/valeur
					String variableValueArray[];
					variableValueArray = line.split("=");
					if (variableValueArray.length > 1) {
						mapConfiguration.put(variableValueArray[0], variableValueArray[1]);
					}else {
						System.err.println("Valeur vide, champ : " + variableValueArray[0]);
					}
				}
								
				// Lit la prochaine ligne
				line = reader.readLine();
			}
			reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		urlGeneree = "jdbc:" + mapConfiguration.get("type_bdd") + "://" + mapConfiguration.get("adresse_bdd") + "/" + mapConfiguration.get("nom_bdd");
		url = urlGeneree;
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
				System.out.println("Connection effectuée");
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
		System.out.println("Connection fermée");
	}
}
