
import java.util.ArrayList;
import java.util.Arrays;
/*Arrays.toString() */

public class PLSSC {

    /*Complexité en O(n^2) avec n=tab.length */
    static int longueurPlssc(int[] tab) {
            int[] longe = new int[tab.length];
            int plssc = 0;
            for (int i =0; i<tab.length; i++) {
                int max = tab[0];
                for(int j =0; j<i+1;j++){
                    if(tab[j]<tab[i]) {
                        if(longe[j] > max) {
                            max = longe[j]; 
                        }
                }
                longe[i] = 1+Math.max(0,max);
                
                }
                if (longe[i] > plssc) {
                    plssc = longe[i];
                }
            }
            return plssc;
        }
    
    /*Complexité en O(n^2) avec n=tab.length */
    static ArrayList <Integer > plssc(int[] tab) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int[] longe = new int[tab.length];
        int[] prec = new int[tab.length];
        int plssc = 0;
        int max_longe = 0;
        for (int i = 0; i < tab.length; i++) {
        int max = 0;       
        int bestJ = -1;   
        for (int j = 0; j < i; j++) {              
            if (tab[j] < tab[i]) {                
                if (longe[j] > max) {             
                    max = longe[j];
                    bestJ = j;
                }
            }
        }
        longe[i] = 1 + max;    
        prec[i] = bestJ;       
        if (longe[i] > plssc) {
            plssc = longe[i];
            max_longe = i;
        }
        
        
        }

        int el_ajouté = max_longe;
        res.add(0,tab[el_ajouté]);
        int i_prec = prec[15];
        int i_l = tab[i_prec];
        res.add(0,i_l);
        while(el_ajouté!=0) {
            int a = prec[i_prec];
            el_ajouté = tab[a];
            res.add(0,el_ajouté);
            i_prec=prec[i_prec];
        }
        return res; 
    }
        
        
    public static void main(String[] args){
        int tab[] = {0, 11, 11, 0, 11, 8, 2, 3, 7, 2, 7, 3, 13, 9, 6, 12, 9,
8, 7, 5};
        System.out.println(longueurPlssc(tab));
        System.out.println(plssc(tab).toString());
    }

}
