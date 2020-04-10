package com.liyun.qa.edu.selenium.selenide.pageobject;

import org.testng.annotations.Test;

public class BaiduPOPageTest {

  // 不使用 PageFactory，可以直接初始化
  BaiduPOPage baiduPage = new BaiduPOPage();

  @Test
  public void testSearch() {
    baiduPage.open().search("众里寻他千百度，蓦然回首，那人却在灯火阑珊处");
  }

}