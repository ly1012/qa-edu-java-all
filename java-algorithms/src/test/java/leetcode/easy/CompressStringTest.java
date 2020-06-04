package leetcode.easy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CompressStringTest {

  @Test(description = "字符串压缩", dataProvider = "testCompressString")
  public void testCompressString(String input, String expected) {
    String actual = CompressString.compressString(input);
    assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "testCompressString")
  public Object[][] testCompressString(){
    return new Object[][]{
        {"aabcccccaaa", "a2b1c5a3"},                 //正常压缩
        {"abbccd", "abbccd"},                        //压缩后未变短 a1b2c2d1 ，返回原来字符串
        {"aacc", "aacc"},                            //压缩后未变短 a2c2 ，返回原来字符串
        {"a", "a"},                                  //一个字符
        {"", ""},                                    //空字符串
        {"AAABBcddd", "A3B2c1d3"}                    //字符串包含大小写字母
    };
  }

}