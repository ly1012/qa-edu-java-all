package com.liyun.qa.edu.selenide.assert_;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import com.liyun.qa.edu.core.selenium.TestURL;
import com.liyun.qa.edu.selenide.ThreadTool;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * 多线程下，软断言测试
 * @author Li Yun
 * @date 2020/4/5 15:34
 */
@Listeners({SoftAsserts.class})
public class SoftAssertThreadTwoTest {

  @BeforeClass
  public void beforeClass(){
    Configuration.headless = true;
    Configuration.timeout = 500;
    open(TestURL.THE_INTERNET);
    ThreadTool.waitUntilLoaded();
  }

  @Test(description = "线程2：测试软断言")
  public void testSoftAssert() {
    $(By.linkText("Dropdown")).should(visible);
    $("#not_found").should(visible);  // error
    System.out.println("我是被 ThreadOne 设置为了软断言，所以我也会执行到这里");
    $("#not_found2").should(visible);  // error
  }

}
