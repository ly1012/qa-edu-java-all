package com.liyun.qa.edu.listener;

import org.testng.annotations.Test;

/**
 * TODO
 *
 * @author Li Yun
 * @date 2020/5/12 17:10
 */
public class ListenerTest3 {

  public ListenerTest3() {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
  }

  @Test
  public void test3() {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
  }
}
