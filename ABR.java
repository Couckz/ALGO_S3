public class ABR {
    private int cle;
    private int valeur;
    private ABR filsGauche;
    private ABR filsDroit;

    public ABR(int c, int v, ABR fg, ABR fd) {
        cle = c;
        valeur = v;
        filsGauche = fg;
        filsDroit = fd;
    }

    public ABR(int[] tab_cles, int[] tab_valeurs) {
        if (tab_cles.length <= 2) {
            cle = tab_cles[0];
            valeur = tab_valeurs[0];
        }

        if(tab_cles.length==2) {
            filsDroit = new ABR(tab_cles[1], tab_valeurs[1], null,  null);
        } else {
            int m = tab_cles.length / 2;
            cle = tab_cles[m];
            valeur = tab_valeurs[m];
            int[] debut = new int[m];
            int[] vdebut = new int[m];
                int taille_fd = tab_cles.length - m - 1;
                int[] fin = new int[taille_fd];
                int[] vfin = new int[taille_fd];
                for (int i = 0; i < debut.length; i++) {
                    debut[i] = tab_cles[i];
                    vdebut[i] = tab_valeurs[i];
                }
                for (int i = 0; i < fin.length; i++) {
                    fin[i] = tab_cles[m + i + 1];
                    vfin[i] = tab_valeurs[m+i+1];
                }
                filsGauche = new ABR(debut, vdebut);
                filsDroit = new ABR(fin, vfin);
                }
            }
        
    /*Tester si une clé appartient bien à l'arbre. Complexité O(h), h = hauteur de l'arbre */
    public boolean appartient(int c) {
        if(c == cle) {
            return true;
        } else if(c<cle) {
            if(filsGauche != null) {
                return filsGauche.appartient(c);
            } else {
                return false;
            }
        } else {
            if(filsDroit != null) {
                return filsDroit.appartient(c);
            } else {
                return false;
            }
        }
    }

    /*Retourner la valeur d'une clé. Complexité en O(h) avec h hauteur de l'arbre */
    public int getValeur(int c) {
            if (c == cle) {
                return valeur;
            } else if (c < cle) {
                if (filsGauche != null) {
                    return filsGauche.getValeur(c);
                } else {
                    return 0;
                }
            } else {
                if (filsDroit != null) {
                    return filsDroit.getValeur(c);
                } else {
                    return 0;
                }
            }
        
    }

    /*Insérer  */
    public void insert(int c, int v) {
        if (c == cle) {
            valeur = v;
        } 
        else if (c < cle) {
            if (filsGauche != null) {
                filsGauche.insert(c, v);
            } else {
                filsGauche = new ABR(c, v, null, null);
            }
        } 
        else {
            if (filsDroit != null) {
                filsDroit.insert(c, v);
            } else {
                filsDroit = new ABR(c, v, null, null);
            }
        }
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
            return filsDroit.maxi();
        } else {
            return cle;
        }
    }

    private void sepRacine() {
        if(filsGauche != null) {
            if(filsGauche.estFeuille()) {
                cle = filsGauche.cle;
                valeur = filsGauche.valeur;
                filsGauche = null;
            } else {
                cle = filsGauche.maxi();
                valeur = filsDroit.valeur;
                filsGauche = filsDroit.filsGauche;
                filsDroit = filsDroit.filsDroit;
            }
        }
    }

    
    private void sepMaxi() {
        if(filsDroit != null) {
            if(filsDroit.estFeuille()) {
                filsDroit = null;
            } else {
                filsDroit.sepMaxi();
            }
        } else {
            cle = filsGauche.cle;
            valeur = filsGauche.valeur;
            filsDroit = filsGauche.filsDroit;
            filsGauche = filsGauche.filsGauche;
        }
    }


    public void supprime(int c) {
        if(cle == c) {
            this.sepRacine();
        } else if(c<cle) {
            if(filsGauche.estFeuille()) {
                filsGauche = null;
            } else {
                filsGauche.supprime(c);
            }
        } else {
            if(filsDroit.estFeuille()) {
                filsDroit = null;
            } else {
                filsDroit.supprime(c);
            }
        }
    }
}
