package gestionUtilisateur.models;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import gestionUtilisateur.controllers.UtilisateurControleur;
import gestionUtilisateur.metier.Utilisateur;

/**
 * Représente le modèle (=les données à présenter) utilisé par l'objet JTable
 * @author Zanati
 * @version février 2017
 *
 */
public class UtilisateurJTableModel extends AbstractTableModel {

	private UtilisateurControleur controleur = new UtilisateurControleur();
	private static final long serialVersionUID = 1L;
	private String[] nomColonnes;
	private Vector<String []> lignes;

	public UtilisateurJTableModel () {
		nomColonnes = new String[] {
				"Id",
				"Prenom",
				"Nom"
		};
		lignes = new Vector<String []>() ;
	}
	
	
	/**
	 * @ return nombre de colonnes dans l'objet JTable
	 */
	@Override
	public int getColumnCount() {
		
		return nomColonnes.length;
	}

	/**
	 * @ return nombre de lignes dans l'objet JTable
	 */
	@Override
	public int getRowCount() {
		
		return lignes.size();
	}

	/**
	 * @param rowIndex : n°ligne
	 * @param columnIndex : n°colonne
	 * @return la valeur qui se trouve au n°ligne et au n°colonne
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return lignes.get(rowIndex)[columnIndex];
	}
	
	/**
	 * @param column : numéro de la colonne dans l'objet JTable
	 * @return le nom de la colonne
	 */
	@Override
	public String getColumnName(int column) {
		
		return nomColonnes[column];
	}
	
	/**
	 * Modifie le contenu de la JTable
	 * @param lesUtilisateurs : Liste d'objets Utilisateur à afficher dans le JTable
	 * 
	 */
	public void loadData(List<Utilisateur> lesUtilisateurs) {
        lignes = new Vector<String[]>(); // vider le contenu
        for (Utilisateur unUtilisateur : lesUtilisateurs) {
                //Chaque ligne du JTable est un tableau de String
                lignes.add(new String[] { unUtilisateur.getId(), unUtilisateur.getPrenom(), unUtilisateur.getNom() });
        }
        fireTableChanged(null); // prévient que les données ont changé

	}
	
	public void loadDataa(Utilisateur unUtilisateur) {
        lignes = new Vector<String[]>(); // vider le contenu

        lignes.add(new String[] { unUtilisateur.getId(), unUtilisateur.getPrenom(), unUtilisateur.getNom()});

        fireTableChanged(null); // pr�vient que les donn�es ont chang�

}

}

