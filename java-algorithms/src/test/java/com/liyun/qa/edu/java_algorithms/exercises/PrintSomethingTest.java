package com.liyun.qa.edu.java_algorithms.exercises;

import org.testng.annotations.Test;

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