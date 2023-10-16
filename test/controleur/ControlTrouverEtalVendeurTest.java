package controleur;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import villagegaulois.Etal;
import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

public class ControlTrouverEtalVendeurTest {
    private Village village;
	private Chef abraracourcix;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

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
    }

    @Test
    public void testTrouverEtalVendeur() {
        Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine");
        Etal etalTrouve = controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine");
        assertEquals(etal, etalTrouve);
    }

    @Test
    public void testTrouverEtalVendeurNotFound() {
        Etal etalTrouve = controlTrouverEtalVendeur.trouverEtalVendeur("Abraracourcix");
        assertNull(etalTrouve);
    }

}
