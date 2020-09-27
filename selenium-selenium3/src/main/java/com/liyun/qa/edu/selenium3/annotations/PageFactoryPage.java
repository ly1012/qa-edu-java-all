package com.liyun.qa.edu.selenium3.annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * <p>百度页面</p>
 * <p>每次页面加载或刷新时，PageFactory 都会重新查找</p>
 * @date 2020/4/4 21:59
 * @author Li Yun
 */
public class PageFactoryPage {

  @FindBy(id = "kw")
  public WebElement inb_search;

  @FindBys({
      @FindBy(css = ".lb"),
      @FindBy(css = ".qm-activity")
  })
  public WebElement lnk_login_not_found;

  @FindBys({
      @FindBy(css = ".qm-activity"),
      @FindBy(name = "tj_trnews")
  })
  public WebElement lnk_news;

  @FindAll({
      @FindBy(name = "tj_trnews"),
      @FindBy(name = "tj_login")
  })
  public List<WebElement> links;

  public PageFactoryPage(WebDriver driver){
    PageFactory.initElements(driver, this);
  }

}
