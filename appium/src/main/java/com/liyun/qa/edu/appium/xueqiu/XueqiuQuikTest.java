package com.liyun.qa.edu.appium.xueqiu;

import com.liyun.qa.edu.core.util.Q;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

/**
 * 测试一些 Appium API
 *
 * @author Li Yun
 * @date 2020/8/8 17:13
 */
public class XueqiuQuikTest extends XueqiuBaseTest {

  @Test(description = "覆盖安装测试")
  public void testCoverInstall() {
    System.out.println("App 运行中...");
    Q.sleep(8000);
    System.out.println("App 关闭中...");
    driver.closeApp();
    //driver.removeApp("com.com.liyun.qa.edu.appium.xueqiu.android");   //卸载 APP（用于卸载后再安装测试）
    System.out.println("App 安装中...");
    driver.installApp("E:\\lab\\appium\\apk\\com.com.liyun.qa.edu.appium.xueqiu.android_12.16_275.apk");
    System.out.println("App 启动中...");
    driver.launchApp();
    Q.sleep(8000);
    System.out.println("App 进入后台运行...");
    driver.runAppInBackground(Duration.ofSeconds(6));
    System.out.println("App 后台运行结束！");
  }

  @Test(description = "WebView 测试")
  public void testWebView() {
    printContext();

    //点击底部 “交易”
    driver.findElementByXPath("//*[@text='交易']").click();
    printContext();

    //切换到 WebView
    driver.context("WEBVIEW_com.com.liyun.qa.edu.appium.xueqiu.android");

    //访问网站
    driver.get("https://qadoc.org");
    System.out.println(driver.getPageSource());
  }

  private void printContext(){
    //查看当前上下文
    System.out.println("Current context: " + driver.getContext());
    //查看当前所有的上下文
    for(String s : (Set<String>)driver.getContextHandles()){
      System.out.println("All context: " + s);
    }
  }

  @Test(description = "手势滑动测试")
  public void testSwipe() {
    driver.findElementByAndroidUIAutomator("new UiSelector().text(\"行情\")");
    //driver.findElementByXPath("//*[@text=\"行情\"]").click();
    driver.findElementByXPath("//*[@text=\"市场\"]").click();
    driver.findElementByXPath("//*[@text=\"板块\"]").click();
    driver.findElementByXPath("//*[@text=\"行业板块\"]").click();

    //滑动到列表最底部
    final String[] lastText = {""};
    int width = driver.manage().window().getSize().width;
    int height = driver.manage().window().getSize().height;
    new WebDriverWait(driver, 40).until((ExpectedCondition<Boolean>) driver1 -> {
      WebElement last = driver.findElementByXPath("(//*[@resource-id=\"com.com.liyun.qa.edu.appium.xueqiu.android:id/content_recycler\"]/*)[last()]//android.widget.TextView");
      String text = last.getText();
      //String text = last.getAttribute("text");
      System.out.println("text: " + text);
      if (!text.trim().isEmpty() && lastText[0].equals(text)){
        return true;
      }
      lastText[0] = text;

      System.out.println("swipe...");
      new TouchAction(driver)
          .longPress(PointOption.point(width/2, height*3/4))  //这里必须是 longPress
          .moveTo(PointOption.point(width/2, height/4))
          .release()
          .perform();
      return false;
    });

    driver.findElementByXPath("(//*[@resource-id=\"com.com.liyun.qa.edu.appium.xueqiu.android:id/content_recycler\"]/*)[last()]").click();
    Q.sleep(3000);
  }

  @Test(description = "设备相关功能测试")
  public void testDevices() {
    driver.sendSMS("18868876139", "[淘宝] 验证码：8923");
  }
}
