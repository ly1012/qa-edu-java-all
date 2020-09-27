package com.liyun.qa.edu.appium.xueqiu;

import com.liyun.qa.edu.appium.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBySet;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;

import java.util.List;

/**
 * 搜索页面
 *
 * @author Li Yun
 * @date 2020/8/7 16:38
 */
public class SearchPage extends BasePage {

  @AndroidFindBySet({
    @AndroidFindBy(id = "home_search", priority = 1),  //目标节点
    @AndroidFindBy(id = "appbar", priority = 0)        //目标节点的祖先节点
  })
  //@HowToUseLocators(androidAutomation = LocatorGroupStrategy.CHAIN)
  MobileElement home_search;

  @AndroidFindBySet({
    @AndroidFindBy(id = "search_input_text"),
    @AndroidFindBy(id = "not_found")    //不存在的元素
  })
  @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
  MobileElement search_input_text;

  //======== 搜索列表 ==========
  @AndroidFindBy(xpath = "//*[@resource-id=\"com.com.liyun.qa.edu.appium.xueqiu.android:id/listview\"]/*")
  List<MobileElement> listItems;

  @AndroidFindBy(id = "ll_stock_item_container") MobileElement stockItem;

  public void search(String input){
    home_search.click();
    search_input_text.sendKeys(input);
    listItems.get(0).click();
    stockItem.click();
  }

}
