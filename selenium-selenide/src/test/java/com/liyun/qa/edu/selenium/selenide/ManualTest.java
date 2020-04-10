package com.liyun.qa.edu.selenium.selenide;

import com.codeborne.selenide.WebDriverRunner;
import com.liyun.edu.selenium.DriverPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

/**
 * 手工测试 <br>
 * 创建时间：2020/4/4 10:36<br>
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
    WebDriverRunner.setWebDriver(driver);
    // 自动化操作
    $("#kw").val("Chrome DevTools Protocol");
    $("#su").click();
    // 退出驱动，并不会关闭已存在的浏览器
    WebDriverRunner.closeWebDriver();
  }

}
