package grammar.operator;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * 运算符优先级测试
 *
 * @author Li Yun
 * @date 2020/5/30 12:28
 */
public class OperatorPriorityTest {

  @Test(description = "& 优先级比 | 高")
  public void testAND_OR() {
    Assertions.assertThat(true | false & false).isTrue();
  }
}
