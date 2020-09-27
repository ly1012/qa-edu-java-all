package com.liyun.qa.edu.selenide;

import com.codeborne.selenide.Selenide;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程测试辅助类
 * @author Li Yun
 * @date 2020/4/5 15:59
 */
public class ThreadTool {

  static ReentrantLock lockWait = new ReentrantLock();
  static ReentrantLock lockNotify = new ReentrantLock();

  private static boolean isLoaded = false;

  public static void notifyLoaded(){
    lockNotify.lock();
    try{
      isLoaded = true;
    }finally {
      lockNotify.unlock();
    }
  }

  public static void waitUntilLoaded(){
    lockWait.lock();
    try{
      while (!isLoaded){
        Selenide.sleep(100);
      }
    }finally {
      lockWait.unlock();
    }
  }

}
