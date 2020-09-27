package com.liyun.qa.edu.appium.apidemo;

import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

/**
 * [ApiDemos-debug.apk](https://github.com/appium/appium/blob/master/sample-code/apps/ApiDemos-debug.apk)
 *
 * @author Li Yun
 * @date 2020/8/9 15:16
 */
public class ApiDemoQuickTest extends ApiDemoBaseTest {

  @Test
  public void testToast() {
    driver.findElementByXPath("//*[@text='Views']").click();
    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Popup Menu\").instance(0));").click();
    driver.findElementByXPath("//*[@text=\"MAKE A POPUP!\"]").click();
    driver.findElementByXPath("//*[@text=\"Search\"]").click();
    MobileElement toast = (MobileElement) driver.findElementByXPath("//*[@class='android.widget.Toast']");
    System.out.println(toast.getText());
  }


}
