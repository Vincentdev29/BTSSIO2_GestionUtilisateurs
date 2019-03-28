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
	
	JPanel fenetre = new JPanel(new GridBagLayout());

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
		
		
		fenetre.setBackground(Color.cyan);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		
		fenetre.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Accueil"));
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		fenetre.add(labNom, constraints);
		
		constraints.gridx = 1;
		fenetre.add(txtNom, constraints);
		
		constraints.gridx = 2;
		fenetre.add(btnChercherNom, constraints);
		
		constraints.gridx = 3;
		fenetre.add(labId, constraints);
		
		constraints.gridx = 4;
		fenetre.add(txtId, constraints);
		
		constraints.gridx = 5;
		fenetre.add(btnChercherId, constraints);
		
		constraints.gridx = 5;
		constraints.gridy = 1;
		fenetre.add(btnNouvelUtilisateur, constraints);
		
		constraints.gridy = 2;
		fenetre.add(btnModifierUtilisateur, constraints);
		
		
		add(fenetre);
		pack();
		setLocationRelativeTo(null);
	}
}
