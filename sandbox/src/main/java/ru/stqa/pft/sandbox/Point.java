package ru.stqa.pft.sandbox;

/**
 * Created by jekko on 18.12.2016.
 */
public class Point {
  double x;
  double y;

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double distance1 (Point p2){
    return Math.sqrt(Math.pow((p2.getX() - this.getX()), 2) + Math.pow((p2.getY() - this.getY()), 2));
  }
}