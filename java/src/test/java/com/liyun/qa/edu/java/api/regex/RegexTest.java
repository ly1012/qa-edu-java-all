package com.liyun.qa.edu.java.api.regex;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * 正则表达式学习
 * create time: 2019-09-09
 * @author liyun
 */
public class RegexTest {

    @Test(description = "匹配提取单词")
    public void testWords() {
        //分割参数：正则表达式
        String line = "Can I help you! isd --- sdf ; sd; 。 you\n me";
        String[] words = line.split("[^a-zA-Z0-9]+"); //使用不包含 a-zA-Z0-9 的字符作为分隔符，从而得到单词列表
        System.out.printf(Arrays.toString(words));
    }

    @Test(description = "匹配标准 ASCII 字符")
    public void testAscii() {
        //[\x00-\x7F] 范围从 0 - 127
        boolean f = "a09e&*".matches("[\\x00-\\x7F]*");
        assertThat(f).isTrue();
    }

    @Test(description = "测试正则表达式中的横杠")
    public void testHyphen() {
        //参考资料：http://www.zjmainstay.cn/regexp-special-char-in-match-a-single-character
        //注意：[] 中的 - 需要转义才能表达字面意思，否则表示区间
        String regex = "[a-zA-Z0-9]+[a-zA-Z0-9#$\\-_+=:./]*";
        boolean isMatch = Pattern.matches(regex,"3Amo:.$:c:#-:kl=ab:_w+ir.em=/ock_:v-.:");
        assertTrue(isMatch);

        String regex2 = "[1-9]+[0-9]*";
        boolean isMatch2 = Pattern.matches(regex2,"58");
        assertTrue(isMatch2);

    }


    /*
    给定字符串：
    aaadbsj
    aaahsan
    aaacats
    bbbsjoj
    要求：匹配以 aaa 开头但不包含 cat 的字符串。
     */
    @Test(description = "测试正则表达式不包含指定字符的用法", dataProvider = "testcaseOfNotContains")
    public void testNotContains(String input, boolean expected) {
        // 参考资料：[正则表达式匹配不包含某些字符串的技巧](https://www.jb51.net/article/52491.htm)
        boolean isMatch = Pattern.matches("^aaa((?!cat).)*$", input);
        assertEquals(isMatch,expected);
    }

    @DataProvider(name = "testcaseOfNotContains")
    public Object[][] testcaseOfNotContains(){
        return new Object[][]{
            {"aaadbsj", true},
            {"aaahscant", true},
            {"aaacats", false},
            {"bbbsjoj", false}
        };
    }

    @Test
    public void testReplaceAll() {
        String input = ":";
        String result = input.replaceAll(":","%3A");
        assertEquals("%3A",result);
    }
}
