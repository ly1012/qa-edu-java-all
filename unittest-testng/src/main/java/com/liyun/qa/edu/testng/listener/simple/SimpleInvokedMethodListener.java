package com.liyun.qa.edu.testng.listener.simple;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * {@link org.testng.IInvokedMethodListener} 测试
 *
 * 方法调用监听器：仅监听配置和测试方法
 *
 * @Listeners 作用域：
 * 针对测试套件，如果一个 test 标签下有 @Listeners({SimpleInvokedMethodListener.class})，其他 test 标签也生效。
 *
 * @author Li Yun
 * @date 2020/5/12 17:40
 */
public class SimpleInvokedMethodListener implements IInvokedMethodListener {

  @Override
  public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    System.out.println(
        Thread.currentThread().getStackTrace()[1] +
        "监听方法：" + method
    );
  }

  @Override
  public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    System.out.println(
        Thread.currentThread().getStackTrace()[1] +
            "监听方法：" + method
    );
  }
}
