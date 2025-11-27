import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

@SuppressWarnings("unchained")
public class Point{
    double x;
    double y;
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    double distanceTo(Point p){
        double dx = x-p.x;
        double dy = y-p.y;
        return Math.sqrt(dx*dx+dy*dy);
    }
    boolean lessXY(Point p){
        return x < p.x || (x == p.x && y < p.y);
    }
    boolean lessYX(Point p){
        return y < p.y || (y == p.y && x < p.x);
    }
    public Object clone(){
        return new Point(x,y);
    }

    public String toString(){
        return "("+(int)(10*x)*1.0/10+","+(int)(10*y)*1.0/10+")";
    }
    public static String tabtoString(Point[] tab){
        String res = "[";
        for(Point p : tab){
            res+=p+",";
        }
        return res+"]";
    }

    static Point[] pprocheNaive(ArrayList<Point> points){
        Point[] res = new Point[2];
        res[0] = points.get(0);
        res[1] = points.get(1);
        double d = res[0].distanceTo(res[1]);
        for(Point p1 : points) {
            for(Point p2 : points) {
                if(p1!=p2) {
                    if(p1.distanceTo(p2)<d) {
                        res[0] = p1;
                        res[1] = p2;
                        d = res[0].distanceTo(res[1]);
                    }
                }
            }
        }
        return res;
    }

    static void quickSortX(ArrayList<Point> points, int i, int j){
        if(j>i+1){
            int pivot = i;
            for(int k=i+1;k<j;k++){
                if(points.get(k).lessXY(points.get(pivot))){
                    Point tmp = points.get(pivot);
                    points.set(pivot,points.get(k));
                    points.set(k,points.get(pivot+1));
                    points.set(pivot+1,tmp);
                    pivot++;
                }
            }
            quickSortX(points, pivot+1, j);
            quickSortX(points, i, pivot);
        }
    }

    static void trierSelonX(ArrayList<Point> points){
        quickSortX(points, 0, points.size());
    }

    static void quickSortY(ArrayList<Point> points, int i, int j){
        if(j>i+1){
            int pivot = i;
            for(int k=i+1;k<j;k++){
                if(points.get(k).lessYX(points.get(pivot))){
                    Point tmp = points.get(pivot);
                    points.set(pivot,points.get(k));
                    points.set(k,points.get(pivot+1));
                    points.set(pivot+1,tmp);
                    pivot++;
                }
            }
            quickSortY(points, pivot+1, j);
            quickSortY(points, i, pivot);
        }
    }

    static void trierSelonY(ArrayList<Point> points){
        quickSortY(points, 0, points.size());
    }

    static ArrayList<Point>[] diviser(ArrayList<Point> points, Point pivot){
        ArrayList<Point>[] res = new ArrayList<Point>[2];
        res[0] = new ArrayList<Point>();
        res[1] = new ArrayList<Point>();
        for(Point p: points) {
            if(p.lessXY(pivot)) {
                res[0].add(p);
                } else {
                    res[1].add(p);
                }
        }
        return res;
    }

    static ArrayList<Point> filtrer(ArrayList<Point> points, double x_mini, double x_maxi){
        ArrayList<Point> res = new ArrayList<>(points);
        for(Point p: points) {
            if(p.x > x_mini && p.x < x_maxi) {
                res.add(p);
            }
        }
        return res;
    }

    static Point[] pprocheDPR(ArrayList<Point> pointsX, ArrayList<Point> pointsY){
        if(pointsX.size() <= 3) {
            return pprocheNaive(pointsX);
        }
        Point pivot = pointsX.get(pointsX.size()/2);
        ArrayList<Point>[] ppx = diviser(pointsX, pivot);
        ArrayList<Point>[] ppy = diviser(pointsY, pivot);
        Point[] res = pprocheDPR(ppx[0], ppy[0]);
        Point[] resD = pprocheDPR(ppx[1], ppy[1]);
        double d = res[0].distanceTo(res[1]);
        if(resD[0].distanceTo(resD[1])<d) {
            res[0] = resD[0];
            res[1] = resD[1];
            d = res[0].distanceTo(res[1]);
        }
        ArrayList<Point> ybande = filtrer(pointsY, pivot.x - d, pivot.x+d);

        for(int i=0;i<ybande.size();i++) {
            for(int j=i+1; j<Math.min(i+8,ybande.size());j++) {
                res[0] = ybande.get(i);
                res[1] = ybande.get(j);
                d = res[0].distanceTo(res[1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println("Recherche des ppp parmi "+n+" points :");
        ArrayList<Point> points = new ArrayList<Point>();
        Random r = new Random();
        for(int i=0;i<n;i++){
            points.add(new Point(100*r.nextDouble(),100*r.nextDouble()));
        }
        long time = System.currentTimeMillis();
        Point[] ppp = pprocheNaive(points);
        System.out.println("Plus proches : "+ppp[0]+" et "+ppp[1]);
        System.out.println("Durée calcul : "+(1.*(System.currentTimeMillis()-time)/1000)+" secondes");

        ArrayList<Point> copyPoints = new ArrayList<Point>();
        copyPoints.addAll(points);

        trierSelonX(points);
        trierSelonY(copyPoints);

        time = System.currentTimeMillis();
        Point[] ppp2 = pprocheDPR(points,copyPoints);
        System.out.println("Plus proches : "+ppp2[0]+" et "+ppp2[1]);
        System.out.println("Durée calcul : "+(1.*(System.currentTimeMillis()-time)/1000)+" secondes");
    }
}
