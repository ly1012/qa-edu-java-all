package com.liyun.qa.edu.java.grammar.generic;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * 泛型继承测试
 *
 * @author Li Yun
 * @date 2020/8/8 10:01
 */
public class GenericExtendsTest {

  @Test
  public void testExtends() {
    Integer i = new C3().apply("100");
    Assertions.assertThat(i).isEqualTo(100);
  }
}

@FunctionalInterface
interface C1<T1,T2> {

  T2 apply(T1 t1);

}

interface C2<T2> extends C1<String, T2> {
  default Boolean get(String s){
    return Boolean.TRUE;
  }
}

class C3 implements C2<Number> {

  @Override
  public Integer apply(String s) {
    get(s);
    return Integer.valueOf(s);
  }

}