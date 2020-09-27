package com.liyun.qa.edu.appium.xueqiu;

import org.testng.annotations.Test;

/**
 * 搜索测试
 *
 * @author Li Yun
 * @date 2020/8/7 17:26
 */
public class SearchTest extends XueqiuBaseTest {

  @Test(description = "搜索")
  public void testSearch() {
    SearchPage searchPage = new SearchPage();
    searchPage.search("小米");
    //Q.sleep(3000);

  }

}
