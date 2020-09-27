package com.liyun.qa.edu.testng.listener.simple;

import org.testng.IExecutionListener;

/**
 * {@link org.testng.IExecutionListener} 测试
 *
 * 监控 TestNG 开始运行和结束运行
 *
 * @Listeners 作用域：
 * 针对测试套件，如果一个 test 标签下有 @Listeners({SimpleHookable.class})，其他 test 标签也生效。
 *
 * @author Li Yun
 * @date 2020/5/12 17:46
 */
public class SimpleExecutionListener implements IExecutionListener {

  @Override
  public void onExecutionStart() {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
  }

  @Override
  public void onExecutionFinish() {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
  }
}
