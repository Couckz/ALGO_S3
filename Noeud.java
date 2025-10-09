import java.lang.annotation.Retention;
import java.util.ArrayList;

public class Noeud {
    private int valeur;
    private Noeud filsGauche;
    private Noeud filsDroit;

    Noeud(int valeur, Noeud filsGauche, Noeud filsDroit) {
        this.valeur = valeur;
        this.filsGauche = filsGauche;
        this.filsDroit = filsDroit;
    }

    public int getValeur() {
        return valeur;
    }
    public int taille() {
        int res = 0;

        if (filsGauche == null || filsDroit == null) {
            return 1;
        }

        if (filsGauche != null) {
            res+=filsGauche.taille();
            
        }

        if (filsDroit != null) {
            res+=filsDroit.taille();
            
        }

        return res+1;
    }

    public int hauteur() {
        int res = 0; 
        if (filsDroit != null) {
            res=filsDroit.hauteur()+1;
        }

        if (filsGauche != null) {
            res=Math.max(filsGauche.hauteur()+1, res);
        }

        return res;
    } 

    public int nbFeuilles() {
        int res = 0;
        if (filsGauche == null && filsDroit == null) {
            res++;
        }

        if (filsGauche != null && filsDroit != null) {
            res+=filsGauche.nbFeuilles();
            res+=filsDroit.nbFeuilles();
            return res;
        }

        return res;
    }

    public int sommeEtiquettes() {
        int res = 0;

        if (filsGauche != null) {
            res+=filsGauche.valeur;
            res+=filsGauche.sommeEtiquettes();
            
        }
        if (filsDroit != null) {
            res+=filsDroit.valeur;
            res+=filsDroit.sommeEtiquettes(); 
        }
        return res;
    }

    public ArrayList<Integer> listeInfixe() {
        ArrayList<Integer> tab = new ArrayList<Integer>();

        if (filsGauche == null && filsDroit == null) {
            tab.add(valeur);
            return tab;
        }
        if (filsGauche != null) {
            tab.addAll(filsGauche.listeInfixe());
            tab.add(valeur);
        }

        if (filsDroit != null) {
            tab.addAll(filsDroit.listeInfixe());
        }
        return tab;

    }

    public boolean appartient(int e) {

        if (filsGauche == null && filsDroit == null) {
            if (valeur == e) {
                return true;
            }   
        }

        if(valeur == e) {
            return true;
        }

        if (filsGauche != null) {
            if (filsGauche.valeur == e) {
                return true;
            } else {
                if (filsGauche.appartient(e)) {
                    return true;
                }
            }
        }

        if (filsDroit != null) {
            if (filsDroit.valeur == e) {
                return true;
            } else {
                if (filsDroit.appartient(e)) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Integer> parents(int e) {
        ArrayList<Integer> t = new ArrayList<Integer>();
        
        if (filsGauche != null) {
            if(filsGauche.valeur == e) {
                t.add(valeur);
            }
            t.addAll(filsGauche.parents(e));
        }
        if (filsDroit != null) {
            if(filsDroit.valeur == e) {
                t.add(valeur);
            }
            t.addAll(filsDroit.parents(e));
        }
        return t;
    
    }

    public static int expo2(int n) {
        int res = 1;
        if (n%2 == 0) {
            for (int i = 0; i < n/2;i++) {
                res = 4*res;
            }
        } else {
            for (int j = 0; j < n/2;j++) {
                res = 4*res;
            }
            res = 2*res;
        }
        return res;
    }

    public int evalue() {
        if (filsGauche != null && filsDroit != null) {
            return expo2(filsGauche.evalue()) + filsDroit.evalue();
        }

        if (filsDroit != null && filsGauche == null) {
            return filsDroit.evalue() + 1;
        } 

        if (filsDroit == null && filsGauche != null) {
            return expo2(filsGauche.evalue());
        } 

        return 0;
        
    }

    static int dec2P(int n) {
        int p = 1;
        while (expo2(p) < n) {
            p = p+1;
        } 
        return p; 
    }

    static int dec2Q(int n) {
        int q = 1;
        int p = dec2P(n);
        while (expo2(p) + q != n) {
            q=q+1;
        }
        return q;
    }

    static Noeud arbreMini(int n) {
        if (n == 0) {
            Noeud monoeud = new Noeud(0, null, null);
            return monoeud;
        }

        return new Noeud(n, arbreMini(dec2P(n)), arbreMini(dec2Q(n)));
    }


    public static void main(String[] args) {
        Noeud n5 = new Noeud(22, null, null);
        Noeud n4 = new Noeud(41, null, null);
        Noeud n3 = new Noeud(41, null, null);
        Noeud n2 = new Noeud(15, n4, n5);
        Noeud n1 = new Noeud(28, n2, n3);
        Arbre ArbrEx = new Arbre(n1);
        System.out.println(n1.sommeEtiquettes());
        System.out.println(n1.nbFeuilles());
        System.out.println(n1.listeInfixe());
        System.out.println(n1.appartient(28));
        System.out.println(n1.parents(41));
        System.out.println("resultat de dec2Q : "+dec2Q(8));
        System.out.println("résultat de dec2P : "+dec2P(7));
        System.out.println("Resulat de n1. evalue : " + n1.evalue()); /* Pour n1 c'est censé renvoyer 2 */
        System.out.println("Resultat de sommetiquettes : "+ n1.sommeEtiquettes());
    }
}

