package gestionUtilisateurs;

import java.awt.EventQueue;

import gestionUtilisateur.controllers.UtilisateurControleur;
import gestionUtilisateur.views.ModifierUtilisateurForm;
import gestionUtilisateur.views.NouvelUtilisateurForm;

public class Main {
	public static void main(String[] args) throws Exception {
		UtilisateurControleur controleur = new UtilisateurControleur();
		controleur.connectDatabase("ts1", "ts1");
		
        EventQueue.invokeLater(new Runnable() 
        {
                public void run() 
                {
                        try 
                        {
                        	ModifierUtilisateurForm modif = new ModifierUtilisateurForm(controleur, "45");   
                        	//NouvelUtilisateurForm nouvel = new NouvelUtilisateurForm(controleur);
                        } 
                        catch (Exception e) 
                        {
                                e.printStackTrace();
                        }
                }
        });
		
		
	}
}
