package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">21. 合并两个有序链表</a>
 *
 * @author Li Yun
 * @date 2020/8/15 17:10
 */
public class _21_MergeTwoSortedListsTest {

  _21_MergeTwoSortedLists aut = new _21_MergeTwoSortedLists();

  @Test(description = "测试直接取值", dataProvider = "dp")
  public void testMerge1(_21_MergeTwoSortedLists.ListNode l1, _21_MergeTwoSortedLists.ListNode l2,
                         String expected)
  {
    String actual = toStr(aut.mergeTwoLists(l1, l2));
    assertThat(actual).isEqualTo(expected);
  }

  @Test(description = "测试迭代法", dataProvider = "dp")
  public void testMerge2(_21_MergeTwoSortedLists.ListNode l1, _21_MergeTwoSortedLists.ListNode l2,
                         String expected)
  {
    String actual2 = toStr(aut.mergeTwoLists2(l1, l2));
    assertThat(actual2).isEqualTo(expected);
  }

  @Test(description = "测试递归法", dataProvider = "dp")
  public void testMerge3(_21_MergeTwoSortedLists.ListNode l1, _21_MergeTwoSortedLists.ListNode l2,
                         String expected)
  {
    String actual3 = toStr(aut.mergeTwoLists3(l1, l2));
    assertThat(actual3).isEqualTo(expected);
  }

  @DataProvider(name = "dp")
  public Object[][] dp(){
    return new Object[][]{
        {toList("1, 2, 4"), toList("1,3,4"), "1,1,2,3,4,4"}
    };
  }

  //字符串转单向链表，用于测试数据准备
  private _21_MergeTwoSortedLists.ListNode toList(String input){
    String[] ss = input.split(",");       //字符串转字符串数组
    _21_MergeTwoSortedLists.ListNode head = new _21_MergeTwoSortedLists.ListNode(0);
    _21_MergeTwoSortedLists.ListNode l = head;
    for (int i = 0; i < ss.length; i++){
      int val = Integer.parseInt(ss[i].trim());
      l.next = new _21_MergeTwoSortedLists.ListNode(val);
      l = l.next;
    }
    return head.next;
  }

  //单向链表转字符串，用于断言
  private String toStr(_21_MergeTwoSortedLists.ListNode l){
    StringBuffer sb = new StringBuffer();
    while (l != null){
      sb.append(l.val + ",");
      l = l.next;
    }
    return sb.substring(0, sb.length() -1);
  }

}
