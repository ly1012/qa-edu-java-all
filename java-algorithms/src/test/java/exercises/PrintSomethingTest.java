package exercises;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PrintSomethingTest {

  @Test(description = "打印倒正三角形")
  public void testPrintInvertedTriangle() {
    PrintSomething.printInvertedTriangle(8);
  }

  @Test(description = "打印倒正三角形")
  public void testPrintInvertedTriangle2() {
    PrintSomething.printInvertedTriangle2(8);
  }
}