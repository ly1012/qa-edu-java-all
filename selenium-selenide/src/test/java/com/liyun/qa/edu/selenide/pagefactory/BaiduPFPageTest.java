package com.liyun.qa.edu.selenide.pagefactory;

import com.liyun.qa.edu.selenide.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 百度搜索测试 <br>
 * 创建时间：2020/4/4 11:33<br>
 * 作者：李云
 */
public class BaiduPFPageTest extends BaseTest {

  BaiduPFPage baiduPage;

  @BeforeClass
  public void beforeClass(){
    // 因为使用了 PageFactory，无参构造器中进行了属性初始化，不能在成员变量声明时赋值，否则实例化测试类会失败
    baiduPage = new BaiduPFPage();
    // 如果无参构造器为空或 do nothing，可以使用下面的写法
    //baiduPage = page(BaiduPFPage.class);
  }

  @Test
  public void testSearch() {
    baiduPage.open().search("众里寻他千百度，蓦然回首，那人却在灯火阑珊处");
  }

}
