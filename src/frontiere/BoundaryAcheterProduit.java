package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class BoundaryAcheterProduit {
    private Scanner scan = new Scanner(System.in);
    private ControlAcheterProduit controlAcheterProduit;

    public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
        this.controlAcheterProduit = controlAcheterProduit;
    }

    public void acheterProduit(String nomAcheteur) {
        boolean estHabitant = controlAcheterProduit.verifierIdentite(nomAcheteur);

        if (!estHabitant) {
            System.out.println("Je suis désolée " + nomAcheteur + " mais il faut être un habitant de notre village pour acheter des produits du marche.");
        } else {
	        System.out.println("Quel produit voulez-vous acheter ?");
	        String produit = scan.nextLine();
	
	        Gaulois[] vendeurs = controlAcheterProduit.listeVendeurs(produit);
	        if (vendeurs == null){
	        	System.out.println("Désolée, il n'y a pas de " + produit + " dans le marche.");
	        } else {
		        System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
		        for (int i = 0; i < vendeurs.length; i++) {
		            System.out.println((i + 1) + "- " + vendeurs[i].getNom());
		        }
		        int choixVendeur = Integer.parseInt(scan.nextLine()) - 1;
		        
		        Etal etal = Village.rechercherEtal(vendeurs[choixVendeur]);
		        System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + vendeurs[choixVendeur].getNom());
		        System.out.println("Bonjour " + nomAcheteur);
		        System.out.println("Combien de " + produit + " voulez-vous acheter ?");
		        int quantiteVoulue = Integer.parseInt(scan.nextLine());
		        if (quantiteVoulue <= etal.getQuantite()) {
		            etal.acheterProduit(quantiteVoulue);
		            System.out.println(nomAcheteur + " a acheté " + quantiteVoulue + " de " + produit + " à " + vendeurs[choixVendeur].getNom());
		        } else {
		        	System.out.println("Il n'y a pas assez de " + produit + " dans l'étal.");
		        }
	        }
        }
    }
}
