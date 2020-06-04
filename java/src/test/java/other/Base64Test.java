package other;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

/**
 * {@link Base64} 教学示例 <br>
 * 创建时间：2019/3/25 9:46<br>
 * 作者：李云
 */
public class Base64Test {

  private static final Logger log = LoggerFactory.getLogger(Base64Test.class);

  //编码前
  private final String expectPlain = "/nginx/mocklab/xianbank_mock/online";
  //编码后
  private final String expectBase64 = "L25naW54L21vY2tsYWIveGlhbmJhbmtfbW9jay9vbmxpbmU=";


  private final Base64.Encoder encoder = Base64.getEncoder();
  private final Base64.Decoder decoder = Base64.getDecoder();

  @Test(description = "编码明文字符串")
  public void testEncodePlainString(){
    String actualBase64 = encoder.encodeToString(expectPlain.getBytes());
    Assert.assertEquals(actualBase64, expectBase64);
  }

  @Test(description = "解码Base64字符串")
  public void testDecodeBase64String(){
    String actualPlain = new String(decoder.decode(expectBase64));
    Assert.assertEquals(actualPlain,expectPlain);
  }

  @Test
  public void testEncodeBinaryFile() throws IOException {
    File file =new File("src/test/resources/excel-list.xlsx");
    log.info(file.getAbsolutePath());
    byte[] bytes = Files.readAllBytes(file.toPath());
    String actualBase64 = new String(encoder.encode(bytes));
    log.info(actualBase64);
  }

}
