public class Tube {

    /*Complexité en O(n*m) n=lg et m=prix.length */
    static int prixOpt(int[] prix, int lg) {
        int[] p = new int[lg + 1];
        p[0] = 0;
        for (int i = 1; i <= lg; i++) {
            int res = 0;
            for (int j = 1; j < prix.length; j++) {
                if(j<=i) {
                    res = Math.max(res, prix[j] + p[i - j]);
                }
            }
            p[i] = res;
        }
    
        return p[lg];
    }

    /*complexité en O(n*m) n=lg et m=prix.length  */
    static int[] decOpt(int[] prix, int lg) {
        int[] p = new int[lg + 1];        
        int[] prec = new int[lg + 1];     
        int[] res = new int[prix.length]; 
        p[0] = 0;
        for (int k = 1; k <= lg; k++) {
            p[k] = 0;
            prec[k] = 0;
            for (int i = 1; i < prix.length; i++) {
                if (i<=k) {
                    if (prix[i] + p[k - i] > p[k]) {
                        p[k] = prix[i] + p[k - i];
                        prec[k] = i; 
                    }
                }
                
            }
        }

        int reste = lg;
        while (reste > 0) {
            int i = prec[reste];   
            res[i]++;             
            reste -= i;            
        }
        return res; 
    }

    public static void main(String[] args){
        int[] prix = {0,1,5,8,9,10,17,17,20,24,30};
        int lg = 27;
        System.out.println(prixOpt(prix, lg)); 
    }
}