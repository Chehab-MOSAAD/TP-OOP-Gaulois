package controleur;

import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		if (village.rechercherEtalVide()) {
			return true;
	    }
	    return false;
	}

    public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
        if (verifierIdentite(nomVendeur) && resteEtals()) {
            int numeroEtal = village.installerVendeur(village.trouverHabitant(nomVendeur), produit, nbProduit);
            return numeroEtal;
        } else {
            return -1;
        }
    }

	public boolean verifierIdentite(String nomVendeur) {
	    return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
}