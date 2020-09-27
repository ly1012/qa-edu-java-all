package com.liyun.qa.edu.java.api.juc.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * {@link java.util.concurrent.CountDownLatch} 倒计时门闩
 *
 * @author Li Yun
 * @date 2020/9/5 10:59
 */
public class CountDownLatchTest implements Runnable{

  static CountDownLatch latch = new CountDownLatch(10);

  @Override
  public void run() {
    //模拟检查任务
    try {
      Thread.sleep((long) (Math.random()*1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    //检查完成
    System.out.format("[%s]check success\n", Thread.currentThread().getId());
    //计数减一
    latch.countDown();
  }

  public static void main(String[] args) throws InterruptedException {
    CountDownLatchTest demo = new CountDownLatchTest();
    ExecutorService executor = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 10; i++) {
      executor.submit(demo);
    }
    //等待所有检查完成
    latch.await();
    //火箭点火
    System.out.println("点火！");
    //关闭线程池
    executor.shutdown();
  }
}
