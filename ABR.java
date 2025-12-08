public class ABR {
    int cle;
    int valeur;
    ABR filsGauche;
    ABR filsDroit;

    public ABR(int c, int v, ABR fg, ABR fd) {
        cle = c;
        valeur = v;
        filsGauche = fg;
        filsDroit = fd;
    }

    public ABR(int[] tab_cles, int[] tab_valeurs) {

    }

    public boolean appartient(int c) {
        return true;
    }

    public int getValeur(int c) {
        return valeur;
    }

    public void insert(int c, int v) {

    }

    private int[] estABR_aux() {
        int[] res = new int[3];
        if(filsGauche == null) {
            res[0] = cle;
            res[1] = 1;
        } else {
            int[] resG = filsGauche.estABR_aux();
            res[0] = resG[0];
            if(cle>resG[1]&&resG[2]==1){
                res[2]=1;
            } else {
                res[2]=2;
            }

            if(filsDroit == null) {
                res[1]=cle;
            } else {
                int[] resD = filsDroit.estABR_aux();
                res[1] = resD[1];
                if(cle<resD[0] && resD[2] == 1 && res[2]==1) {
                    res[2]=1;
                } else {
                    res[2]=0;
                }
            }
        }
        return res;
    }

    public boolean estABR(){
        if(estABR_aux()[2] == 1) {
            return true;
        }
        return false;
    }

    public boolean estFeuille() {
            if(filsDroit == null && filsGauche == null) {
                return true;
            }
            return false;
    }

    public int maxi() {
        if (filsDroit!= null) {
            return maxi();
        } else {
            return filsDroit.cle;
        }
    }

    private void sepRacine() {

    }

    
    private void sepMaxi() {

    }


    public void supprime(int cle) {

    }
    public static void main(String[] args) {

    }
}
