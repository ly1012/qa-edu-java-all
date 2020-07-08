package api.collection;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * LinkedList 测试
 *
 * @author Li Yun
 * @date 2020/5/7 19:37
 */
public class LinkedListTest {

  LinkedList<Integer> list;

  @BeforeMethod
  public void setUp() {
    list = new LinkedList<>(
        Arrays.asList(0, 1, 2, 3, 4, 5)
    );
  }

  @Test(description = "入队并返回true或false（第一个元素是队头，最后一个元素是队尾）")
  public void testOffer() {
    boolean r1 = list.offer(6);
    boolean r2 = list.offer(7);

    assertThat(r1).isTrue();
    assertThat(r2).isTrue();
    System.out.println(list);
    assertThat(list.toString()).isEqualTo("[0, 1, 2, 3, 4, 5, 6, 7]");
    assertThat(list.size()).isEqualTo(8);
  }

  @Test(description = "出队并返回该元素（第一个元素是队头，最后一个元素是队尾）")
  public void testPoll() {
    Integer head = list.poll();

    assertThat(head).isEqualTo(0);
  }

  @Test(description = "入栈（第一个元素是栈顶，最后一个元素是栈底）")
  public void testPush() {
    list.push(6);

    assertThat(list.toString()).isEqualTo("[6, 0, 1, 2, 3, 4, 5]");
  }

  @Test(description = "出栈（第一个元素是栈顶，最后一个元素是栈底）")
  public void testPop() {
    Integer head = list.pop();

    assertThat(head).isEqualTo(0);
    assertThat(list.toString()).isEqualTo("[1, 2, 3, 4, 5]");
  }

  @Test(description = "移除队头元素并返回该元素")
  public void testRemoveFirst() {
    Integer first = list.removeFirst();
    assertThat(first).isEqualTo(0);
    assertThat(list.size()).isEqualTo(5);
  }

  @Test(description = "移除队尾元素并返回该元素")
  public void testRemoveLast() {
    Integer last = list.removeLast();
    assertThat(last).isEqualTo(5);
    assertThat(list.size()).isEqualTo(5);
  }
}
