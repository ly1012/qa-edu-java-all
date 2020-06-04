package collection;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TODO
 *
 * @author Li Yun
 * @date 2020/5/11 15:30
 */
public class HashSetTest {

  @Test(description = "测试 add 方法")
  public void testAdd() {
    Set<String> set = new HashSet<>();
    assertThat(set.add("a")).isTrue();
    assertThat(set.add("a")).isFalse();
  }
}
