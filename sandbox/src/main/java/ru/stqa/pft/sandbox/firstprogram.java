package ru.stqa.pft.sandbox;

public class FirstProgram {


  public static void main(String[] args) {
    Point p1 = new Point();
    p1.setX(1.5);
    p1.setY(2);

    Point p2 = new Point();
    p2.setX(5);
    p2.setY(7.5);

    double res = distance(p1, p2);

    System.out.println("Results = " + res);

        double res1 = p1.distance1(p2);

    System.out.println("Results from Point class = " + res1);
  }

private static double distance (Point p1, Point p2){
  return Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2));

  }

}