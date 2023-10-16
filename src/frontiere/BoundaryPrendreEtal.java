package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

    public void prendreEtal(String nomVendeur) {
        if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
            System.out.println("Je suis désolée " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
        } else {
        	installerVendeur(nomVendeur);
        }
    }

    private void installerVendeur(String nomVendeur) {
    	System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.");

    	System.out.println("Quel produit souhaitez-vous vendre ?");
    	String produit = scan.nextLine();
    	
    	System.out.println("Combien souhaitez-vous en vendre ?");
    	int nbProduit = scan.nextInt();

    	scan.nextLine();
    	
    	int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
    	if (numeroEtal == -1) {
    	    System.out.println("Je suis désolée " + nomVendeur + " mais il ne me reste aucun étal pour vous !");
    	} else {
    	    System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n° " + numeroEtal + ".");
    	}
    }

}