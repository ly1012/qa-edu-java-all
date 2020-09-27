package com.liyun.qa.edu.appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Demo 应用测试
 *
 * @author Li Yun
 * @date 2020/8/4 10:28
 */
public class DemoTest {

  private AndroidDriver driver;

  @BeforeClass
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("deviceName", "华为畅享");
    desiredCapabilities.setCapability("appPackage", "com.liyun.android.demo");
    desiredCapabilities.setCapability("appActivity", ".activity.ReceiveActivity");
    desiredCapabilities.setCapability("unicodeKeyboard", "true");
    desiredCapabilities.setCapability("resetKeyboard", "true");

    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
  }

}
