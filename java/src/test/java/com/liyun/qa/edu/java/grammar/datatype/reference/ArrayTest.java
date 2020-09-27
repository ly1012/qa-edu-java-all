package com.liyun.qa.edu.java.grammar.datatype.reference;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 数组测试
 *
 * @author Li Yun
 * @date 2020/8/12 21:33
 */
public class ArrayTest {

  @Test(description = "Java 中数组下标从 0 开始，不支持反向访问",
      expectedExceptions = ArrayIndexOutOfBoundsException.class)
  public void testVisit() {
    char[] chars = new char[]{'a', 'b', 'c', 'd'};
    assertThat(chars[-1]).isEqualTo('d');
  }
}
