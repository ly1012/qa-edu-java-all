package com.liyun.qa.edu.allure;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Li Yun
 * @date 2020/6/22 20:33
 */
@Epic("Allure examples")
@Feature("TestNG support")
public class Allure2Test {

  @BeforeMethod(description = "Configure something before test 2")
  public void setUp() {
    //...
  }

  @Test(description = "Human-readable test name 2")
  @Story("Base support for bdd annotations 2")
  @Story("Advanced support for bdd annotations 2")
  public void testSomething() throws Exception {
    //...
  }


  @Test
  @Description("Some detailed test description 2")
  public void testLogin() {
    loginWith("tom", "tompwd");
  }

  @Step("Type2 {username} / {password}.")
  public void loginWith(String username, String password) {
     //...
  }

}
