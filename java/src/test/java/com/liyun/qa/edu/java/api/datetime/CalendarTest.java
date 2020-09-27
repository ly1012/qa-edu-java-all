package com.liyun.qa.edu.java.api.datetime;

import org.testng.annotations.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@link java.util.Calendar} 测试
 *
 * @author Li Yun
 * @date 2020/7/8 16:37
 */
public class CalendarTest {

  @Test(description = "获取日期指定字段信息")
  public void testName() {
    int year = Calendar.getInstance().get(Calendar.YEAR);
    assertThat(year).isEqualTo(2020);
  }

}
