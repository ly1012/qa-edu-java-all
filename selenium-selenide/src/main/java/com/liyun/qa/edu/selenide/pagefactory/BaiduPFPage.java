package com.liyun.qa.edu.selenide.pagefactory;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.liyun.qa.edu.core.selenium.TestURL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

/**
 * 百度首页（使用 PageFactory） <br>
 * 创建时间：2020/4/4 11:16<br>
 * 作者：李云
 */
public class BaiduPFPage {

  @FindBy(id = "kw") public SelenideElement searchBox;  // 搜索框

  @FindBy(id = "su") public WebElement searchButton;   // 搜索按钮

  public BaiduPFPage(){
    // 不要使用 page(BaiduPFPage.class)，该方法内会通过反射实例化一个 BaiduPFPage 对象，这将引发循环调用
    page(this);
    // 不需要对 WebElement 进行初始化，因为 Selenide 的 page 方法包含了 WebElement 初始化
    // PageFactory.initElements(WebDriverRunner.getWebDriver(), this);
  }

  public BaiduPFPage open(){
    Selenide.open(TestURL.BAI_DU);
    return this;
  }

  public BaiduPFPage search(String keyword){
    searchBox.val(keyword);
    //searchButton.click();
    searchBox.getWrappedElement().click();  // 获取原生 WebElement
    return this;
  }

}
