package com.liyun.qa.edu.selenium.selenide;

import com.codeborne.selenide.Configuration;
import com.liyun.edu.selenium.DriverPath;
import com.liyun.edu.selenium.TestURL;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * 快速开始 <br>
 * 创建时间：2020/4/3 17:04<br>
 * 作者：李云
 */
public class QuickStart {

  @BeforeClass
  public void beforeClass(){
    // 默认使用 chrome
    Configuration.browser="chrome";
    // 设置 chrome driver 路径，如果不设置，selenide 将自动从官网下载并缓存到本地
    System.setProperty("webdriver.chrome.driver", DriverPath.CHROME_80);
  }

  @Test(enabled = true)
  public void userCanLoginByUsername() {
    // 启动浏览器，并访问百度
    open(TestURL.BAI_DU);
    // 搜索框输入“selenide”
    $(By.id("kw")).setValue("selenide");
    // 点击 “百度一下”
    $("#su").click();
    // 等待搜索结果出现
    $(".result.c-container").should(appear); // Waits until element appears
    // 断言右侧的百度热榜区域，包含字符串“百度热榜”
    $("#con-ar").shouldHave(text("百度热榜")); // Waits until element gets text
  }

}
