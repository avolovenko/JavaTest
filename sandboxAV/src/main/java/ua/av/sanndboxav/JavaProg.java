package ua.av.sanndboxav;

public class JavaProg {

  public static void main(String[] args) {

    int x1 = 1;
    int y1 = 2;
    int x2 = 3;
    int y2 = 4;

    String p1 = "(" + x1 + "," + y1 + ")";
    String p2 = "(" + x2 + "," + y2 + ")";
    System.out.println("Расстояние между точками " + p1 + " и " + p2 + " = " + distance(x1, x2, y1, y2));

  }

  public static double distance(int x1, int x2, int y1, int y2) {
    double d = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    return d;
  }
}