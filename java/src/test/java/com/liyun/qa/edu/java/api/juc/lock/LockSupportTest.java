package com.liyun.qa.edu.java.api.juc.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * {@link java.util.concurrent.locks.LockSupport}
 *
 * @author Li Yun
 * @date 2020/9/5 17:58
 */
public class LockSupportTest {

  public static class SRThread extends Thread{

    public SRThread(String name){
      super(name);
    }

    @Override
    public void run() {
      synchronized (LockSupportTest.class){
        System.out.println(getName() + " get lock and running...");
        System.out.println(getName() + " is suspended");
        LockSupport.park();
      }
      System.out.println(getName() + " release lock and end");
    }
  }

  public static void main(String[] args) throws InterruptedException {
    SRThread t1 = new SRThread("t1");
    SRThread t2 = new SRThread("t2");
    //启动线程1
    t1.start();
    //等待一段时间，线程1获得锁，线程1被挂起
    Thread.sleep(100);
    //启动线程2，线程2被阻塞，等待锁
    t2.start();
    //线程1恢复执行，释放锁
    LockSupport.unpark(t1);
    LockSupport.unpark(t2);
  }

}
