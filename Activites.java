import java.util.Arrays;

public class Activites {

    public static int cardinal(boolean[] ens) {
        int res = 0;
        for (boolean el : ens) {
            if (el == true) {
                res++;
            }
        }
        return res;
    }

    /*Complexité en O(n) avec n la taille du tableau en paramètre */
    public static boolean[] tabVersEns(int[] tab, int maxi) {
        boolean[] res = new boolean[maxi];
        for (int el : tab) {
            res[el] = true;
        }
        return res;
    }

    /*Complexité en O(2n) avec n la taille du tableau en paramètre */
    public static int[] ensVersTab(boolean[] ens) {
        int[] res = new int[ens.length];
        int count = 0;
        for(int i = 0; i<res.length;i++){
            if(ens[i] == true) {
                res[count] = i;
                count++;
            }
        }
        int[] res2 = new int[count];
        for(int i = 0; i<res.length;i++) {
            if (res[i] != 0) {
                res2[i] = res[i];
            }
        }
        return res2;
    }
    
    /*Complexité en O(n) avec n la taille du tableau ens1 */
    public static boolean[] diff(boolean[] ens1, boolean[] ens2) {
        boolean[] res = new boolean[ens1.length];
        for (int i = 0; i<ens1.length; i++) {
            if(ens1[i] == true && ens2[i] == true) {
                res[i] = false;
            } else if(ens1[i] == false && ens2[i] == true) {
                res[i] = false;
            } else if(ens1[i] == true && ens2[i] == false) {
                res[i] = true;
            } else if(ens1[i] == false && ens2[i] == false) {
                res[i] = false;
            }
        }
        return res;
    }

    /*Complexité en O(n) avec n la taille du tableau ens*/
    public static boolean nonVide(boolean[] ens) {
        for (boolean el : ens) {
            if (el == true) {
                return true;
            }
        }
        return false;
    }

    /*Complexité en O(n), étant celle appliquée pour l'appel de diff */
    public static boolean[] ensRestants(boolean[] ensEleves ,boolean[] act) {
        boolean[] res = diff(ensEleves, act);
        return res;
    }

    static int nbreRestants(boolean[] ensEleves , boolean[] act) {
        boolean[] res1 = diff(ensEleves, act);
        int compteur = 0;
        for (boolean el : res1) {
            if (el == true) {
                compteur++;
            }
        }
        return compteur;
    }

    static int meilleureActivite(boolean[][] acts, boolean[] ensEleve) {
        int indice = 0;
        int nb_éleves_intéressés = nbreRestants(ensEleve, acts[0]);
        for (int i = 1; i<acts.length; i++) {
            if (nbreRestants(ensEleve, acts[i]) <= nb_éleves_intéressés) {
                indice = i;
                nb_éleves_intéressés = nbreRestants(ensEleve, acts[i]);
            }
        }
        return indice;
    }

    static boolean couvre(boolean[] ensActs, boolean[][] acts) {
        int ligne = 0;
        int counter = 0;
        for(int i=0;i<ensActs.length;i++) {
            if (ensActs[i] == true) {
                ligne++;
            }
        }
        boolean[][] tab = new boolean[ligne][acts[0].length];
        int k = 0;
        for(int j=0;j<ensActs.length;j++) {
            if (ensActs[j] == true) {
                tab[k] = acts[j];
                k++;
            }
        }
        for(int b=0;b<tab.length;b++) {
            System.out.println(Arrays.toString(tab[b]));
        }
        for (int j = 0; j < tab[0].length; j++) {
            int countFalse = 0;
            for (int i = 0; i < tab.length; i++) { 
                if (!tab[i][j]) {
                    countFalse++;
                }
                if (countFalse == ligne) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean[] MAJ(boolean[] tab, boolean[] tabcalc) {
        boolean[] res = new boolean[tab.length];
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] && !tabcalc[i]) {
                res[i] = true;
            } else {
                res[i] = false;
            }
        }
        return res;
    }

    static boolean[] glouton(boolean[][] acts) {
        boolean[][] nouv_act0 = new boolean[acts.length][acts[0].length];
        boolean[][] a_travailler = new boolean[acts.length][acts[0].length];
        boolean[] eleve = new boolean[acts[0].length];
        boolean[][] best_act = new boolean[acts.length][acts[0].length];
        int[] indice = new int[acts.length];
        boolean[] res = new boolean[acts.length];

        for (int i = 0; i < eleve.length; i++) {
            eleve[i] = true;
        }
        System.out.println(Arrays.toString(eleve));

        /*copie acts dans a travailler */
        for(int i =0;i<a_travailler.length;i++) {
            for(int j=0;j<a_travailler[0].length;j++) {
                a_travailler[i][j] = acts[i][j];
            }
        }
        
        boolean[] tableau = new boolean[acts[0].length];

        int count = 0;
        while (nonVide(eleve)) {
            int var = meilleureActivite(a_travailler, eleve);
            res[var] = true;
            System.out.println("indice de la meilleure act = " + var);
            best_act[count] = a_travailler[var];
            System.out.println("Meilleure activité" + Arrays.toString(best_act[count]));
            eleve = MAJ(eleve, a_travailler[var]);
            a_travailler[var] = tableau;
            
            /*count++;
            if (count >= a_travailler.length-2) {
                break;
            }
        }*/
        }
        return res;
    }

    static boolean[] optimale(boolean[][] acts) {
        boolean[] res = {true, true, true, false};
        return res;
    }

    public static void main(String[] args) {
        boolean[] Enseleve = {false, true, false, true, false, true};
        boolean[] Enseleve2 = {true,true,true,false,false,false,false};
        boolean[] act = {true, true, false , false, false, true};
        boolean[][] act0 = {
            {true,true,true,false,false,false,false},
            {false,true,false,true,false,false,false},
            {true,false,true,false,true,false,true},
            {false,false,false,true,false,true,false},
            {true,false,false,true,false,false,true}
        };
        boolean[] couvre1 = {false,false,true,false,false};
        boolean[] couvre2 = {true,true,true,true,false};
        System.out.println(Arrays.toString(ensRestants(Enseleve, act)));
        System.out.println((nbreRestants(Enseleve, act)));
        System.out.println(meilleureActivite(act0, Enseleve));
        System.out.println(couvre(couvre1, act0));
        System.out.println(couvre(couvre2, act0));
        System.out.println(Arrays.toString(glouton(act0)));
        System.out.println(Arrays.toString(MAJ(couvre1, couvre2)));
        System.out.println(Arrays.toString(optimale(act0)));
    }
}