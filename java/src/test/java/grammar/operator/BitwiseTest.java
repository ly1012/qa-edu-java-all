package grammar.operator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 位运算符
 *
 * @author Li Yun
 * @date 2020/5/18 12:43
 */
public class BitwiseTest {

  @Test(dataProvider = "testBitwiseAND",
      description = "&（按位与）：按位与的运算规则是将两边的数转换为二进制位，然后运算最终值，运算规则即(两个为真才为真) 1&1=1 , 1&0=0 , 0&1=0 , 0&0=0")
  public void testBitwiseAND(int a, int b, int e) {
    Assert.assertEquals(a & b,e);
  }

  @DataProvider(name = "testBitwiseAND")
  public Object[][] testBitwiseANDDataProvider(){
    return new Integer[][]{
        {8,6,0},    // 1000 & 0110 = 0000(2) = 0(10)
        {3,5,1},    // 011 & 101 = 001(2) = 1(10)
        {3,7,3}     // 011 & 111 = 011(2) = 3(10)
    };
  }

  @Test(description = "a >> b 运算符，等价于 a/(2^b)")
  public void test1() {
    assertThat(8 >> 1).isEqualTo(4);
    assertThat(8 >> 2).isEqualTo(2);
    assertThat(7 >> 1).isEqualTo(3);
    assertThat(7 >> 2).isEqualTo(1);
  }
}
