package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by jekko on 22.12.2016.
 */
@Test
public class PointTests {

  public void  testDistance() {
    Point p1 = new Point();
    p1.setX(1.5);
    p1.setY(2);

    Point p2 = new Point();
    p2.setX(5);
    p2.setY(7.5);

    Assert.assertEquals(p1.distance1(p2), 6.519202405202649);
  }
}
