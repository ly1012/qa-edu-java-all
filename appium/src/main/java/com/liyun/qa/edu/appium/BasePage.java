package com.liyun.qa.edu.appium;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * 页面基类
 *
 * @author Li Yun
 * @date 2020/8/7 12:23
 */
public class BasePage {

  protected WebDriver driver;

  public BasePage(){
    this.driver = WebDriverRunner.getWebDriver();
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }


}
