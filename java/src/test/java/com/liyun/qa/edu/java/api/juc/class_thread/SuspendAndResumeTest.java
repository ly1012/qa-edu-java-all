package com.liyun.qa.edu.java.api.juc.class_thread;

/**
 * suspend 和 resume 方法测试
 *
 * 【注】suspend 和 resume 方法已过时，有死锁隐患
 *
 * @author Li Yun
 * @date 2020/8/29 11:40
 */
@Deprecated
public class SuspendAndResumeTest {

  public static class SRThread extends Thread{

    public SRThread(String name){
      super(name);
    }

    @Override
    public void run() {
      synchronized (SuspendAndResumeTest.class){
        System.out.println(getName() + " get lock and running...");
        System.out.println(getName() + " is suspended");
        Thread.currentThread().suspend();
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
    t1.resume();
/*    //分支1：
      //线程2获得锁，并被挂起
      Thread.sleep(100);
      //线程2恢复执行，程序结束
      t2.resume();*/
    //分支2：
      //线程2在 suspend 前 resume，线程2一直被挂起导致死锁
      t2.resume();
  }

}
