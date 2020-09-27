package com.liyun.qa.edu.java.api.collection;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link java.util.HashMap} 测试
 *
 * @author Li Yun
 * @date 2020/5/24 20:14
 */
public class HashMapTest {

  @Test(description = "K/V 都必须是引用类型，因为泛型擦除时，都必须是 Object 或其子类")
  public void testType() {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);
    map.put(new Integer(1), new Integer(1));
    System.out.println(map);
  }

  @Test(description = "返回集合所有值的预览")
  public void testValues() {
    Map<String,String> map = new HashMap<>();
    map.put("a","一");
    map.put("b","二");
    System.out.println(map.values());
  }

  @Test(description = "测试 key")
  public void testKey() {
    HashMap<Object, String> map = new HashMap<>();
    Object o = new Object();
    map.put(o, "a");
    o = null;
    System.out.println(map);
  }

  @Test
  public void testName() {
    Object a = new Object();
    Object b = a;
    a = null;
    System.out.println(a);
    System.out.println(b);
  }
}
