package exception.sample;

import org.testng.annotations.Test;

import java.io.*;

/**
 * {@link java.io.FileNotFoundException} 测试
 *
 * @author Li Yun
 * @date 2020/5/7 11:47
 */
public class FileNotFoundExceptionTest {

  @Test(description = "java.io.FileNotFoundException: z:\\a.txt (系统找不到指定的路径。)")
  public void testFileNotFoundException() throws FileNotFoundException {
    File file = new File("z:/a.txt");
    BufferedReader reader = new BufferedReader(new FileReader(file));
    try {
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
