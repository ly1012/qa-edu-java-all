package com.liyun.qa.edu.appium.browser;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
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
public class BrowserBaseTest {

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
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.182.102:5555");
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

    //驱动版本和浏览器版本映射文件
    //capabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_CHROME_MAPPING_FILE, "E:\\lab\\selenium\\driver\\chrome-mapping.json");

    //手动指定驱动文件路径
    capabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "E:\\lab\\selenium\\driver\\chrome\\chromedriver_72.0.3626.69.exe");

    //自动扫描存放驱动文件的文件夹
    //默认映射文件：https://raw.githubusercontent.com/appium/appium-chromedriver/master/config/mapping.json
    //capabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE_DIR, "E:\\lab\\selenium\\driver\\chrome");

    //如果要开启 appium 的自动发现，使用命令 appium --allow-insecure chromedriver_autodownload 启动 appium

    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
    capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
    return capabilities;
  }

  @AfterClass
  public void afterClass(){
    driver.quit();
  }

}
