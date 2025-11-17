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

    static int calculM(int n) {
        if(n<4){
            return 1;
        } else {
            return calculM(n/2)*2;
        }
    }

    static double evalue(double[] p, double al, int i, int j){
        if(j==i+1){
            return 0;
        } else {
            int m=calculM(j-1);
            return expoRapide(al, m)*evalue(p, al, m+i, j) + evalue(p, al, i, m+i);
        }
    }

    //Complexité en nlog base 2 (n)
    static double estrin(double[] p, double al){
        return evalue(p, al, 0, p.length);
    }

    //Complexité en o(n) avec n = p.length
    static double horner(double[] p, double al){
        double res = 0;
        for (int i=p.length-1;i>=0;i--) {
            res=res*al+p[i];
        }
        return res;
    }

    public static void main(String[] args) {
        double[] pol = {1.,2.,3.,4.,5.,6.,7.,8.,9.,10.,11.,12.,13.,14.,15.,16.,17.,18.,19.,20.};
        System.out.println(estrin(pol, -2.));
        System.out.println(horner(pol, -2.));
    }
}
