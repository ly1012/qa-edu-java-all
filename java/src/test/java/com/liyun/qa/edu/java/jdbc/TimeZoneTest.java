package com.liyun.qa.edu.java.jdbc;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;

/**
 * 会话时区测试
 *
 * @author Li Yun
 * @date 2020/9/29 15:11
 */
public class TimeZoneTest {

  Connection conn;

  @BeforeClass
  public void beforeClass() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(
        "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai",
        "root",
        "xxxx");
  }

  @AfterClass
  public void afterClass() throws SQLException {
    if (conn != null){
        conn.close();
    }
  }

  @Test
  public void testTimeZone() throws SQLException {
      PreparedStatement statement = conn.prepareStatement("select now() as now");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()){
        System.out.println(resultSet.getString("now"));
      }
  }
}
