package com.liyun.qa.edu.appium.xueqiu;

import com.liyun.qa.edu.appium.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * 主页面（底部选项卡）
 *
 * @author Li Yun
 * @date 2020/8/7 10:57
 */
public class MainPage extends BasePage {


  @AndroidFindBy(xpath = "//android.widget.TabWidget//android.widget.TextView[@text=\"我的\"]/..")
  MobileElement mine;


  public MinePage goMinePage(){
    mine.click();
    return new MinePage();
  }

}
