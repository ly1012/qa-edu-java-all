package com.liyun.qa.edu.java.grammar.datatype.reference;

import org.testng.annotations.Test;

/**
 * 包装类调用重载方法测试
 *
 * @author Li Yun
 * @date 2020/6/3 20:54
 */
public class IntegerOverloadTest {

  @Test
  public void testOverload() {
    print(1);
    print(Integer.valueOf(1));
  }

  public void print(int i){
    System.out.println("基本数据类型");
  }

  public void print(Integer i){
    System.out.println("包装类");
  }

}
