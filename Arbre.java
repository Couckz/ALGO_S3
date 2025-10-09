import java.util.ArrayList;

public class Arbre {
    private Noeud racine;

    Arbre(Noeud racine) {
        this.racine = racine;
    }

    public int hauteur() {
        if (racine == null) {
            return -1;
        } else {
            return racine.hauteur();
        }
    }

    public int taille() {
        if (racine == null) {
            return 0;
        } else {
            return racine.taille();
        }
    }

    public int nbFeuilles() {
        if (racine == null) {
            return 0;
        } else {
            return racine.nbFeuilles();
        }
    }

    public int sommeEtiquettes() {
        if (racine == null) {
            return 0;
        } else {
            return (racine.sommeEtiquettes()+racine.getValeur());
        }
    }

    public ArrayList<Integer> listeInfixe() {
        if (racine == null) {
            ArrayList<Integer> t = new ArrayList<Integer>();
            return t;
        } else {
            return racine.listeInfixe();
        }
    }

    public boolean appartient(int e){
        if(racine != null) {
            if(racine.appartient(e)) {
                return true;
            };
        }
        return false;
    }

    public ArrayList<Integer> parents(int e) {
        if (racine == null) {
            ArrayList<Integer> t = new ArrayList<Integer>();
            return t;
        } else {
            return racine.parents(e);
        }
    }

    public int evalue() {
        if (racine == null) {
            return 0;
        }
        return racine.evalue();
        
    }

    static Arbre arbreMini(int n) {
        /*if (n == 0) {
            return new Arbre(null);
        }
        return new Arbre(Noeud.arbreMini(n));*/
        return null;
    }

    static Arbre fermat(int n) {
        return null;
    }

    public static void main(String[] args) {
        Noeud n5 = new Noeud(22, null, null);
        Noeud n4 = new Noeud(41, null, null);
        Noeud n3 = new Noeud(41, null, null);
        Noeud n2 = new Noeud(15, n4, n5);
        Noeud n1 = new Noeud(28, n2, n3);
        Arbre Arbrex = new Arbre(n1);  
        Arbre a2 = new Arbre(null);  
        System.out.println("Résultat de Arbrex.hauteur : " + Arbrex.hauteur());
        System.out.println("Résultat de Arbrex.taille : " +Arbrex.taille());
        System.out.println("Résultat de Arbrex.nbFeuilles : " +Arbrex.nbFeuilles());
        System.out.println("Résultat de Arbrex.listeInfixe : " +Arbrex.listeInfixe());
        System.out.println("Résultat de Arbrex.appartient : " +Arbrex.appartient(28));
        System.out.println("Résultat de Arbrex.evalue : " +Arbrex.evalue());
        System.out.println("Résultat de Arbrex.sommeEtiquettes : " +Arbrex.sommeEtiquettes());
        
    }
}

