package ua.av.sanndboxav;

public class Distance {
  int x1;
  int y1;
  int x2;
  int y2;

  public Distance (int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    p1 = "(" + this.x1 + "," + this.y1 + ")";
    p2 = "(" + this.x2 + "," + this.y2 + ")";
  }

  public double distance () {
    double d = Math.sqrt((this.x2-this.x1)*(this.x2-this.x1)+(this.y2-this.y1)*(this.y2-this.y1));
    return d;
  }

  String p1;
  String p2;
}
