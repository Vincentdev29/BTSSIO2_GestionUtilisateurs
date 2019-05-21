package gestionUtilisateurs;

import javax.swing.UIManager;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;

import gestionUtilisateur.controllers.UtilisateurControleur;
import gestionUtilisateur.views.NouvelUtilisateurForm;

public class Main {
	public static void main(String[] args) throws Exception {
		UtilisateurControleur controleur = new UtilisateurControleur();
		controleur.connectDatabase("ts1", "ts1");
		// thème
		UIManager.setLookAndFeel( new NimbusLookAndFeel() );
		
		NouvelUtilisateurForm appli = new NouvelUtilisateurForm(controleur);
		appli.setVisible(true);
	}
}
