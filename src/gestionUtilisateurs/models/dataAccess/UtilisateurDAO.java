package gestionUtilisateurs.models.dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gestionUtilisateur.metier.Utilisateur;

public class UtilisateurDAO {
	
	public Connection connect;
	
	public UtilisateurDAO(){
		super();
	}
	
	public void connectDatabase(String userName, String userPassword){
		ConnectDAO.setCredentials(userName, userPassword);
		connect = ConnectDAO.getInstance();
	}
	
	/**
	 * @param id identifant de l'utilsateur à rechercher dans la BdD
	 * @return un objet Utilisateur ou null
	 */
		public Utilisateur findById(String id) {

			Utilisateur unUtilisateur = null;
			try {
				PreparedStatement statement = connect.prepareStatement("select * from utilisateur where id =  ?");
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
