package com.liyun.qa.edu.appium.xueqiu;

import com.liyun.qa.edu.appium.WebDriverRunner;
import com.liyun.qa.edu.appium.YamlReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
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
public class XueqiuBaseTest {

  protected AndroidDriver driver;
  protected YamlReader.Account account = YamlReader.getAccount("com/liyun/qa/edu/appium/xueqiu");

  @BeforeClass
  public void beforeClass() throws MalformedURLException {
    //启动 Appium Server，如果已启动则用已存在的
    AppiumDriverLocalService.buildDefaultService().start();

    //设置属性并启动 Session
    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
    driver = new AndroidDriver(remoteUrl, xueqiuCapabilites());

    //隐式等待
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebDriverRunner.setWebDriver(driver);
  }

  private DesiredCapabilities xueqiuCapabilites(){
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "192.168.182.102:5555");
    capabilities.setCapability("appPackage", "com.com.liyun.qa.edu.appium.xueqiu.android");
    capabilities.setCapability("appActivity", ".common.splash.SplashActivity");
    capabilities.setCapability("noReset", "true");

    //手动指定驱动文件夹路径
    //Appium 扫描不到，提示：[Chromedriver] Unable to discover Chrome version.
    //capabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE_DIR, "E:\\lab\\selenium\\driver\\chrome");
    //驱动版本和浏览器版本映射文件
    //capabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_CHROME_MAPPING_FILE, "E:\\lab\\selenium\\driver\\chrome-mapping.json");

    //手动指定驱动文件路径
    capabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "E:\\lab\\selenium\\driver\\chrome\\chromedriver_74.0.3729.6.exe");

    return capabilities;
  }

  @AfterClass
  public void afterClass(){
    driver.closeApp();
    driver.quit();
  }

}
