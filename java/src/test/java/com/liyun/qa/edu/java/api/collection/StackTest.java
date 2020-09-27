package com.liyun.qa.edu.java.api.collection;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Stack;

/**
 * 栈测试
 *
 * @author Li Yun
 * @date 2020/8/17 18:40
 */
public class StackTest {

  @Test(description = "peek 取出栈顶元素但不从栈中移除")
  public void test_peek() {
    Stack<String> stack = new Stack<>();
    stack.push("a");
    stack.push("b");
    stack.push("c");
    Assertions.assertThat(stack.peek()).isEqualTo("c");
    Assertions.assertThat(stack.pop()).isEqualTo("c");
  }


}
