package ua.av.sanndboxav;

public class Point {
  int x1;
  int y1;

  public Point (int x1, int y1) {
    this.x1 = x1;
    this.y1 = y1;
  }
  public double distance (int a, int b) {
    double d = Math.sqrt((this.x1-a)*(this.x1-a)+(this.y1-b)*(this.y1-b));
    return d;
  }


}
