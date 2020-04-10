package com.liyun.qa.edu.selenium.selenide.assert_;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import com.liyun.edu.selenium.TestURL;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.AssertionMode.STRICT;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * 软断言测试
 * @author Li Yun
 * @date 2020/4/5 12:58
 */
@Listeners({ SoftAsserts.class})
public class SoftAssertTest {

  @BeforeClass
  public void beforeClass(){
    Configuration.headless = true;
    Configuration.timeout = 500;
    open(TestURL.THE_INTERNET);
  }

  @Test
  public void testNormal() {
    $(By.linkText("Dropdown")).should(visible);
    $("#not_found").should(visible);  // error
    System.out.println("我是硬断言，不会执行到这里");
    $("#not_found2").should(visible);  // error
  }

  @Test(description = "测试软断言")
  public void testSoftAssert() {
    Configuration.assertionMode = SOFT;
    $(By.linkText("Dropdown")).should(visible);
    $("#not_found").should(visible);  // error
    $(By.linkText("Frames")).should(visible);
    $("#not_found2").should(visible);  // error
    // 断言设置是全局的，默认是硬断言，当前测试方法应当将断言设置还原为默认值。
    Configuration.assertionMode = STRICT;
  }

  @Test
  public void testZNormal() {
    $(By.linkText("Dropdown")).should(visible);
    $("#not_found").should(visible);  // error
    System.out.println("我是硬断言，不会执行到这里");
    $("#not_found2").should(visible);  // error
  }

}
