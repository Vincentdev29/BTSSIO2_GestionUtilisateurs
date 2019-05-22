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
import javax.swing.JTextField;

import gestionUtilisateur.controllers.UtilisateurControleur;
import gestionUtilisateur.metier.Utilisateur;

public class NouvelUtilisateurForm extends JFrame implements ActionListener{
	
	private UtilisateurControleur controleur;
	private JLabel labId = new JLabel("Id : ");
	private JLabel labPrenom = new JLabel("Prenom : ");
	private JLabel labNom = new JLabel("Nom : ");
	private JLabel labStatut = new JLabel("Statut : ");
	private JLabel labAdr = new JLabel("Adresse : ");
	private JLabel labCodePo = new JLabel("Code Postal : ");
	private JLabel labVille = new JLabel("Ville : ");
	private JLabel labDate = new JLabel("Date embauche : (JJ-MM-AAAA)");
	private JLabel labIdentifiant = new JLabel("Identifiant : ");
	private JLabel labMdp = new JLabel("Mot de passe : ");
	private JTextField txtId = new JTextField(10);
	private JTextField txtPrenom = new JTextField(10);
	private JTextField txtNom = new JTextField(10);
	private JTextField txtStatut = new JTextField(10);
	private JTextField txtAdr = new JTextField(10);
	private JTextField txtCodePo = new JTextField(10);
	private JTextField txtVille = new JTextField(10);
	private JTextField txtDate = new JTextField(10);
	private JTextField txtIdentifiant = new JTextField(10);
	private JTextField txtMdp = new JTextField(10);
	private JButton btnValider = new JButton("Créer un utilisateur");
	
	public NouvelUtilisateurForm(UtilisateurControleur controleur){
		this.controleur = controleur;
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(700, 500);
		this.setVisible(true);
		
		
		JPanel fenetre = new JPanel(new GridBagLayout());
		fenetre.setBackground(Color.CYAN);
		fenetre.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Un Nouvel Utilisateur"));
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		
		constraints.gridy = 0;
		
		constraints.gridx = 0;
		fenetre.add(labId, constraints);
		constraints.gridx = 1;
		fenetre.add(txtId, constraints);

		constraints.gridx = 2;
		fenetre.add(labAdr, constraints);
		constraints.gridx = 3;
		fenetre.add(txtAdr, constraints);
		
		constraints.gridy = 1;
		
		constraints.gridx = 0;
		fenetre.add(labPrenom, constraints);
		constraints.gridx = 1;
		fenetre.add(txtPrenom, constraints);
		
		constraints.gridx = 2;
		fenetre.add(labCodePo, constraints);
		constraints.gridx = 3;
		fenetre.add(txtCodePo, constraints);
		
		constraints.gridy = 2;
		
		constraints.gridx = 0;
		fenetre.add(labNom, constraints);
		constraints.gridx = 1;
		fenetre.add(txtNom, constraints);
		
		constraints.gridx = 2;
		fenetre.add(labVille, constraints);
		constraints.gridx = 3;
		fenetre.add(txtVille, constraints);
		
		constraints.gridy = 3;
		
		constraints.gridx = 0;
		fenetre.add(labStatut, constraints);
		constraints.gridx = 1;
		fenetre.add(txtStatut, constraints);
		
		constraints.gridx = 2;
		fenetre.add(labDate, constraints);
		constraints.gridx = 3;
		fenetre.add(txtDate, constraints);
		
		constraints.gridy = 4;
		
		constraints.gridx = 0;
		fenetre.add(labIdentifiant, constraints);
		constraints.gridx = 1;
		fenetre.add(txtIdentifiant, constraints);
		
		constraints.gridy = 5;
		
		constraints.gridx = 0;
		fenetre.add(labMdp, constraints);
		constraints.gridx = 1;
		fenetre.add(txtMdp, constraints);
		
		constraints.gridx = 2;
		fenetre.add(btnValider, constraints);
		btnValider.addActionListener(this);
		
		this.add(fenetre);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == btnValider){
			Utilisateur utilisateur = new Utilisateur(txtId.getText(), txtPrenom.getText(), txtNom.getText(), txtAdr.getText(), txtCodePo.getText(), txtVille.getText(), txtDate.getText(), txtStatut.getText());
			this.controleur.creerNouvelUtilisateur(utilisateur, txtIdentifiant.getText(), txtMdp.getText(), txtDate.getText());
		}
		
	}
	
	
	
	
}
