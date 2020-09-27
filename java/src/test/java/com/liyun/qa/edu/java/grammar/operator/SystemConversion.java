package com.liyun.qa.edu.java.grammar.operator;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 进制转换
 *
 * @author Li Yun
 * @date 2020/8/18 10:24
 */
public class SystemConversion {

  @Test(description = "十六进制转二进制", dataProvider = "testHex2Bin")
  public void testHex2Bin(int hex, String expected) {
    String actual = Integer.toBinaryString(hex);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "testHex2Bin")
  public Object[][] testHex2Bin(){
    return new Object[][]{
        //十六进制， 二进制
        {0xaaaaaaaa, "10101010101010101010101010101010"},
        {0x55555555, "1010101010101010101010101010101"},
        {0x33333333, "110011001100110011001100110011"},
        {0xcccccccc, "11001100110011001100110011001100"},
        {0x0f0f0f0f, "1111000011110000111100001111"},
        {0xf0f0f0f0, "11110000111100001111000011110000"}
    };
  }


}
