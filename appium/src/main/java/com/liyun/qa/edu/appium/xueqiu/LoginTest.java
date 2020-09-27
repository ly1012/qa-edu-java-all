package com.liyun.qa.edu.appium.xueqiu;

import org.testng.annotations.Test;

/**
 * 登录测试
 *
 * @author Li Yun
 * @date 2020/8/7 10:39
 */
public class LoginTest extends XueqiuBaseTest {

  @Test(description = "账号密码登录")
  public void testLoginByAccount() {
    MainPage mainPage = new MainPage();
    mainPage
        .goMinePage()
        .goLoginPage()
        .login(account.getUsername(), account.getPassword());
  }

}
