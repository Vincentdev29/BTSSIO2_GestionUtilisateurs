package gestionUtilisateurs.models.dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

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
		ConnectDAO.generateJDBCUrl();
		ConnectDAO.setCredentials(userName, userPassword);
		connect = ConnectDAO.getInstance();
	}
	
	public boolean isURLConfEmpty() {
		return ConnectDAO.isURLEmpty();
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
	
	/**
	 * Métode de modification de l'utilisateur dans la base de données
	 * 
	 * @param utilisateur
	 */
	public void modifierUtilisateur(Utilisateur utilisateur) {
		try {
			String query = "update visiteur "
					+ "set nom = ?, prenom = ?, adresse = ?, cp = ?, ville = ?, statut = ?"
					+ "where id = ?";
		
			PreparedStatement statement = connect.prepareStatement(query);
			
			statement.setString(1, utilisateur.getNom());
			statement.setString(2, utilisateur.getPrenom());
			statement.setString(3, utilisateur.getAdresse());
			statement.setString(4, utilisateur.getCp());
			statement.setString(5, utilisateur.getVille());
			statement.setString(6, utilisateur.getStatut());
			statement.setString(7, utilisateur.getId());
			
			statement.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @return liste de tous les utilisateurs
	 */
	public ArrayList<Utilisateur> getListeUtilisateurs(){
		ArrayList<Utilisateur> lesUtilisateurs = new ArrayList<Utilisateur>();
		
		try {
			String query = "select id, nom, prenom, adresse, cp, ville, dateEmbauche, statut from visiteur";
			PreparedStatement statement = connect.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Utilisateur utilisateur = new Utilisateur(
						result.getString("id"),
						result.getString("nom"),
						result.getString("prenom"),
						result.getString("adresse"),
						result.getString("cp"),
						result.getString("ville"),
						result.getString("dateEmbauche"),
						result.getString("statut")
						);
				lesUtilisateurs.add(utilisateur);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lesUtilisateurs;
	}
	
	/**
	 * Retourne un utilisateur contenant toutes ces infos non liée à sa connexion
	 * 
	 * @param id identifiant de l'utilisateur à rechercher dans la BDD
	 * @return
	 */
	public Utilisateur findByIdInfoUtilisateur(String id){
		Utilisateur unUtilisateur = null;
		try{
			String query = "select id, nom, prenom, adresse, cp, ville, dateEmbauche, statut "
					+ "from visiteur "
					+ "where id = ?";
			PreparedStatement statement = connect.prepareStatement(query);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			if (result.first()){
					unUtilisateur = new Utilisateur(id, result.getString("nom"), result.getString("prenom"), result.getString("adresse"), result.getString("cp"), result.getString("ville"), result.getString("dateEmbauche"), result.getString("statut"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return unUtilisateur;
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
	
	/**
	 * Métode de modification de l'utilisateur dans la base de données
	 * 
	 * @param utilisateur
	 */
	public void modifierUtilisateur(Utilisateur utilisateur) {
		try {
			String query = "update visiteur "
					+ "set nom = ?, prenom = ?, adresse = ?, cp = ?, ville = ?, statut = ?"
					+ "where id = ?";
		
			PreparedStatement statement = connect.prepareStatement(query);
			
			statement.setString(1, utilisateur.getNom());
			statement.setString(2, utilisateur.getPrenom());
			statement.setString(3, utilisateur.getAdresse());
			statement.setString(4, utilisateur.getCp());
			statement.setString(5, utilisateur.getVille());
			statement.setString(6, utilisateur.getStatut());
			statement.setString(7, utilisateur.getId());
			
			statement.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Retourne un utilisateur contenant toutes ces infos non liée à sa connexion
	 * 
	 * @param id identifiant de l'utilisateur à rechercher dans la BDD
	 * @return
	 */
	public Utilisateur findByIdInfoUtilisateur(String id){
		Utilisateur unUtilisateur = null;
		try{
			String query = "select id, nom, prenom, adresse, cp, ville, dateEmbauche, statut "
					+ "from visiteur "
					+ "where id = ?";
			PreparedStatement statement = connect.prepareStatement(query);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			if (result.first()){
					unUtilisateur = new Utilisateur(id, result.getString("nom"), result.getString("prenom"), result.getString("adresse"), result.getString("cp"), result.getString("ville"), result.getString("dateEmbauche"), result.getString("statut"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return unUtilisateur;
	}
	
	/**
	 * @param id identifant de l'utilsateur à rechercher dans la BdD
	 * @return un objet Utilisateur ou null
	 */
	public Utilisateur findById(String id) {
		Utilisateur unUtilisateur = null;
		try {
			PreparedStatement statement = connect.prepareStatement("select * from visiteur where id =  ?");
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			if (result.first())
				unUtilisateur = new Utilisateur(id, result.getString("nom"), result.getString("prenom"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return unUtilisateur;
	}
		
	/**
	 * @param filtreNom nom de l'utilisateur à rechercher dans la BdD
	 * @return une liste d'objets Utilisateur 
	 */
	public List<Utilisateur> findByNom(String filtreNom) {
		
		Utilisateur unUtilisateur = null;
		List<Utilisateur> lesUtilisateurs = new ArrayList<Utilisateur>();
		try {
			PreparedStatement statement = connect.prepareStatement("select * from visiteur where nom like  ?");
			statement.setString(1, filtreNom);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				System.out.println(result.getString("id"));
				unUtilisateur = new Utilisateur(result.getString("id"), result.getString("nom"),
				result.getString("prenom"));
				lesUtilisateurs.add(unUtilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesUtilisateurs;
	}
}
