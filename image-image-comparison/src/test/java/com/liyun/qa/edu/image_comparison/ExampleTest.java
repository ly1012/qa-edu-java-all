package com.liyun.qa.edu.image_comparison;

import com.liyun.qa.edu.image_comparison.Example;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExampleTest {

  @Test
  public void testCompareImage() throws IOException {
    //Example.compareImage("official/actual.png","official/expected.png","output/official/result.png");
    Example.compareImage("puppeteer/actual.png","puppeteer/expected.png","output/puppeteer/result.png");
  }

}