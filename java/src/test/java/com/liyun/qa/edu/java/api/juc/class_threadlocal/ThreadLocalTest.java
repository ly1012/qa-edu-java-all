package com.liyun.qa.edu.java.api.juc.class_threadlocal;

import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * {@link ThreadLocal}
 *
 * @author Li Yun
 * @date 2020/9/8 23:12
 */
public class ThreadLocalTest {

  //static ThreadLocal<BigObject> tl = ThreadLocal.withInitial(() -> new BigObject());
  static ThreadLocal<BigObject> tl = new ThreadLocal<>();

  static class BigObject {
    //10M
    public byte[] l = new byte[10 * 1024 * 1024];
  }

  @Test(description = "测试内存泄露，50 * 10M ≈ 1G")
  public void testMemoryLeak() throws InterruptedException {
    int nThreads = 50;
    //开启 50 个核心线程
    ExecutorService pool = Executors.newFixedThreadPool(nThreads);
    for (int i = 0; i < nThreads; i++) {
      //每个线程都创建一个引用链：Thread -> ThreadLocalMap -> Entry -> value(BigObject 对象)
      pool.execute(() -> {
        //创建 BigObject 对象，形成引用链
        tl.set(new BigObject());

        //回收 tl 对象，但还是会导致内存泄露，因为满足下面两个条件：
        //1. 线程一直是活的。
        //2. 引用链一直存在，value 无法回收，但 value 已经无用。
        //等待所有线程都创建完引用链再设置为 null，防止下一个线程的 tl NPE
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        tl = null;

        //set(null) 仍然可能导致内存泄露，因为 Entry 没有被删除，只删除了 Entry.value
        //tl.set(null);

        //正确的释放资源，删除 Entry 及 Entry.value
        //tl.remove();
      });
    }
    //阻止 test 方法结束（main 方法中运行不会结束，可以运行下面的 main 方法试试）
    pool.awaitTermination(1, TimeUnit.HOURS);
  }

  public static void main(String[] args) {
    //开启 50 个核心线程
    ExecutorService pool = Executors.newFixedThreadPool(50);
    for (int i = 0; i < 50; i++) {
      //每个线程都创建一个引用链：Thread -> ThreadLocalMap -> Entry -> value(BigObject 对象)
      pool.execute(() -> {
        tl.get();
      });
    }
  }

}

