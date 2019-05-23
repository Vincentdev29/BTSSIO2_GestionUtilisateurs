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

public class ModifierUtilisateurForm extends JFrame implements ActionListener{
	
	JPanel fenetre = new JPanel(new GridBagLayout());
	
	private UtilisateurControleur controleur;
	private JLabel labId = new JLabel("Id : ");
	private JLabel labPrenom = new JLabel("Prenom : ");
	private JLabel labNom = new JLabel("Nom : ");
	private JLabel labStatut = new JLabel("Statut : ");
	private JLabel labAdr = new JLabel("Adresse : ");
	private JLabel labCodePo = new JLabel("Code Postal : ");
	private JLabel labVille = new JLabel("Ville : ");
	private JLabel labDate = new JLabel("Date embauche : (JJ-MM-AAAA)");
	private JTextField txtId = new JTextField(10);
	private JTextField txtPrenom = new JTextField(10);
	private JTextField txtNom = new JTextField(10);
	private JTextField txtStatut = new JTextField(10);
	private JTextField txtAdr = new JTextField(10);
	private JTextField txtCodePo = new JTextField(10);
	private JTextField txtVille = new JTextField(10);
	private JTextField txtDate = new JTextField(10);
	private JButton btnValider = new JButton("Modifier un utilisateur");
	private JButton btnRetour = new JButton("Retour");
	
	public ModifierUtilisateurForm(UtilisateurControleur controleur, String id){
		this.controleur = controleur;
		Utilisateur unUtilisateur = this.controleur.findByIdInfoUtilisateur(id);
		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		fenetre.setBackground(Color.CYAN);
		fenetre.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Modifier un utilisateur"));
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		
		constraints.gridy = 0;
		
		constraints.gridx = 0;
		fenetre.add(labId, constraints);
		constraints.gridx = 1;
		fenetre.add(txtId, constraints);
		this.txtId.setText(unUtilisateur.getId());

		constraints.gridx = 2;
		fenetre.add(labAdr, constraints);
		constraints.gridx = 3;
		fenetre.add(txtAdr, constraints);
		this.txtAdr.setText(unUtilisateur.getAdresse());
		
		constraints.gridy = 1;
		
		constraints.gridx = 0;
		fenetre.add(labPrenom, constraints);
		constraints.gridx = 1;
		fenetre.add(txtPrenom, constraints);
		this.txtPrenom.setText(unUtilisateur.getPrenom());
		
		constraints.gridx = 2;
		fenetre.add(labCodePo, constraints);
		constraints.gridx = 3;
		fenetre.add(txtCodePo, constraints);
		this.txtCodePo.setText(unUtilisateur.getCp());
		
		constraints.gridy = 2;
		
		constraints.gridx = 0;
		fenetre.add(labNom, constraints);
		constraints.gridx = 1;
		fenetre.add(txtNom, constraints);
		this.txtNom.setText(unUtilisateur.getNom());
		
		constraints.gridx = 2;
		fenetre.add(labVille, constraints);
		constraints.gridx = 3;
		fenetre.add(txtVille, constraints);
		this.txtVille.setText(unUtilisateur.getVille());
		
		constraints.gridy = 3;
		
		constraints.gridx = 0;
		fenetre.add(labStatut, constraints);
		constraints.gridx = 1;
		fenetre.add(txtStatut, constraints);
		this.txtStatut.setText(unUtilisateur.getStatut());
		
		constraints.gridx = 2;
		fenetre.add(labDate, constraints);
		constraints.gridx = 3;
		fenetre.add(txtDate, constraints);
		this.txtDate.setText(unUtilisateur.getDateEmbauche());
		
		constraints.gridy = 4;
		
		constraints.gridx = 2;
		fenetre.add(btnValider, constraints);
		btnValider.addActionListener(this);
		
		constraints.gridx = 2;
		constraints.gridy = 6;
		fenetre.add(btnRetour, constraints);
		btnRetour.addActionListener(this);
		
		this.add(fenetre);
		pack();
		this.setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == btnValider){
			Utilisateur utilisateur = new Utilisateur(txtId.getText(), txtPrenom.getText(), txtNom.getText(), txtAdr.getText(), txtCodePo.getText(), txtVille.getText(), txtDate.getText(), txtStatut.getText());
			this.controleur.modifierUtilisateur(utilisateur);
			this.dispose();
			Accueil frame = new Accueil(controleur);
			frame.setVisible(true);
		}
		
		if (source == btnRetour)
		{
			this.dispose();
			Accueil frame = new Accueil(controleur);
			frame.setVisible(true);
		}
		
	}
}
