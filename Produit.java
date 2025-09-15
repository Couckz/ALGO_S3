public class Produit {
    private double prix;
    private String nom;

    Produit(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }
    
    public String toString() {
        String representation = "Produit" + "(" + "nom : " + nom + ", " + "prix : " + prix + ")";
        return representation;
    }
    public static void main(String[] args) {
        Produit p1 = new Produit("Ordinateur", 200);
        System.out.println("p1 : "+p1.toString());
    }

}