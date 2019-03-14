package gestionUtilisateurs.models.dataAccess;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gestionUtilisateur.metier.Utilisateur;

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
	
	/**
	 * Métode d'insertion de nouvel utilisateur dans la base de données
	 * 
	 * @param utilisateur
	 * @param login
	 * @param mdp
	 * @param dateEmbauche
	 */
	public void creerNouvelleUtilisateur(Utilisateur utilisateur, String login, String mdp, String dateEmbauche){
		try{
			String query = "insert into visiteur(id, nom, prenom, login, mdp, adresse, cp, ville, dateEmbauche, statut)"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connect.prepareStatement(query);
			
			statement.setString(1, utilisateur.getId());
			statement.setString(2, utilisateur.getNom());
			statement.setString(3, utilisateur.getPrenom());
			statement.setString(4, login);
			statement.setString(5, mdp);
			statement.setString(6, utilisateur.getAdresse());
			statement.setString(7, utilisateur.getCp());
			statement.setString(8, utilisateur.getVille());
			statement.setString(9, dateEmbauche);
			statement.setString(10, utilisateur.getStatut());
			
			statement.execute();
			
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
}
