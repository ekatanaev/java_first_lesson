package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e.katanaev on 18.01.2017.
 */
public class Collections {

  public static void main(String[] args) {
    String[] langs = {"Java", "c#", "Python", "PHP"};

    List<String> Languages = new ArrayList<String>();
    Languages.add("Java");
    Languages.add("C#");
    Languages.add("PHP");

    for (String l : Languages) {
      System.out.println("Я хочу выучить " + l);
    }
  }
}