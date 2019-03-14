package gestionUtilisateurs.models.dataAccess;

import java.sql.Connection;

/**
 * Classe technique permettant le mapping entre les instances d'Utilisateur
 * et la table utilisateur dans BDD
 * Définit les opérations autorisées : Create, Read, et Update (CRU)
 * Elle modélise un objet d'accès aux données (Data Access Object)
 * 
 * @author Zanati
 *
 */
public class UtilisateurDAO {
	
	public Connection connect;
	
	public UtilisateurDAO(){
		super();
	}
	
	/**
	 * Méthode d'initialisation de la connection à la base de données
	 * 
	 * @param userName pseudo de l'utilisateur
	 * @param userPassword mot de passe de l'utilisateur
	 */
	public void connectDatabase(String userName, String userPassword){
		ConnectDAO.setCredentials(userName, userPassword);
		connect = ConnectDAO.getInstance();
	}
}
