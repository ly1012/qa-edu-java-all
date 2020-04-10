package com.liyun.qa.edu.selenium.selenide.pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.liyun.edu.selenium.TestURL;

import static com.codeborne.selenide.Selenide.$;

/**
 * <p>百度页面（不使用 Page Factory）</p>
 * 创建时间：2020/4/4 12:58<br>
 * 作者：李云
 */
public class BaiduPOPage {

  private SelenideElement searchBox = $("#kw");

  private SelenideElement searchButton = $("#su");

  public BaiduPOPage open(){
    Selenide.open(TestURL.BAI_DU);
    // 获取原生 WebDriver 对象（没有意义，这里只为演示）
    System.out.println(WebDriverRunner.getWebDriver().getTitle());
    return this;
  }

  public BaiduPOPage search(String keyword){
    searchBox.val(keyword);
    searchButton.click();
    return this;
  }

}
