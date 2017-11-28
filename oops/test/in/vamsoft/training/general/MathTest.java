package in.vamsoft.training.general;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MathTest {

  private Math math = null;

  @BeforeClass
  public static void beforeClass() {
    System.out.println("MathTest.beforeClass()");
  }

  @AfterClass
  public static void afterClass() {
    System.out.println("MathTest.afterClass()");
  }

  @Before
  public void mathInit() {
    System.out.println("MathTest.mathInit()");
    math = new Math();
  }

  @After
  public void remove() {
    System.out.println("MathTest.remove()");
    math = null;
  }

  @Test
  public void testCase1() {
    System.out.println("MathTest.testCase1()");
    final double result = math.sum(12.0, 23.0);
    final double expected = 35.0;
    Assert.assertEquals(expected, result, 0);
  }

  @Test
  public void testCase2() {
    System.out.println("MathTest.testCase2()");
    final double result = math.sum(0.0, 0.0);
    final double expected = 0.0;
    Assert.assertEquals(expected, result, 0);
  }

  @Test
  public void testCase3() {
    System.out.println("MathTest.testCase3()");
    final double result = math.sum(-76.0, -23.0);
    final double expected = -99.0;
    Assert.assertEquals(expected, result, 0);
  }

  @Test
  public void testCase4() {
    System.out.println("MathTest.testCase4()");
    final int result = math.sum(12, 2);
    final int expected = 14;
    Assert.assertEquals(expected, result);
  }

  @Test
  public void testCase5() {
    System.out.println("MathTest.testCase5()");
    final int result = math.sum(0, 0);
    final int expected = 0;
    Assert.assertEquals(expected, result);
  }

  @Test
  public void testCase6() {
    System.out.println("MathTest.testCase6()");
    final int result = math.sum(-7, -2);
    final int expected = -9;
    Assert.assertEquals(expected, result);
  }
}
