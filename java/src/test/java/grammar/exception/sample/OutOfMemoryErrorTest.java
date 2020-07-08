package grammar.exception.sample;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * {@link java.lang.OutOfMemoryError} 测试
 *
 * @author Li Yun
 * @date 2020/5/7 14:24
 */
public class OutOfMemoryErrorTest {

  //设置 JVM 参数：-Xms2m -Xmx2m
  @Test(description = "Exception in thread \"main\" java.lang.OutOfMemoryError: Java heap space")
  public void testOutOfMemoryError() {
    List<String> list = new ArrayList<>();
    while (true){
      list.add(UUID.randomUUID().toString());
    }
  }
}
