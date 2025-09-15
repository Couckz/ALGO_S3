public class Client {
    private String nom;
    private Produit[] caddy;
    private int nbProduits;

    Client(String nom) {
        this.nom = nom;
        caddy = new Produit[1000];
        nbProduits = 0;
    }
    public String getNom() {
        return nom;
    }

    private void ajouteProduit(Produit p) {
        for (int i = 0; i< caddy.length; i++) {
            if (caddy[i] == null) {
                caddy[i] = p;
                break;
            }
        }
        nbProduits++; 
    }

    public void choisitProduit(Magasin m, String nomProduit) {
        this.ajouteProduit(m.choisitProduit(nomProduit));
    }

    public double calculerPrixtotal() {
        double prix = 0;
        for (Produit el : caddy) {
            if(el != null){
                prix+=el.getPrix();
            }
            
        }
        return prix;
    }

    public String toString() {
        String representation = "Client (nom : " + nom + "), caddy : ";
        for (Produit el : caddy) {
            if (el != null) {
                representation += el.toString() + " ";
            }
        }
        return representation;
    }

    public static void main(String[] args) {
        Produit p1 = new Produit("ordinateur", 1000);
        Produit p2 = new Produit("ps5", 500);
        Magasin Auchan = new Magasin();
        Auchan.ajoute_produit(p1);
        Auchan.ajoute_produit(p2);
        Client Camelia = new Client("Camelia");
        Camelia.choisitProduit(Auchan, "ordinateur");
        Camelia.choisitProduit(Auchan, "ps5");
        System.out.println(Camelia.toString());
        System.out.println(Camelia.calculerPrixtotal());
        
        
    }
}
