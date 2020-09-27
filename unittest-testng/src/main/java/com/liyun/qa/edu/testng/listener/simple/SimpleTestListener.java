package com.liyun.qa.edu.testng.listener.simple;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * {@link org.testng.ITestListener} 测试
 *
 * 监听 @Test 方法：onTestStart、onTestSuccess、onTestFailure、onTestSkipped、onTestFailedButWithinSuccessPercentage
 * 监听 XML test 标签：onStart、onFinish
 *
 * @Listeners 作用域：
 * 针对 test 标签，如果一个 test 标签下有 @Listeners({SimpleTestListener.class})，其他没有该注解的 test 标签不会生效。
 *
 * @author Li Yun
 * @date 2020/5/9 9:03
 */
public class SimpleTestListener implements ITestListener {


  @Override
  public void onTestStart(ITestResult result) {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
  }

  @Override
  public void onTestFailure(ITestResult result) {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
  }

  /**
   * 运行时机：针对 XML test 标签（两个 test 标签会运行两次），test 标签下所有类实例化之后，test 标签下任何配置的方法运行前
   *
   * 测试用例：
   *
   * 1. 将 testListener.xml 中所有 class 标签注释掉。输出：
   * com.liyun.qa.edu.com.liyun.qa.edu.testng.listener.simple.SimpleTestListener.onStart(SimpleTestListener.java:45)
   * com.liyun.qa.edu.com.liyun.qa.edu.testng.listener.simple.SimpleTestListener.onFinish(SimpleTestListener.java:50)
   * com.liyun.qa.edu.com.liyun.qa.edu.testng.listener.simple.SimpleTestListener.onStart(SimpleTestListener.java:45)
   * com.liyun.qa.edu.com.liyun.qa.edu.testng.listener.simple.SimpleTestListener.onFinish(SimpleTestListener.java:50)
   *
   * 2. 直接运行 testListener.xml 观察顺序（输出较多）
   *
   * @param context
   */
  @Override
  public void onStart(ITestContext context) {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
  }

  /**
   * 运行时机：针对 XML test 标签（两个 test 标签会运行两次），test 标签下所有测试方法和配置方法运行之后
   *
   * @param context
   */
  @Override
  public void onFinish(ITestContext context) {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
  }
}
