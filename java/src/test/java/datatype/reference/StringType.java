package datatype.reference;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

/**
 * String 类学习 <br>
 * 创建时间：2020/4/1 19:51<br>
 * 作者：李云
 */
public class StringType {

  @Test
  public void testReplaceAll(){
    String pathBefore = "C:\\User";
    String pathAfter = pathBefore.replaceAll("\\\\","/");
    print(pathBefore, pathAfter);

    String rBefore = "a \\r b";
    String rAfter = rBefore.replaceAll("\\\\r","R");  //替换 \r 字符串
    print(rBefore, rAfter);

    String nBefore = "a \\n b";
    String nAfter = nBefore.replaceAll("\\\\n","N");  //替换 \n 字符串
    print(nBefore, nAfter);
  }

  private void print(String before, String after){
    System.out.print("替换前：" + before);
    System.out.println(" 替换后：" + after);
  }

  @Test(description = "split 方法")
  public void testSplit() {
    //分割参数：正则表达式
    String line = "Can I help you! isd --- sdf ; sd; 。 you\n me";
    String[] words = line.split("[^a-zA-Z0-9]+"); //使用不包含 a-zA-Z0-9 的字符作为分隔符，从而得到单词列表
    System.out.printf(Arrays.toString(words));
  }

  @Test(description = "substring 方法测试")
  public void testSubstring() {
    String input = "0123456789";
    assertEquals(input.substring(0,5), "01234");  //左闭右开 [)
    assertEquals(input.substring(5), "56789");    //左闭 [
  }

}
