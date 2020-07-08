package grammar.exception.sample;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * {@link java.sql.SQLException} 测试
 *
 * @author Li Yun
 * @date 2020/5/7 14:37
 */
public class SQLExceptionTest {

  @Test(description = "java.sql.SQLException: Access denied for user 'root'@'localhost' (using password: YES)")
  public void testSQLException() {

    //加载 MySQL 驱动
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    //获取数据库连接
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(
          "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC",
          "root",
          "****");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }finally {
      if (conn != null){
        try {
          conn.close();
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }
    }


  }
}
