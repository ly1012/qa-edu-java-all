package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import java.util.Objects;

/**
 * <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">21. 合并两个有序链表</a>
 *
 * @author Li Yun
 * @date 2020/8/15 17:19
 */
public class _21_MergeTwoSortedLists {

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ListNode listNode = (ListNode) o;
      return val == listNode.val &&
          Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
      return Objects.hash(val, next);
    }
  }

  /**
   * 取出两个单向链表的头部值，并比较
   *
   * 直接取出链表节点值
   * @param l1
   * @param l2
   * @return
   */
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);  //初始化合并后的链表
    ListNode l = head;
    while(l1 != null || l2 != null){    //如果两个单向链表，至少有一个没取完
      int val;
      if(l1 != null && l2 != null){     //如果两个单向链表都没取完
        int i1 = l1.val;
        int i2 = l2.val;
        if(i1 < i2){
          val = i1;
          l1 = l1.next;
        }else{
          val = i2;
          l2 = l2.next;
        }
      }else if(l1 != null){             //如果第一个链表没取完
        val = l1.val;
        l1 = l1.next;
      }else{                            //如果第二个链表没取完
        val = l2.val;
        l2 = l2.next;
      }
      l.next = new ListNode(val);       //将比较后的较小的值添加到合并后的链表
      l = l.next;
    }
    return head.next;                   //因为初始化的节点不是合并的节点，所以从下一个节点开始返回
  }

  /**
   * 迭代法
   * @param l1
   * @param l2
   * @return
   */
  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    ListNode prehead = new ListNode(0);      //初始化合并后的链表
    ListNode cur = prehead;                       //用于迭代获取较小节点
    while(l1 != null && l2 != null){              //两个链表都不为空时
      if(l1.val < l2.val){                        //哪个链表的头节点值小，就将指针指向它
        cur.next = l1;
        l1 = l1.next;
      }else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;                              //迭代指向添加的节点（这步本质上是完成了节点的添加）
                                                   //准备获取下一个添加节点
    }
    cur.next = (l1 == null) ? l2 : l1;             //如果有一个未空，比如 l1 为空，那么说明上一次执行的是 l1.next，
                                                   //即合并链表尾部是 l1 且 l1 迭代完成，将 l2 全部添加到合并链表末尾，
                                                   //反之亦然。
    return prehead.next;
  }

  /**
   * 递归法
   * @param l1
   * @param l2
   * @return
   */
  public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val < l2.val){                       //l1 首节点值小，则将 l1 首节点作为最终链表节点。
      l1.next = mergeTwoLists3(l1.next, l2);    //最终链表的后面部分为两个链表剩余部分合并后的链表。
      return l1;                                //返回 l1 作为最终链表，l1 = 较小节点 + 剩余部分合并节点。
    }else {                                     //和上面同理。
      l2.next = mergeTwoLists3(l1, l2.next);
      return l2;
    }
  }

}
