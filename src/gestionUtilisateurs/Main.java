package gestionUtilisateurs;

import java.awt.EventQueue;

import gestionUtilisateur.controllers.UtilisateurControleur;
import gestionUtilisateur.views.ConnectionForm;

public class Main 
{
	public static void main(String[] args) 
	{
		UtilisateurControleur utilisateurControleur = new UtilisateurControleur();

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
