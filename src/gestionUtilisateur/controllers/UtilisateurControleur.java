package gestionUtilisateur.controllers;

import gestionUtilisateurs.models.dataAccess.UtilisateurDAO;

/**
 * Controleur des fonctionnalités liées aux utilisateurs
 * Opère le lien entre l'interface graphique et les modèles
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
