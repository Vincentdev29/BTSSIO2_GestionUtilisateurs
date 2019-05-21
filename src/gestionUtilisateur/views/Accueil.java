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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import gestionUtilisateur.controllers.UtilisateurControleur;
import gestionUtilisateurs.models.dataAccess.ConnectDAO;

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
	
	private String titre[] = {"id", "nom", "prenom"};
	private Object[][] donnees = {}; // A changer selon la fonction de Vincent
	private JTable tableau = new JTable(donnees, titre);
	
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
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		fenetre.add(tableau, constraints);
		
		add(fenetre);
		pack();
		setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent e) 
	{	 
		Object source = e.getSource();
		if(source == btnChercherNom)
		{
			if (txtNom != null) // A tester
			{
				utilisateurControleur.findByNom(txtNom.toString());
			}
			else
			{
				JOptionPane msgErreur = new JOptionPane();
				msgErreur.showMessageDialog(null, "Message d'erreur", "Aucun nom demander", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if(source == btnChercherId) // A tester
		{
			if (txtId != null)
			{
				utilisateurControleur.findById(txtId.toString());
			}
			else
			{
				JOptionPane msgErreur = new JOptionPane();
				msgErreur.showMessageDialog(null, "Message d'erreur", "Aucun id demander", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (source == btnNouvelUtilisateur) // En attente du merge avec QT
		{
			if(ConnectDAO.getInstance() != null){
				fenetre.setVisible(false);
				NouvelUtilisateurForm frame = new NouvelUtilisateurForm(utilisateurControleur);
				frame.setVisible(true);
			}else{
				System.out.println("la connection n'a pas marché !");
				JOptionPane msgErreur = new JOptionPane();
				msgErreur.showMessageDialog(null, "Message d'erreur", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (source == btnModifierUtilisateur) // En attente du merge avec QT
		{
			if(ConnectDAO.getInstance() != null){
				fenetre.setVisible(false);
				ModifierUtilisateurForm frame = new ModifierUtilisateurForm(utilisateurControleur);
				frame.setVisible(true);
			}else{
				System.out.println("la connection n'a pas marché !");
				JOptionPane msgErreur = new JOptionPane();
				msgErreur.showMessageDialog(null, "Message d'erreur", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
