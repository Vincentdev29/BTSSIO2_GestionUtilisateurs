package gestionUtilisateur.controllers;

import gestionUtilisateurs.models.dataAccess.UtilisateurDAO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import gestionUtilisateur.metier.Utilisateur;

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
	
	/**
	 * Retour de l'objet UtilisateurDAO
	 *  
	 * @return l'objet dao
	 */
	// Commenté le temps de déterminé son utilité et son niveau de sécurité
	/*
	public UtilisateurDAO getDAO(){
		return userDAO;
	}
	*/
	
	/**
	 * Envoie au modèle les informations de connection
	 * 
	 * @param userName pseudo de l'utilisateur
	 * @param password mot de passe utilisateur
	 */
	public void connectDatabase(String userName, String password){
		this.userDAO.connectDatabase(userName, password);
	}
	
	public boolean isURLConfEmpty() {
		return userDAO.isURLConfEmpty();
	}
	
	/**
	 * Envoie au modèle pour insertion de nouvel utilisateur dans la base de données
	 * 
	 * @param utilisateur
	 * @param login
	 * @param mdp
	 * @param dateEmbauche
	 */
	public void creerNouvelUtilisateur(Utilisateur utilisateur, String login, String mdp, String dateEmbauche){
		this.userDAO.creerNouvelleUtilisateur(utilisateur, login, mdp, dateEmbauche);
	}
	
	/**
	 * Envoie au modèle pour modification d'utilisateur dans la base de données
	 * 
	 * @param utilisateur
	 */
	public void modifierUtilisateur(Utilisateur utilisateur) {
		this.userDAO.modifierUtilisateur(utilisateur);
	}
	
	/**
	 * Retourne une liste de tous les utilisateurs.
	 */
	public ArrayList<Utilisateur> getListeUtilisateurs(){
		return userDAO.getListeUtilisateurs();
	}
	
	/**
	 * Envoie au modèle pour récupére les informations d'un utilisateur
	 * 
	 * @param id identifiant de l'utilisateur
	 * @return utilisateur 
	 */
	public Utilisateur findByIdInfoUtilisateur(String id){
		return this.userDAO.findByIdInfoUtilisateur(id);
	}
	
	/**
	 * Retire l'utilisateur grâce à son id
	 * 
	 * @param id
	 * @return utilisateur
	 */
	public Utilisateur findById(String idUtilisateur) {
		return this.userDAO.findById(idUtilisateur);
	}
	
	/**
	 * Retire une liste d'utilisateur grâce à leur nom
	 * 
	 * Le signe '%' est ajouté pour la requête SQL 
	 * qui permettra la recherche de toutes les chaines qui
	 * contienne le nom ou la chaine envoyer.
	 * 
	 * @param filtreNom
	 * @return liste d'utilisateur
	 */
	public List<Utilisateur> findByNom(String filtreNom) {
		return this.userDAO.findByNom("%" + filtreNom + "%");
	}
<<<<<<< HEAD

=======
	
	/**
	 *  Retourne une liste de tous les utilisateurs contenant les informations : id, nom et  prenom
	 *  
	 * @return liste d'utilisateurs
	 */
	public List<Utilisateur> getAllUtilisateurs(){
		return this.userDAO.getAllUtilisateurs();
	}
>>>>>>> ModeleDataAccess
}
