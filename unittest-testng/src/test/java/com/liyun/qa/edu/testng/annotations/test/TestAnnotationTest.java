package com.liyun.qa.edu.testng.annotations.test;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Test 部分属性测试
 *
 * @author Li Yun
 * @date 2020/9/16 17:50
 */
public class TestAnnotationTest {

  private static int num;

  @Test(description = "调用次数测试", invocationCount=6)
  public void testInvocationCount(){
    num++;
    if(num == 3){         // 第三次断言失败
      Assert.fail(""+num);
    }
    System.out.println(num+"\ttst");
  }


}
