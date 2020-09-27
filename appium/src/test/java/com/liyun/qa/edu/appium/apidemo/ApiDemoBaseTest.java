package com.liyun.qa.edu.appium.apidemo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * 测试基类
 *
 * @author Li Yun
 * @date 2020/8/7 16:29
 */
public class ApiDemoBaseTest {

  protected AndroidDriver driver;

  @BeforeClass
  public void beforeClass() throws MalformedURLException {
    //启动 Appium Server，如果已启动则用已存在的
    AppiumDriverLocalService.buildDefaultService().start();

    //设置属性并启动 Session
    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
    driver = new AndroidDriver(remoteUrl, appiumDemoCapabilites());

    //隐式等待
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  private DesiredCapabilities appiumDemoCapabilites(){
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "192.168.182.102:5555");
    capabilities.setCapability("appPackage", "com.example.android.apis");
    capabilities.setCapability("appActivity", ".ApiDemos");
    capabilities.setCapability("noReset", "true");
    return capabilities;
  }

  @AfterClass
  public void afterClass(){
    driver.quit();
  }

}
