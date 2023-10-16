package controleur;

import villagegaulois.Village;
import villagegaulois.Etal;

public class ControlLibererEtal {
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
    private Village village;

    public ControlLibererEtal(ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
        this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
        this.village = village;
    }

    public boolean isVendeur(String nomVendeur) {
        return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur) != null;
    }

    public String[] libererEtal(String nomVendeur) {
        String[] donneesEtal = null;
        if (isVendeur(nomVendeur)) {
            Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
            if (etal != null) {
                donneesEtal = etal.etatEtal();
                etal.libererEtal();
            }
        }
        return donneesEtal;
    }
}
