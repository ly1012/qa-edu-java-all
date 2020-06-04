package leetcode.normal;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveNthFromEndTest {

  @Test(description = "删除链表的倒数第 n 个节点", dataProvider = "testcase")
  public void testRemoveNthFromEnd(RemoveNthFromEnd.ListNode head, int n, RemoveNthFromEnd.ListNode[] expected) {
    RemoveNthFromEnd.ListNode actual = RemoveNthFromEnd.removeNthFromEnd(head, n);
    assertThat(objToArray(actual)).isEqualTo(expected);
  }

  private RemoveNthFromEnd.ListNode[] objToArray(RemoveNthFromEnd.ListNode head){
    RemoveNthFromEnd.ListNode[] nodes;
    if (head == null){
      return new RemoveNthFromEnd.ListNode[0];
    }

    int length = 0;
    RemoveNthFromEnd.ListNode tmp = head;
    do{
      length++;
    } while ((tmp = tmp.next) != null);

    nodes = new RemoveNthFromEnd.ListNode[length];
    int index = 0;
    nodes[0] = head;
    RemoveNthFromEnd.ListNode cur = head;
    while (cur.next != null){
      index++;
      cur = cur.next;
      nodes[index] = cur;
    }

    return nodes;
  }

  @DataProvider(name = "testcase")
  public Object[][] testcase(){
    //测试用例元信息
    //第一位：链表长度
    //第二位：要删除的节点坐标，即倒数第 ？ 个节点
    int[][] datas = new int[][]{
        {1, 1},
        {2, 1},
        {2, 2},
        {5, 2},
        {10, 4}
    };

    //测试用例最终信息
    Object[][] cases = new Object[datas.length][3];

    //根据元信息填充用例
    for (int i = 0; i < datas.length; i++){
      int[] data = datas[i];
      RemoveNthFromEnd.ListNode[] nodes = produce(data[0]);    //生产一个长度为 data[0] 的链表
      cases[i][0] = nodes[0];                                  //链表
      cases[i][1] = data[1];                                   //倒数第 N

      RemoveNthFromEnd.ListNode[] expected = new RemoveNthFromEnd.ListNode[nodes.length -1];
      int delIndex = nodes.length - data[1];
      for (int j = 0; j < expected.length; j++){
        if (j < delIndex) expected[j] = nodes[j];
        if (j >= delIndex) expected[j] = nodes[j+1];
      }

      cases[i][2] = expected;                                   //预期值
    }

    return cases;
  }

  //生产一个长度为 n 的链表对应的数组
  private RemoveNthFromEnd.ListNode[] produce(int n){
    RemoveNthFromEnd.ListNode[] linkedList = new RemoveNthFromEnd.ListNode[n];
    if (n == 0) return linkedList;

    linkedList[0] = new RemoveNthFromEnd.ListNode(1);
    for (int i = 1; i < n; i++){
      linkedList[i] = new RemoveNthFromEnd.ListNode(i + 1);
      linkedList[i-1].next = linkedList[i];
    }
    return linkedList;
  }



}