import java.util.Arrays; /*Possibilité d'utiliser la fonction Arrays.toString() pour afficher le contenu d'un tableau*/

public class RenduMonnaie {
    
    /*Complexité en O(n) avec n la taille du tableau passé en paramètre */
    public static boolean verifieSysteme(int[] tab) {
        int value = tab[0];
        for (int i = 1; i<tab.length; i++) {
            if (tab[i] == value || tab[i] > value || tab[tab.length-1] != 1) {
                return false;
            }
            value = tab[i];
        }
        return true;
    }

    /*Complexité en O(n) avec n la taille du tableau passé en paramètre */
    public static int[] rend(int x, int[] c) {
        int value = x;
        int[] res = new int[c.length];
        for (int i = 0; i<c.length;i++) {
            if (value > c[i]) {
                res[i] = value / c[i];
                System.out.println("res[i] = " + res[i]);
                value = value - res[i]*c[i];
                System.out.println("value =" + value);
            } else {
                res[i] = 0;
            }
        }
        return res;
    }

    /* Complexité en O(n) avec n la taille du tableau en paramètre*/
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

    public static void main(String[] args) {
        int[] tab = {200,100,50,20,10,2,2,1};
        int[] tab2 = {200,100,50,20,10,5,2,1};
        boolean[] test = {true,false,false,true,true,false};
        int[] res = {1,5,6,8};
        boolean[] test2 = {false, true, false, false, false, true, true, false, true};
        boolean[] ens1 = {false, true, false, true, false, true};
        boolean[] ens2 = {true, true, false, false,false, true};
        System.out.println(verifieSysteme(tab));
        System.out.println(Arrays.toString(rend(64, tab2)));
        System.out.println(cardinal(test));
        System.out.println(Arrays.toString(tabVersEns(res, 9)));
        System.out.println(Arrays.toString(ensVersTab(test2)));
        System.out.println(Arrays.toString(diff(ens1, ens2)));
        System.out.println(nonVide(test));
    }
}
