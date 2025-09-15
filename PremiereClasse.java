public class PremiereClasse {

    public static void tableMultiplication(int n) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i+"x"+n+"="+(i*n));
        }
    }

    public static void afficheDiviseurs(int n) {
        for (int i=1; i<=n;i++) {
            int res = n%i;
            if (res == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        afficheDiviseurs(12); 
        tableMultiplication(5); 
        tableMultiplication(6);
    } 

}