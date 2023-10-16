package controleur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

public class ControlAfficherVillageTest {
    private Village village;
    private Chef abraracourcix;
    private ControlAfficherVillage controlAfficherVillage;

    @BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village ("Le village des irreductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherVillage = new ControlAfficherVillage(village);
    }
		
    @Test
    public void testDonnerNomVillage() {
        Assertions.assertEquals("Le village des irreductibles", controlAfficherVillage.donnerNomVillage());
    }

    @Test
    public void testDonnerNomsVillageois() {
        String[] nomsAttendus = {"Abraracourcix"};
        Assertions.assertArrayEquals(nomsAttendus, controlAfficherVillage.donnerNomsVillageois());
    }

    @Test
    public void testDonnerNbEtals() {
        Assertions.assertEquals(5, controlAfficherVillage.donnerNbEtals());
    }
}
