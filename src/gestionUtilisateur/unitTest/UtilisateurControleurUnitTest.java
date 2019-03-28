package gestionUtilisateur.unitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gestionUtilisateur.controllers.UtilisateurControleur;

public class UtilisateurControleurUnitTest {
	protected UtilisateurControleur controleur;

	@Before
	public void setUp() throws Exception {
		controleur = new UtilisateurControleur();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInstanciationBDD() {
		String userName = "root";
		String password = "";
		try {
			controleur.connectDatabase(userName, password);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
