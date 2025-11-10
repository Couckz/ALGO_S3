public class Estrin{

    public static double expoRapide(double x, int n){
        if(n==0){
            return 1.;
        }else{
            double a = expoRapide(x, n/2);
            if(n%2==0){
                return a*a;
            }else{
                return a*a*x;
            }
        }
    }
    static double evalue(double[] p, double al, int i, int j){
        double res = 0;
        for (int l=0; l<p.length;l++) {
            res+=p[l]*expoRapide(al, l);
        }
        return res;
    }
    static double estrin(double[] p, double al){
        // A compléter
        return 0.;
    }

    static double horner(double[] p, double al){
        // A compléter
        return 0.;
    }

    public static void main(String[] args) {
        double[] pol = {1.,2.,3.,4.,5.,6.,7.,8.,9.,10.,11.,12.,13.,14.,15.,16.,17.,18.,19.,20.};
        System.out.println(evalue(pol, -2, 0, 0));
        System.out.println(estrin(pol, -2.));
        System.out.println(horner(pol, -2.));
    }
}
