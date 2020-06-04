package base.datatype.primary;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * char 类型测试
 *
 * @author Li Yun
 * @date 2020/5/19 10:52
 */
public class CharTypeTest {

  //参考资料；[特殊的空格-ASCII码值160](https://blog.csdn.net/lewky_liu/article/details/79353151)
  @Test(description = "不间断空格(non-breaking space)，缩写为 nbsp")
  public void testName() {
    char normal = ' ';                      //正常的空格，ascii 码为 32
    char nbsp = ' ';                        //特殊的空格：不间断空格，ascii 码为 160
    assertThat((int)normal).isEqualTo(32);
    assertThat((int)nbsp).isEqualTo(160);
  }

}
