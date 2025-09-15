import java.util.HashMap;

public class Etudiant {
    private int numero;
    private String nom;
    private HashMap<Module,Double> notes;

    Etudiant(int numero, String nom) {
        this.numero = numero;
        this.nom = nom;
        this.notes = new HashMap<Module,Double>();
    }

    public String getNom() {
        return nom;
    }

    public int getNumero() {
        return numero;
    }

    public String toString() {
        String rep = "Etudiant (nom : " + nom + ", numéro : " + numero + ")" + ", notes : ";
        for (Module cle : notes.keySet()) {
            rep+=cle.getNom() + " : " + notes.get(cle);
        }
        return rep;
    }

    public void ajouteNode(Module m, double note) {
        notes.put(m, note);
    }
    public double getNote(Module m) {
        return notes.get(m);
    }
}