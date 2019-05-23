package gestionUtilisateur.metier;

public class Utilisateur 
{	
	private String id;
	private String nom;
	private String prenom;
	private String adresse;
	private String cp;
	private String ville;
	private String dateEmbauche;
	private String statut;

	
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 */
	public Utilisateur(String id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	/**
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param cp
	 * @param ville
	 * @param dateEmbauche
	 * @param statut
	 */
	public Utilisateur(String id, String nom, String prenom, String adresse, String cp, String ville, String dateEmbauche, String statut){
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cp  = cp;
		this.ville = ville;
		this.dateEmbauche = dateEmbauche;
		this.statut = statut;
	}
	
	/**
	 * 
	 */
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}
	
	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	/**
	 * 
	 * @return statut
	 */
	public String getStatut() {
		return statut;
	}
	
	/**
	 * @param statut
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	/**
	 * 
	 * @return dateEmbauche
	 */
	public String getDateEmbauche() {
		return dateEmbauche;
	}
	
	/**
	 * 
	 * @param dateEmbauche
	 */
	public void setDateEmbauche(String dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	/**
	 * @see java.lang.Object#toString()
	 * Retourne une chaine affichant l'id, le nom et le prenom de l'utilisateur.
	 */
	@Override
	public String toString() {
		return "Utilisateur : " + id + ", " + nom + ", " + prenom ;
	}
}
