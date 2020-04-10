package com.liyun.qa.edu.selenium.selenium3;

import com.liyun.edu.selenium.DriverPath;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

/**
 * 手工测试 <br>
 * 创建时间：2020/4/3 11:39<br>
 * 作者：李云
 */
public class ManualTest {

  @Test(description = "Selenium 连接到已存在的 Chrome 浏览器")
  // 操作已存在的浏览器，默认操作激活页面
  public void testSeleniumConnectToExistedChrome()
  {
    // 手动设置驱动
    System.setProperty("webdriver.chrome.driver", DriverPath.CHROME_80);
    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
    ChromeDriver driver = new ChromeDriver(options);
    // 自动化操作
    driver.findElement(By.id("kw")).clear();
    driver.findElement(By.id("kw")).sendKeys("Chrome DevTools Protocol");
    driver.findElement(By.id("su")).click();
    // 退出驱动，并不会关闭已存在的浏览器
    driver.quit();
  }

}
