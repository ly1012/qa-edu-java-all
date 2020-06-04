package collection;

import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author Li Yun
 * @date 2020/4/27 17:33
 */
public class ArrayListTest {

  @Test
  public void testName() {
    ArrayList<Integer> array = new ArrayList<>();
    array.add(4, 4);
    array.add(3);
  }

}
