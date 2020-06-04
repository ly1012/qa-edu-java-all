package leetcode.normal;

import java.util.Objects;

/**
 * <a href="https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/">19. 删除链表的倒数第N个节点</a>
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author Li Yun
 * @date 2020/5/20 10:53
 */
public class RemoveNthFromEnd {

  //Definition for singly-linked list.
  static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

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
   * 删除链表的倒数第 n 个节点，并且返回链表的头结点
   *
   * 思路：
   * 使用双指针：前指针和后指针，两个指针的距离为 n
   * 当后指针到达尾部时，则前指针到达删除位置
   *
   * @param head
   * @param n
   * @return
   */
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    if (head.next == null) return null;

    ListNode pre = head;              //前指针
    ListNode end = head;              //后指针

    for (int i = 0; i < n; i++){      //后指针后移 n 位
      end = end.next;
    }
    if (end == null){                 //移除头部节点
      return head.next;
    }

    while (end.next != null){         //前后指针同步右移，直到后指针到达尾部
      pre = pre.next;
      end = end.next;
    }
    pre.next = pre.next.next;         //删除倒数第 N 个节点

    return head;
  }

}



