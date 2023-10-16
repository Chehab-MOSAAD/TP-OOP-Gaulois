package controleur;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

public class ControlVerifierIdentiteTest {
    private Village village;
	private Chef abraracourcix;
    private ControlVerifierIdentite controlVerifierIdentite;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village ("Le village des irreductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleur", 5);
        controlVerifierIdentite = new ControlVerifierIdentite(village);
    }

    @Test
    public void testVerifierIdentiteWithExistingVendeur() {
        assertTrue(controlVerifierIdentite.verifierIdentite("Bonemine"));
    }

    @Test
    public void testVerifierIdentiteWithNonExistingVendeur() {
        assertFalse(controlVerifierIdentite.verifierIdentite("Astérix"));
    }
}
