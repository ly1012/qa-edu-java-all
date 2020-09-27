package com.liyun.qa.edu.selenium3;

import org.openqa.selenium.WebDriver;

/**
 * 驱动工具类 <br>
 * @date 2020/4/3 16:08
 * @author Li Yun
 */
public class DriverUtil {

  /**
   * 根据窗口标题切换窗口
   * @param driver 驱动
   * @param title 窗口标题
   */
  public static void switchWindow(WebDriver driver, String title){
    String origin = driver.getWindowHandle();
    for (String handle : driver.getWindowHandles()){
      driver.switchTo().window(handle);
      if (driver.getTitle().equals(title)){
        return;
      }
    }
    driver.switchTo().window(origin);
  }

}
