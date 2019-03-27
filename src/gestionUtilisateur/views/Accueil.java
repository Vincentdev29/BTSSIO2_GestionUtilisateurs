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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import gestionUtilisateur.controllers.UtilisateurControleur;

public class Accueil extends JFrame
{
	private UtilisateurControleur utilisateurControleur;
	

	private JLabel labNom = new JLabel("Nom: ");
	private JLabel labId = new JLabel("Id: ");
	
	private JTextField txtNom = new JTextField(20);
	private JTextField txtId = new JTextField(20);
	
	private JButton btnChercherNom = new JButton("Chercher");
	private JButton btnChercherId = new JButton("Chercher");
	private JButton btnNouvelUtilisateur = new JButton("Nouvel utilisateur");
	private JButton btnModifierUtilisateur = new JButton("Modifier utilisateur");
	
	public Accueil(UtilisateurControleur u)
	{
		this.utilisateurControleur = u;
		
		JPanel fenetre = new JPanel(new GridBagLayout());
		fenetre.setBackground(Color.cyan);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		
		fenetre.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Accueil"));
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		fenetre.add(labNom, txtNom);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		fenetre.add(labId, txtId);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		fenetre.add(btnNouvelUtilisateur);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		fenetre.add(btnModifierUtilisateur);
		
		
		add(fenetre);
		pack();
		setLocationRelativeTo(null);
	}
}
