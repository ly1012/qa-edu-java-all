package com.liyun.qa.edu.java.api.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * {@link ReentrantLock} 可重入：重入多次
 *
 * @author Li Yun
 * @date 2020/9/4 9:58
 */
public class ReentrantLockMultiTest implements Runnable{

  public static ReentrantLock lock = new ReentrantLock();
  public static int i = 0;

  @Override
  public void run() {
    for (int j = 0; j < 100000; j++) {
      lock.lock();
      lock.lock();
      try {
        i++;
      }finally {
        lock.unlock();
        lock.unlock();
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    ReentrantLockMultiTest obj = new ReentrantLockMultiTest();
    Thread t1 = new Thread(obj);
    Thread t2 = new Thread(obj);
    t1.start();t2.start();
    t1.join();t2.join();

    System.out.println(i);
  }
}
