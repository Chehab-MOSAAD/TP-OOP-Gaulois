package controleur;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.*;

public class ControlLibererEtalTest {
    private Village village;
	private Chef abraracourcix;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
    private ControlLibererEtal controlLibererEtal;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village ("Le village des irreductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "fleur", 5);
        controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
        controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur, village);
	}

    @Test
    public void testIsVendeur() {
        assertFalse(controlLibererEtal.isVendeur("Astérix"));
        assertTrue(controlLibererEtal.isVendeur("Bonemine"));
        assertFalse(controlLibererEtal.isVendeur("Abraracourcix"));
    }

    @Test
    public void testLibererEtal() {
        controlLibererEtal.libererEtal("Bonemine");
        assertEquals(0, village.donnerNbEtal());
    }
}
