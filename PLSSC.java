
import java.util.Arrays;
/*Arrays.toString() */

public class PLSSC {
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
    

    public static void main(String[] args){
        int tab[] = {0, 11, 11, 0, 11, 8, 2, 3, 7, 2, 7, 3, 13, 9, 6, 12, 9,
8, 7, 5};
        System.out.println(longueurPlssc(tab));
       
    }

}

