package topic.recursion;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShootingTest {

  @Test
  public void testShoot() {
    long beginTime = System.currentTimeMillis();
    long sum = Shooting.shoot(10, 90);
    long endTime = System.currentTimeMillis();
    String result = String.format("计算结果：%d，计算耗时： %d 毫秒", sum, endTime - beginTime);
    System.out.println(result);
    assertThat(sum).isEqualTo(92378);
  }
}