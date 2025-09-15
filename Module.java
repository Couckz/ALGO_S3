import java.util.ArrayList;

public class Module {
    private String nom;
    private ArrayList<Etudiant> inscrits;

    Module(String nom) {
        this.nom = nom;
        this.inscrits = new ArrayList<Etudiant>();
    }

    public String getNom() {
        return nom;
    }

    public void inscrireEtudiant(Etudiant e) {
        inscrits.add(e);
    }

    public String toString() {
        String rep = "Module (nom : " + nom + ", inscrits : ";
        for (Etudiant el : inscrits) {
            rep += el.getNumero();
        }
        return rep;
    }

    public static void main(String[] args) {
        Etudiant a = new Etudiant(0, "Cam");
        Etudiant b = new Etudiant(1, "Tabtasim");
        Etudiant c = new Etudiant(2, "Aline");
        Etudiant d = new Etudiant(3, "Lysiana");
        Etudiant e = new Etudiant(4, "Heloise");
        Etudiant f = new Etudiant(5, "Gwennan");
        Etudiant g = new Etudiant(5, "Emma-Lyne");


        Module Thermo = new Module("Thermo");
        Module Math = new Module("Math");

        Thermo.inscrireEtudiant(a);
        Thermo.inscrireEtudiant(b);
        Thermo.inscrireEtudiant(c);
        Thermo.inscrireEtudiant(d);

        Math.inscrireEtudiant(e);
        Math.inscrireEtudiant(f);
        Math.inscrireEtudiant(e);
        Math.inscrireEtudiant(g);
    }
}
