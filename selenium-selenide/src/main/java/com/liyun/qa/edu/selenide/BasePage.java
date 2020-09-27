package com.liyun.qa.edu.selenide;

import org.openqa.selenium.WebDriver;

/**
 * 页面基类 <br>
 * 创建时间：2020/4/4 13:53<br>
 * 作者：李云
 */
public class BasePage {

  private WebDriver webDriver;

  public BasePage() {
  }

  public BasePage(WebDriver webDriver){
    this.webDriver = webDriver;
  }

}
