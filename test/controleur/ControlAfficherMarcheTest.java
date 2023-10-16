package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village ("Le village des irreductibles", 10, 0);
	}
	
	@Test
	void testDonnerInfosMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		assertEquals(infosMarche.length, village.donnerNbEtal(), "Le nombre d'éléments dans le tableau ne correspond pas au nombre d'étals dans le village");
	}
	
	@Test
	void testNbEtal() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		int nbEtal = controlAfficherMarche.nbEtal();
		assertEquals(nbEtal, village.donnerNbEtal(), "Le nombre d'étals ne correspond pas");
	}
}
