package com.liyun.qa.edu.java.grammar.oop;

import com.liyun.qa.edu.java.grammar.oop.xextends.Parent;
import com.liyun.qa.edu.java.grammar.oop.xextends.Son;
import org.testng.annotations.Test;

/**
 * 继承测试
 *
 * @author Li Yun
 * @date 2020/8/7 11:51
 */
public class ExtendTest {

  @Test(description = "this 关键字指向当前对象")
  public void testThis() {
    Son son = new Son();
    Parent son2 = new Son();
  }

  @Test
  public void testOverride() {
    Parent son = new Son();
    son.eat();                  //调用的父类方法
  }
}
