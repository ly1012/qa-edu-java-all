package com.liyun.qa.edu.java.api.juc.class_threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * {@link ThreadLocal} 应用场景一：
 * 【内容相同】保存每个线程独享的对象，为每个线程都创建一个副本。
 *
 * 代码出处：https://kaiwu.lagou.com/course/courseInfo.htm?courseId=16#/detail/pc?id=282
 */
public class ThreadLocalTest01 {

  public static ExecutorService threadPool = Executors.newFixedThreadPool(16);

  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 1000; i++) {
      int finalI = i;
      threadPool.submit(new Runnable() {
        @Override
        public void run() {
          String date = new ThreadLocalTest01().date(finalI);
          System.out.println(date);
        }
      });
    }
    threadPool.shutdown();
  }

  public String date(int seconds) {
    Date date = new Date(1000 * seconds);
    SimpleDateFormat dateFormat = ThreadSafeFormatter.dateFormatThreadLocal.get();
    return dateFormat.format(date);
  }
}

class ThreadSafeFormatter {
  public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
    @Override
    protected SimpleDateFormat initialValue() {
      return new SimpleDateFormat("mm:ss");
    }
  };
}

