package com.liyun.qa.edu.listener;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * TODO
 *
 * @author Li Yun
 * @date 2020/5/12 17:10
 */
public class ListenerTest4 {

  public ListenerTest4() {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
  }

  @Test(dataProvider = "dataprovider")
  public void test4(String upper, String lower) {
    System.out.println(Thread.currentThread().getStackTrace()[1] + upper + lower);
  }

  @DataProvider(name = "dataprovider")
  public Object[][] dataprovider(){
    return new String[][]{
        {"A","a"},
        {"B","b"}
    };
  }

}
