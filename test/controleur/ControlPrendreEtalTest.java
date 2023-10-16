package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
    private Village village;
	private Chef abraracourcix;
    private ControlVerifierIdentite controlVerifierIdentite;
    private ControlPrendreEtal controlPrendreEtal;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village ("Le village des irreductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
        controlVerifierIdentite = new ControlVerifierIdentite(village);
        controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
    }

    @Test
    void testResteEtals() {
        village.installerVendeur(village.trouverHabitant("Bonemine"), "fleur", 1);
        assertTrue(controlPrendreEtal.resteEtals());
    }

    @Test
    void testPrendreEtal() {
        assertEquals(-1, controlPrendreEtal.prendreEtal("Astérix", "poisson", 1));
        village.installerVendeur(village.trouverHabitant("Bonemine"), "fleur", 1);
        assertEquals(1, controlPrendreEtal.prendreEtal("Bonemine", "fleur", 1));
    }

    @Test
    void testVerifierIdentite() {
        assertTrue(controlPrendreEtal.verifierIdentite("Bonemine"));
        assertFalse(controlPrendreEtal.verifierIdentite("Astérix"));
    }

}
