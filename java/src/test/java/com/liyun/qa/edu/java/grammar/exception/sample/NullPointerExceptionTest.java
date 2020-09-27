package com.liyun.qa.edu.java.grammar.exception.sample;

import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * {@link java.lang.NullPointerException} 测试
 *
 * @author Li Yun
 * @date 2020/5/7 10:31
 */
public class NullPointerExceptionTest {

  @Test(description = "空指针异常测试：变量为空，调用方法")
  public void testNullPointerException1(){
    String s = null;
    System.out.println(s.length());
  }

  @Test(description = "空指针异常测试：变量为空，访问属性")
  public void testNullPointerException1A(){
    String[] s = null;
    System.out.println(s.length);
  }

  @Test(description = "空指针异常测试：数组元素未初始化")
  public void testNullPointerException2(){
    String[] s = new String[5];
    System.out.println(s[0].length());
  }

  @Test(description = "空指针异常测试：方法传入参数为 null")
  public void testNullPointerException3(){
    nullPointerException3(null);
  }

  private void nullPointerException3(Object o){
    System.out.println(o.hashCode());
  }

  @Test(description = "空指针异常测试：方法返回值为 null")
  public void testNullPointerException4(){
    HashMap<String, String> map = new HashMap();
    map.put("a",null);
    System.out.println(map.get("a").length());
  }

}
