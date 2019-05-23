package gestionUtilisateur.views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import gestionUtilisateur.controllers.UtilisateurControleur;
import gestionUtilisateurs.models.dataAccess.ConnectDAO;

public class ConnectionForm extends JFrame implements ActionListener
{
	private UtilisateurControleur utilisateurControleur;
	JPanel fenetre = new JPanel(new GridBagLayout());
	private JLabel labLogin = new JLabel("Identifiant: ");
	private JLabel labMDP = new JLabel("Mot de passe: ");
	private JTextField txtLogin = new JTextField(20);
	private JPasswordField txtMDP = new JPasswordField(20);
	private JButton btnValider = new JButton("Valider");
	
	public ConnectionForm(UtilisateurControleur u) 
	{
		this.utilisateurControleur = u;
		
		// create a new panel with GridBagLayout manager
		
		fenetre.setBackground(Color.cyan);
		
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);

		// add components to the panel
		constraints.gridx = 0;
		constraints.gridy = 0;
		fenetre.add(labLogin, constraints);
	
		constraints.gridx = 1;
		fenetre.add(txtLogin, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		fenetre.add(labMDP, constraints);
	
		constraints.gridx = 1;
		fenetre.add(txtMDP, constraints);
	
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		fenetre.add(btnValider, constraints);
		btnValider.addActionListener(this);
	
		// set border for the panel
		fenetre.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Connection"));
	
		// add the panel to this frame
		this.add(fenetre);
	
		pack();
		setLocationRelativeTo(null);
	}

	
	public void actionPerformed(ActionEvent e) 
	{	 
		Object source = e.getSource();
		if(source == btnValider)
		{
			try
			{
				utilisateurControleur.connectDatabase(txtLogin.getText(), txtMDP.getText());
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			if(ConnectDAO.getInstance() != null)
			{
				this.dispose();
				Accueil frame = new Accueil(utilisateurControleur);
				frame.setVisible(true);
			}
			else
			{
				System.out.println("la connection n'a pas marché !");
				JOptionPane msgErreur = new JOptionPane();
				msgErreur.showMessageDialog(null, "Message d'erreur", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
		else
		{
			System.out.println("la connection n'a pas marché !");
			JOptionPane msgErreur = new JOptionPane();
			msgErreur.showMessageDialog(null, "Message d'erreur", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}
