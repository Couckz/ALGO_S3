public class Point {
   private double x;
   private double y;

   public Point(double x, double y) {
      this.x = x;
      this.y = y;
   }

   public double getX() {
      return this.x;
   }

   public double getY() {
      return this.y;
   }

   public void afficher() {
      System.out.print("Point(" + x + "," + y + ")");
   }

   public static void main(String[] args) {
      Point p1 = new Point(3.0, 2.0);
      Point p2 = new Point(4.0, 5.0);
      Point p3 = new Point(1.0, 8.0);
      p1.afficher();
      p2.afficher();
      p3.afficher(); 
   }
}
