package com.liyun.qa.edu.appium;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author Li Yun
 * @date 2020/8/13 16:21
 */
public class WebDriverRunner {

  public static WebDriverThreadLocalContainer webdriverContainer = new WebDriverThreadLocalContainer();

  public static void setWebDriver(WebDriver webDriver) {
    webdriverContainer.setWebDriver(webDriver);
  }

  public static WebDriver getWebDriver() {
    return webdriverContainer.getWebDriver();
  }

}
