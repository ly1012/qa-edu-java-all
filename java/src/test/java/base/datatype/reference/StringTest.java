package base.datatype.reference;

import org.apache.commons.codec.Charsets;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * String 类学习 <br>
 * 创建时间：2020/4/1 19:51<br>
 * 作者：李云
 */
public class StringTest {

  @Test(description = "字符串反转")
  public void testReverse() {
    String s = "abcd";
    StringBuffer sb = new StringBuffer(s);
    assertThat(sb.reverse().toString()).isEqualTo("dcba");
  }

  @Test(description = "字符串编码转换")
  public void testNewString() {
    "d".intern();
    String origin = "中文";                                   //默认是 UTF-8
    byte[] bytes = origin.getBytes();
    System.out.println(new String(bytes, Charsets.UTF_8));
    System.out.println(new String(bytes, Charsets.US_ASCII));
    System.out.println(new String(bytes, Charsets.UTF_16));

    byte[] bytes1 = origin.getBytes(Charsets.UTF_16);         //使用 UTF-16 编码（解析出来的不对，因为原格式为 UTF-8）
    System.out.println(new String(bytes, Charsets.UTF_16));   //使用 UTF-16 解码
  }

  @Test(description = "charAt 方法，从 0 开始")
  public void testCharAt() {
    String a = "abcde";
    System.out.println(a.charAt(1));
  }

  @Test(description = "字符串相等测试")
  public void testEquals(){
    String s1 = "ab";
    String s2 = "a" + "b";
    String s3 = "a";
    String s4 = "b";
    String s5 = s3 + s4;
    boolean v12 = s1 == s2;
    boolean v15 = s1 == s5;
    assertThat(v12).isTrue();
    assertThat(v15).isFalse();
  }

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

  @Test(description = "丢弃数组后面的空字符串元素")
  public void testSplit2() {
    String str = ",a,b,c,,";
    String[] ary = str.split(",");            //split 方法的 limit 参数为 0，因此会丢弃数组后面的空字符串
    Assertions.assertThat(ary.length).isEqualTo(4);
  }

  @Test(description = "substring 方法测试")
  public void testSubstring() {
    String input = "0123456789";
    assertThat(input.substring(0,5)).isEqualTo("01234");  //左闭右开 [)
    assertThat(input.substring(5)).isEqualTo("56789");    //左闭 [
  }

}
