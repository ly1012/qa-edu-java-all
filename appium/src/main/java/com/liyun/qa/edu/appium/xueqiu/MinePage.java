package com.liyun.qa.edu.appium.xueqiu;

import com.liyun.qa.edu.appium.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * 我的页面
 *
 * @author Li Yun
 * @date 2020/8/7 11:14
 */
public class MinePage extends BasePage {

  @AndroidFindBy(id = "rl_login")
  MobileElement loginByAccountAndPassword;  //账号密码登录

  public LoginPage goLoginPage(){
    loginByAccountAndPassword.click();
    return new LoginPage();
  }

}
