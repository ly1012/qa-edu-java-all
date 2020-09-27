package com.liyun.qa.edu.java.api.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * {@link java.util.concurrent.locks.ReentrantLock} 可超时
 *
 * @author Li Yun
 * @date 2020/9/4 22:04
 */
public class ReentrantLockTimeoutTest implements Runnable{

  static ReentrantLock lock = new ReentrantLock();

  @Override
  public void run() {
    try {
      if (lock.tryLock(1, TimeUnit.SECONDS)){
        Thread.sleep(2000);
      }else {
        System.out.println("get lock failed");
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      if (lock.isHeldByCurrentThread()){
        lock.unlock();
      }
    }
  }

  public static void main(String[] args) {
    Thread t1 = new Thread(new ReentrantLockTimeoutTest());
    Thread t2 = new Thread(new ReentrantLockTimeoutTest());
    t1.start();t2.start();
  }
}
