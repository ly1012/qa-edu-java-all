package com.liyun.qa.edu.selenide;

import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;

/**
 * 测试基础类 <br>
 * 创建时间：2020/4/4 13:35<br>
 * 作者：李云
 */
public class BaseTest {

  @BeforeSuite
  public void beforeSuite(){
    open();
  }

}
