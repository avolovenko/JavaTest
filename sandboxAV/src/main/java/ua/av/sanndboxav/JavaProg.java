package ua.av.sanndboxav;

public class JavaProg {

  public static void main(String[] args) {

   Point p1 = new Point(0,0);

   String s1 = "(" + p1.x1 + "," + p1.y1 + ")";

   System.out.println("Расстояние между точками " + s1 + " и (3,4) равно " + p1.distance(3,4));

  }

}