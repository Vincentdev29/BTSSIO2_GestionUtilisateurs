package gestionUtilisateur.controllers;

import gestionUtilisateurs.models.dataAccess.UtilisateurDAO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import gestionUtilisateur.metier.Utilisateur;

/**
 * Controleur des fonctionnalites liees aux utilisateurs
 * Opere le lien entre l'interface graphique et les modeles
 *
 */
public class UtilisateurControleur {
	private UtilisateurDAO userDAO;

	public UtilisateurControleur(){
		userDAO = new UtilisateurDAO();
	}

	/**
	 * Envoie au modele les informations de connection
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
	 * Envoie au modele pour insertion de nouvel utilisateur dans la base de donnees
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
	 * Envoie au modele pour modification d'utilisateur dans la base de donnees
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
	 * Envoie au modele pour recuperer les informations d'un utilisateur
	 *
	 * @param id identifiant de l'utilisateur
	 * @return utilisateur
	 */
	public Utilisateur findByIdInfoUtilisateur(String id){
		return this.userDAO.findByIdInfoUtilisateur(id);
	}

	/**
	 * Retire l'utilisateur grace a son id
	 *
	 * @param id
	 * @return utilisateur
	 */
	public Utilisateur findById(String idUtilisateur) {
		return this.userDAO.findById(idUtilisateur);
	}

	/**
	 * Retire une liste d'utilisateur grace a leur nom
	 *
	 * Le signe '%' est ajouter pour la requete SQL
	 * qui permettra la recherche de toutes les chaines qui
	 * contienne le nom ou la chaine envoyer.
	 *
	 * @param filtreNom
	 * @return liste d'utilisateur
	 */
	public List<Utilisateur> findByNom(String filtreNom) {
		return this.userDAO.findByNom("%" + filtreNom + "%");
	}

	/**
	 *  Retourne une liste de tous les utilisateurs contenant les informations : id, nom et  prenom
	 *
	 * @return liste d'utilisateurs
	 */
	public List<Utilisateur> getAllUtilisateurs(){
		return this.userDAO.getAllUtilisateurs();
	}
}
