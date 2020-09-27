package com.liyun.qa.edu.appium.browser;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * 百度网站测试
 *
 * @author Li Yun
 * @date 2020/8/9 16:44
 */
public class BaiduPageTest extends BrowserBaseTest{

  @Test(description = "Android 上 Chrome 浏览器测试")
  public void testSearch() {
    //查看当前上下文
    System.out.println("Current context: " + driver.getContext());

    //访问百度
    driver.get("https://www.baidu.com");

    //查看当前所有的上下文
    for(String s : (Set<String>)driver.getContextHandles()){
      System.out.println("所有 context: " + s);
    }

    //关闭原生的弹窗，切换到原生的上下文
    driver.context("NATIVE_APP");
    System.out.println("Current context: " + driver.getContext());
    //操作原生的元素，这里是关闭百度网站的弹窗
    driver.findElementByXPath("//*[@text='BLOCK']").click();
    //driver.findElementByAndroidUIAutomator("new UiSelector().text(\"BLOCK\")").click();
    //切换回浏览器上下文
    driver.context("CHROMIUM");
    System.out.println("Current context: " + driver.getContext());

    //一开始元素找不到，后来发现百度网页，电脑上和手机上的首页搜索框 ID 不一样
    //总结：手机浏览器上元素定位时，电脑上的 devtools 切换成模拟手机模式去查看页面结构
    //以下是排查问题时常见的输出
    WebElement e = driver.findElementById("index-kw");
    System.out.println(e.getTagName());                       //查看元素标签，看是不是对的
    System.out.println(e.getText());                          //查看元素内容中是否包含预期的信息
    System.out.println(e.getLocation());                      //查看元素位置，大致判断是不是找错了
    System.out.println(e.getAttribute("innerHTML"));   //查看元素内部的 HTML 内容

    //使用关键字搜索
    driver.findElementById("index-kw").sendKeys("Appium");
    driver.findElementById("index-bn").click();
    String s = driver.findElementByCssSelector("div.c-result.result").getAttribute("innerHTML");
    System.out.println(s);
  }
}
