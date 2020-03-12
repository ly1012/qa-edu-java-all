package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * {@link String} 教学示例 <br>
 * 创建时间：2019/3/28 16:15<br>
 * 作者：李云
 */
public class StringTest {

  private static Logger log = LoggerFactory.getLogger(StringTest.class);

  @Test
  public void testReplaceAll(){

    log.info("将 C:\\User 替换为 {}","C:\\User".replaceAll("\\\\","/"));
    log.info("将换行符 \\r 替换为字符 {}","\r".replaceAll("\r","\\\\r"));
    log.info("将换行符 \\n 替换为字符 {}","\n".replaceAll("\n","\\\\n"));

  }

}
