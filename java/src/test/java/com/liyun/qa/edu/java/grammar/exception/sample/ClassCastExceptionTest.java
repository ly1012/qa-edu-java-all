package com.liyun.qa.edu.java.grammar.exception.sample;

import com.liyun.qa.edu.java.entity.Person;
import org.testng.annotations.Test;

/**
 * {@link java.lang.ClassCastException} 测试
 *
 * @author Li Yun
 * @date 2020/5/7 11:45
 */
public class ClassCastExceptionTest {

  @Test(description = "java.lang.ClassCastException: java.lang.Object cannot be cast to com.liyun.qa.edu.java.entity.Person")
  public void testClassCastException() {
    Person person = (Person) new Object();
  }
}
