package com.liyun.qa.edu.selenium.selenium3.annotations;

import com.liyun.edu.selenium.TestURL;
import com.liyun.qa.edu.selenium.selenium3.BaseTest;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class PageFactoryPageTest extends BaseTest {

  PageFactoryPage pageFactoryPage;

  @BeforeClass
  public void beforeClass(){
    pageFactoryPage = new PageFactoryPage(driver);
    driver.get(TestURL.BAI_DU);
  }

  @Test(description = "测试 @FindBys 注解，预期抛出异常", expectedExceptions = NotFoundException.class)
  public void testFindBysExpectNotFound() {
    pageFactoryPage.lnk_login_not_found.click();
  }

  @Test(description = "测试 @FindBys 注解")
  public void testFindBys(){
    pageFactoryPage.lnk_news.click();
  }

  @Test(description = "测试 @FindAll 注解")
  public void testFindAll(){
    List<WebElement> links = pageFactoryPage.links;
    for (WebElement e : links) {
      System.out.println(e.getText());
    }
    Assert.assertEquals(pageFactoryPage.links.size(), 3);
  }

}