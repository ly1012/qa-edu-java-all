package com.liyun.qa.edu;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 快速开始
 *
 * @author Li Yun
 * @date 2020/4/9 15:15
 */
public class QuickStart {

  @Test(description = "常见的断言示例")
  public void testStart() {
    //简单断言
    //assertThat(a, equalTo(b)); //Hamcrest
    assertThat(3).isEqualTo(3); //AssertJ

    //简单断言
    assertThat("abc").contains("c");

    //日期断言
    //assertThat(tomorrow, isAfter(today)); //Hamcrest
    Date date = new Date();
    assertThat(date).isAfterOrEqualsTo(date); //AssertJ

    //列表断言
    List<String> list = Arrays.asList("a","c");
    //assertThat(list, Matchers.<Collection<String>> allOf(CoreMatchers.hasItem("a"),
    //    CoreMatchers.not(CoreMatchers.hasItem("b"))
    //)); //Hamcrest
    assertThat(list).contains("a").doesNotContain("b"); //AssertJ

    //null 断言
    //assertThat(a, nullValue()); //Hamcrest
    Object nullValue = null;
    assertThat(nullValue).isNull();  //AssertJ

    //使用自定义消息
    //assertThat("Error", a, equalTo(b)); //Hamcrest
    int actual = 5;
    int expected = 6;
    assertThat(actual)
        .overridingErrorMessage("%s 应该等于 %s", actual, expected)
        .isEqualTo(expected); //AssertJ
  }


  @Test(description = "Assertj 软断言")
  public void testSoftAssertion(){
    User user = new User("Yuri", "Bushnev", "bushnevyuri@gmail.com");
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(user).isNotNull();
    softly.assertThat(user.getName()).isEqualTo("Yuri");
    softly.assertThat(user.getSurename()).isEqualTo("Bush");
    softly.assertThat(user.getEmail()).isEqualTo("bushnevyurigmail.com");
    softly.assertAll();
  }

  class User{

    private String name;
    private String surename;
    private String email;

    public User(String name, String surename, String email){
      this.name = name;
      this.surename = surename;
      this.email = email;
    }

    public String getName() {
      return name;
    }

    public String getSurename() {
      return surename;
    }

    public String getEmail() {
      return email;
    }
  }

}
