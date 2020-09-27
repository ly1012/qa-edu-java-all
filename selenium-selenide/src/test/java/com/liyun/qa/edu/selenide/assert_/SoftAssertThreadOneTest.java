package com.liyun.qa.edu.selenide.assert_;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.SoftAsserts;
import com.liyun.qa.edu.core.selenium.TestURL;
import com.liyun.qa.edu.selenide.ThreadTool;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * 多线程下，软断言测试
 * @author Li Yun
 * @date 2020/4/5 15:34
 */
@Listeners({SoftAsserts.class})
public class SoftAssertThreadOneTest {

  @BeforeClass
  public void beforeClass(){
    Configuration.headless = true;
    Configuration.timeout = 500;
    Configuration.assertionMode = SOFT;
    open(TestURL.THE_INTERNET);
    Selenide.sleep(2000); //为了保证 ThreadOne 先运行，且 ThreadTwo 测试方法运行时断言模式已经设置为软断言
    ThreadTool.notifyLoaded();
  }

  @Test(description = "线程1：测试软断言")
  public void testSoftAssert() {
    $(By.linkText("Dropdown")).should(visible);
    $("#not_found").should(visible);  // error
    System.out.println("我是软断言，会执行到这里");
    $("#not_found2").should(visible);  // error
  }


}
