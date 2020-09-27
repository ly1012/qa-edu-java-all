package com.liyun.qa.edu.java.api.juc.lock.helper;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * 死锁处理
 *
 * @author Li Yun
 * @date 2020/9/4 18:50
 */
public class DeadLockManager {

  public static void interrupt(){
    Thread t = new Thread(() -> {
      ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
      while (true){
        //检查是否有死锁，如果有则终端
        long[] deadLockIds = mxBean.findDeadlockedThreads();
        if (deadLockIds != null){
            for (Thread thread : Thread.getAllStackTraces().keySet()){
              for (long id : deadLockIds) {
                if (thread.getId() == id){
                  thread.interrupt();
                }
              }
            }
        }
        //等待 5 秒后再次检查
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    t.setDaemon(true);
    t.start();
  }

}
