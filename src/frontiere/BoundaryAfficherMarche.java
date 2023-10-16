package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		int nbEtals = controlAfficherMarche.nbEtal() ;
		System.out.println(nomAcheteur + ", vous trouverez au marché :");
		
		for (int i = 0; i < nbEtals; i++) {
		    int j = i*3;
		    if (j+2 < infosMarche.length) {
		        System.out.println("- " + infosMarche[j] + " qui vend " + infosMarche[j+1] + " " + infosMarche[j+2]);
		    }
		}
	}
}