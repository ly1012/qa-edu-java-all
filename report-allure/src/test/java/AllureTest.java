import io.qameta.allure.*;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * TODO
 *
 * @author Li Yun
 * @date 2020/6/22 20:33
 */
@Epic("Allure examples")
@Feature("Junit 4 support")
public class AllureTest {

  @BeforeMethod(description = "Configure something before test")
  public void setUp() {
    //...
  }

  @Test(description = "添加商品测试")
  @Story("Base support for bdd annotations")
  @Story("Advanced support for bdd annotations")
  public void testAddGoods() {
    loginWith("a", "b");
    Reporter.log("控制台日志");
    //...
    throw new NullPointerException("null");
  }


  @Test(dataProvider = "dp", description = "登录测试")
  @Issue("006") //Bug 编号
  @TmsLink("007") //测试用例编号
  public void testLogin(String description, String user, String pwd) {
    loginWith(user, pwd);
  }

  @Step("Type {username} / {password}.")
  public void loginWith(String username, String password) {
     //...
  }

  @DataProvider(name = "dp")
  public Object[][] dataprovider(){
    return new Object[][]{
        {"正确的用户名和密码","tom", "tompwd"},
        {"正确的用户名和错误的密码","Mary", "errorpwd"}
    };
  }

}
