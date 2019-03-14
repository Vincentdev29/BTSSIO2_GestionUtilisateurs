package gestionUtilisateur.controllers;

import gestionUtilisateurs.models.dataAccess.UtilisateurDAO;

/**
 * Controleur des fonctionnalit�s li�es aux utilisateurs
 * Op�re le lien entre l'interface graphique et les mod�les
 *
 */
public class UtilisateurControleur {
	private UtilisateurDAO userDAO;
	
	public UtilisateurControleur(){
		userDAO = new UtilisateurDAO();
	}
	
	/**
	 * Retour de l'objet UtilisateurDAO
	 *  
	 * @return l'objet dao
	 */
	public UtilisateurDAO getDAO(){
		return userDAO;
	}
	
	/**
	 * Envoie au mod�le les informations de connection
	 * 
	 * @param userName pseudo de l'utilisateur
	 * @param password mot de passe utilisateur
	 */
	public void connectDatabase(String userName, String password){
		userDAO.connectDatabase(userName, password);
	}
}
