public class Magasin {
    private Produit[] produit;
    private int nbProduits;

    Magasin() {
        produit = new Produit[1000];
        nbProduits = 0;
    }

    public void ajoute_produit(Produit p) {
        for (int i = 0; i< produit.length; i++) {
            if (produit[i] == null) {
                produit[i] = p;
                break;
            }
        }
        nbProduits++; 
        
    }

    public Produit choisitProduit(String nomProduit){
        for (Produit el : produit) {
            if (el.getNom() == nomProduit) {
                return el;
            }
        }
        return null;
    }

    public String toString() {
        String representation = "Magasin, produits : ";
        for (Produit el : produit) {
            if (el != null) {
                representation += el.toString() + " ";
            }
        }
        return representation;
    }

    public static void main(String[] args) {
        Produit p1 = new Produit("ordinateur", 1000);
        Magasin Auchan = new Magasin();
        Auchan.ajoute_produit(p1);
        System.out.println(Auchan.toString());
        
    }
}