

public class Triangle {
    private Point p1;
    private Point p2;
    private Point p3;
    


    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public double perimetre() {
        Segment seg1 = new Segment(p2, p1);
        Segment seg2 = new Segment(p1, p3);
        Segment seg3 = new Segment(p3, p2);
        return seg1.longueur() + seg2.longueur() + seg3.longueur();

    }

    
    public void afficher() {
        System.out.print("Triangle[p1 : " + "Point(" + p1.getX() + "," + p1.getY() + ")" + ", p2 : " + "Point(" + p2.getX() + "," + p2.getY() + "), p3 : " + "Point(" + p3.getX() + "," + p3.getY() + ")]");
    }

    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,1);
        Point p3 = new Point(1,1);
        Point p4 = new Point(10,6);
        Point p5 = new Point(3,9);
        Point p6 = new Point(4,8);

        Triangle t1 = new Triangle(p1, p2, p3);
        Triangle t2 = new Triangle(p4, p5, p6);

        System.out.println("perimetre du triangle t1 :" + t1.perimetre());
        System.out.println("perimetre du triangle t2 :" + t2.perimetre());
        
    } 
}
