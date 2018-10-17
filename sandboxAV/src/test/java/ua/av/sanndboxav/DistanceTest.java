package ua.av.sanndboxav;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTest {

  @Test
  public void testDistanceValue() {
    Point p1 = new Point(0, 0);
    Assert.assertEquals(p1.distance(3,4), 5.0);
  }
  @Test
  public void testDistanceZero() {
    Point p1 = new Point(0, 0);
    Assert.assertNotNull(p1.distance(3,4),"Result Null");
  }

}
