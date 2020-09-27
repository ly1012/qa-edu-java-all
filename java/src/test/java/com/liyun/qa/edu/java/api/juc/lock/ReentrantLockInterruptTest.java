package com.liyun.qa.edu.java.api.juc.lock;

import com.liyun.qa.edu.java.api.juc.lock.helper.DeadLockManager;

import java.util.concurrent.locks.ReentrantLock;

/**
 * {@link java.util.concurrent.locks.ReentrantLock} 可中断：lockInterruptibly()
 *
 * @author Li Yun
 * @date 2020/9/4 18:32
 */
public class ReentrantLockInterruptTest implements Runnable{

  public static ReentrantLock lock1 = new ReentrantLock();
  public static ReentrantLock lock2 = new ReentrantLock();
  int no;

  //给线程指定编号，方便构造死锁
  public ReentrantLockInterruptTest(int no){
    this.no = no;
  }

  @Override
  public void run() {
      try{
        if (no == 1){                               //第一个线程获得锁1，等待锁2
          lock1.lockInterruptibly();
          try {                                     //等待线程2先获得锁2
            Thread.sleep(300);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          lock2.lockInterruptibly();
        }else {                                     //第二个线程获得锁2，等待锁1，形成死锁
          lock2.lockInterruptibly();
          try {                                     //等待线程1先获得锁1
            Thread.sleep(300);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          lock1.lockInterruptibly();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        if (lock1.isHeldByCurrentThread()){
          lock1.unlock();
        }
        if (lock2.isHeldByCurrentThread()){
          lock2.unlock();
        }
      }
  }

  public static void main(String[] args) {
    Thread t1 = new Thread(new ReentrantLockInterruptTest(1));
    Thread t2 = new Thread(new ReentrantLockInterruptTest(2));
    t1.start();t2.start();

    //中断线程，解开死锁
    DeadLockManager.interrupt();

  }
}
