package gestionUtilisateur.controllers;

import gestionUtilisateurs.models.dataAccess.UtilisateurDAO;

import gestionUtilisateur.metier.Utilisateur;

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
	// Comment� le temps de d�termin� son utilit� et son niveau de s�curit�
	/*
	public UtilisateurDAO getDAO(){
		return userDAO;
	}
	*/
	
	/**
	 * Envoie au mod�le les informations de connection
	 * 
	 * @param userName pseudo de l'utilisateur
	 * @param password mot de passe utilisateur
	 */
	public void connectDatabase(String userName, String password){
		this.userDAO.connectDatabase(userName, password);
	}
	
	/**
	 * Envoie au mod�le pour insertion de nouvel utilisateur dans la base de donn�es
	 * 
	 * @param utilisateur
	 * @param login
	 * @param mdp
	 * @param dateEmbauche
	 */
	public void creerNouvelUtilisateur(Utilisateur utilisateur, String login, String mdp, String dateEmbauche){
		this.userDAO.creerNouvelleUtilisateur(utilisateur, login, mdp, dateEmbauche);
	}
}
