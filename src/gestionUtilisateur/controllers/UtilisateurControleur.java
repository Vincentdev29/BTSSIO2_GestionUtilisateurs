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
	
	public UtilisateurDAO getDAO(){
		return userDAO;
	}
	
	public void connectDatabase(String userName, String password){
		userDAO.connectDatabase(userName, password);
	}
}
