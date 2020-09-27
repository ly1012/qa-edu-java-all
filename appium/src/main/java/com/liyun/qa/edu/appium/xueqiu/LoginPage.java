package com.liyun.qa.edu.appium.xueqiu;

import com.liyun.qa.edu.appium.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * com.com.liyun.qa.edu.appium.xueqiu.android/.common.account.LoginActivity
 *
 * @author Li Yun
 * @date 2020/8/7 11:17
 */
public class LoginPage extends BasePage {

  @AndroidFindBy(id = "login_account")
  MobileElement login_account;

  @AndroidFindBy(id = "login_password")
  MobileElement login_password;

  @AndroidFindBy(id = "button_next")
  MobileElement login;

  public void login(String username, String password){
    login_account.sendKeys(username);
    login_password.sendKeys(password);
    login.click();
  }

}
