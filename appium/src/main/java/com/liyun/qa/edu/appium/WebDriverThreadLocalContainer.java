package com.liyun.qa.edu.appium;

import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Thread.currentThread;

/**
 *
 * @author Li Yun
 * @date 2020/8/13 16:23
 */
public class WebDriverThreadLocalContainer {

  private final Map<Long, WebDriver> threadWebDriver = new ConcurrentHashMap<>(4);

  public void setWebDriver(WebDriver driver){
    long threadId = currentThread().getId();
    threadWebDriver.put(threadId, driver);
  }

  public WebDriver getWebDriver() {
    long threadId = currentThread().getId();
    if (!threadWebDriver.containsKey(threadId)) {
      throw new IllegalStateException("No webdriver is bound to current thread: " + threadId + ". You need to call open(url) first.");
    }
    return threadWebDriver.get(threadId);
  }
}
