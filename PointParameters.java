import java.awt.Point;



public class PointParameters {

		 public static void main(String [] args) {
		 int x = 2, y = 2;
		 Point p = new Point(x, y), q = new Point(x, y);
		 System.out.println( "(x,y) = " + new Point(x, y) + " p = " + p + " q = " + q);
		 doubleScale(x, y, p, q);
		 System.out.println( "(x,y) = " + new Point(x, y) + " p = " + p + " q = " + q);
		 }
		 
		 private static void doubleScale(int x, int y, Point p, Point q)
		 {
		 x *= 2;
		 y *= 2;
		 p.x *= 2;
		 p.y *= 2;
		 q = new Point(x, y);
		 }
		} 

