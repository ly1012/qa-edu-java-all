package com.liyun.qa.edu.appium;

import com.liyun.qa.edu.core.util.Q;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class QuickStart {

  private AndroidDriver driver;

  @BeforeClass
  public void setUp() throws MalformedURLException {
    AppiumDriverLocalService.buildDefaultService().start();

    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("deviceName", "Huawei Honor");
    desiredCapabilities.setCapability("appPackage", "cn.pocketwallet.pocketwallet");
    desiredCapabilities.setCapability("appActivity", ".main.activity.LaunchActivity");
    desiredCapabilities.setCapability("unicodeKeyboard", "true");
    desiredCapabilities.setCapability("resetKeyboard", "true");
    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
  }

  @Test
  public void sampleTest() {
    // 等待启动页加载完毕
    System.out.println("wait 5000 start ...");
    Q.sleep(15000);
    System.out.println("wait 5000 end ...");
    // 滑动跳过引导页
    swipeToLeft(driver);
    swipeToLeft(driver);
    swipeToLeft(driver);
    swipeToLeft(driver);
    // 点击 立即体验
    MobileElement el1 = (MobileElement) driver.findElementById("cn.pocketwallet.pocketwallet:id/app_img_text");
    el1.click();
    //sleep(5000);
    //driver.findElementById("cn.pocketwallet.pocketwallet:id/close").click();
    Q.sleep(8000);
    driver.findElementByXPath("//android.widget.TextView[@text='我的']").click();
    driver.findElementByXPath("//*[@text='登录/注册']").click();
    driver.findElementById("edt_account").sendKeys("18868876139");
    driver.findElementById("cn.pocketwallet.pocketwallet:id/edt_password_or_verification").sendKeys("111111");
    driver.findElementById("cn.pocketwallet.pocketwallet:id/tv_login_or_register").click();

  }

  @AfterClass
  public void tearDown() {
    Q.sleep(2000);
    driver.quit();
  }

  public void swipeToLeft(AndroidDriver driver) {
    //    Duration duration= Duration.ofSeconds(1);
    int width = driver.manage().window().getSize().width;
    int height = driver.manage().window().getSize().height;
    TouchAction action3 = new TouchAction(driver)
            .press(PointOption.point(width * 3 / 4, height / 2)) //.waitAction(WaitOptions.waitOptions(duration))
            .moveTo(PointOption.point(width / 4, height / 2))
            .release();
    action3.perform();
  }


}
