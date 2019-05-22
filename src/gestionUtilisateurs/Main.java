package gestionUtilisateurs;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;

import gestionUtilisateur.controllers.UtilisateurControleur;
import gestionUtilisateur.views.Accueil;
import gestionUtilisateur.views.ConnectionForm;

public class Main 
{
	public static void main(String[] args) throws Exception
	{
		UtilisateurControleur utilisateurControleur = new UtilisateurControleur();

		//UIManager.setLookAndFeel( new NimbusLookAndFeel() );

		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ConnectionForm frame = new ConnectionForm(utilisateurControleur);
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});

	}
}
