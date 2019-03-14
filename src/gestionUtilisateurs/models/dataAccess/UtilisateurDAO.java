package gestionUtilisateurs.models.dataAccess;

import java.sql.Connection;

/**
 * Classe technique permettant le mapping entre les instances d'Utilisateur
 * et la table utilisateur dans BDD
 * D�finit les op�rations autoris�es : Create, Read, et Update (CRU)
 * Elle mod�lise un objet d'acc�s aux donn�es (Data Access Object)
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
	 * M�thode d'initialisation de la connection � la base de donn�es
	 * 
	 * @param userName pseudo de l'utilisateur
	 * @param userPassword mot de passe de l'utilisateur
	 */
	public void connectDatabase(String userName, String userPassword){
		ConnectDAO.setCredentials(userName, userPassword);
		connect = ConnectDAO.getInstance();
	}
}
