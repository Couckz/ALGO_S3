public class Segment {
   private Point ext1;
   private Point ext2;

   public Segment(Point ext1, Point ext2) {
      this.ext1 = ext1;
      this.ext2 = ext2;
   }

   public double longueur() {
      double x1 = ext1.getX();
      double x2 = ext2.getX();
      double y1 = ext1.getY();
      double y2 = ext2.getY();
      return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
   }

   public static void main(String[] args) {
      Point p1 = new Point(2.0, 2.0);
      Point p2 = new Point(4.0, 4.0);
      Point p3 = new Point(5.0, 5.0);
      Point p4 = new Point(6.0, 6.0);
      Segment s1 = new Segment(p3, p4);
      s1.longueur();
   } 
}
