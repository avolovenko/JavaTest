package ua.av.sanndboxav;

public class JavaProg {

  public static void main(String[] args) {

   Point p1 = new Point(1,2);

   Point p2 = new Point(3, 4);

   String s1 = "(" + p1.x + "," + p1.y + ")";
   String s2 = "(" + p2.x + "," + p2.y + ")";
   System.out.println("Расстояние между точками " + s1 + " и " + s2 + " = " + distance(p1, p2));

  }

  public static double distance(Point p1, Point p2) {
    double d = Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
    return d;
  }
}