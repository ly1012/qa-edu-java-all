package com.liyun.qa.edu.selenium.selenium3;

import com.liyun.edu.selenium.DriverPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * 测试基类 <br>
 * 创建时间：2020/4/4 22:22<br>
 * 作者：李云
 */
public class BaseTest {

  protected WebDriver driver;

  @BeforeSuite
  public void beforeSuite(){
    System.setProperty("webdriver.chrome.driver", DriverPath.CHROME_80);
    driver = new ChromeDriver();
  }

  @AfterSuite
  public void afterSuite(){
    driver.quit();
  }

}
