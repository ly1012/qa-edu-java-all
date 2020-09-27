package com.liyun.qa.edu.java.api.juc.class_thread;

import org.testng.annotations.Test;

/**
 * {@link java.lang.Thread} 测试
 *
 * @author Li Yun
 * @date 2020/5/12 16:28
 */
public class ThreadBaseCaseTest {

  @Test(description = "测试 Thread.currentThread().getStackTrace() 方法")
  public void test_getStackTrace() {
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    //堆栈信息：从下往上调用
    System.out.println(stackTraceElements[0]);  //output: java.lang.Thread.getStackTrace(Thread.java:1559)
    //当前方法：test_getStackTrace
    System.out.println(stackTraceElements[1]);  //output: com.liyun.qa.edu.java.api.com.liyun.qa.edu.java.juc.class_thread.ThreadTest.test_getStackTrace(ThreadTest.java:15)
  }

  public static void main(String[] args) {

    long start = System.currentTimeMillis();

    new Thread(() -> {
      System.out.println("子线程开始");
      try {
        // 子线程休眠五秒
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("子线程结束");
    }).start();

    long end = System.currentTimeMillis();
    System.out.println("主线程执行时长：" + (end - start));
  }
}
