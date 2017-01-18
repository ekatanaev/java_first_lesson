package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by e.katanaev on 18.01.2017.
 */
public class PrimeTests {

  @Test
  public void testPrimes() {
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test
  public void testNonPrimes() {
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }
}
