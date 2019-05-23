package gestionUtilisateur.views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.sun.glass.events.MouseEvent;

import gestionUtilisateur.controllers.UtilisateurControleur;
import gestionUtilisateur.models.UtilisateurJTableModel;
import gestionUtilisateurs.models.dataAccess.ConnectDAO;

public class Accueil extends JFrame implements ActionListener, MouseListener
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
	
	private UtilisateurJTableModel utilisateurJTableModel = new UtilisateurJTableModel();
	private JTable tableau = new JTable(utilisateurJTableModel);
	private JScrollPane jscrollpane = new JScrollPane(tableau);
	
	
	public Accueil(UtilisateurControleur u)
	{
		this.utilisateurControleur = u;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		utilisateurJTableModel.loadData(u.getAllUtilisateurs());
		
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
		btnChercherNom.addActionListener(this);
		
		constraints.gridx = 3;
		fenetre.add(labId, constraints);
		
		constraints.gridx = 4;
		fenetre.add(txtId, constraints);
		
		constraints.gridx = 5;
		fenetre.add(btnChercherId, constraints);
		btnChercherId.addActionListener(this);
		
		constraints.gridx = 5;
		constraints.gridy = 1;
		fenetre.add(btnNouvelUtilisateur, constraints);
		btnNouvelUtilisateur.addActionListener(this);
		
		constraints.gridy = 2;
		fenetre.add(btnModifierUtilisateur, constraints);
		btnModifierUtilisateur.addActionListener(this);
		tableau.addMouseListener(this);
		
		constraints.gridx = 2;
		constraints.gridy = 1;
		fenetre.add(jscrollpane, constraints);
		
		
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
				utilisateurJTableModel.loadData(utilisateurControleur.findByNom(txtNom.getText()));
				txtNom.setText("");
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
				utilisateurJTableModel.loadDataa(utilisateurControleur.findById(txtId.getText()));
				txtId.setText("");
			}
			else
			{
				JOptionPane msgErreur = new JOptionPane();
				msgErreur.showMessageDialog(null, "Message d'erreur", "Aucun id demander", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (source == btnNouvelUtilisateur) 
		{
			if(ConnectDAO.getInstance() != null){
				this.dispose();
				NouvelUtilisateurForm frame = new NouvelUtilisateurForm(utilisateurControleur);
				frame.setVisible(true);
			}else{
				JOptionPane msgErreur = new JOptionPane();
				msgErreur.showMessageDialog(null, "Message d'erreur", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (source == btnModifierUtilisateur) 
		{
			if(ConnectDAO.getInstance() != null){
				int row = tableau.getSelectedRow();
				String id = tableau.getValueAt(row, 0).toString();
				System.out.println(id);
				this.dispose();
				ModifierUtilisateurForm frame = new ModifierUtilisateurForm(utilisateurControleur, id);
				frame.setVisible(true);
			}else{
				JOptionPane msgErreur = new JOptionPane();
				msgErreur.showMessageDialog(null, "Message d'erreur", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
	}
	
	

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) 
	{
		Object source = e.getSource();
		if(e.getClickCount() == 1)
        {
			System.out.println("tableau cliquer");
			tableau = (JTable)e.getSource();	
        }
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent arg0) {
		// TODO Stub de la méthode généré automatiquement
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent arg0) {
		// TODO Stub de la méthode généré automatiquement
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent arg0) {
		// TODO Stub de la méthode généré automatiquement
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent arg0) {
		// TODO Stub de la méthode généré automatiquement
		
	}
	
	
}
