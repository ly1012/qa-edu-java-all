package com.liyun.qa.edu.testng.listener.simple;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 * {@link org.testng.IHookable} 测试
 *
 * 应用场景：
 * 1. 测试方法先决条件判断，符合则运行测试方法，否则不运行
 *
 * @Listeners 作用域：
 * 针对测试套件，如果一个 test 标签下有 @Listeners({SimpleHookable.class})，其他 test 标签也生效。
 *
 * @author Li Yun
 * @date 2020/5/12 18:08
 */
public class SimpleHookable implements IHookable {

  @Override
  public void run(IHookCallBack callBack, ITestResult testResult) {
      System.out.println(Thread.currentThread().getStackTrace()[1]);
      callBack.runTestMethod(testResult);   //@DataProvider 不影响
  }

}
