package base.datatype.primary;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * int 类型
 */
public class IntType {

    @Test(description = "数值字面量中添加下划线，增强可读性")
    public void testUnderline(){
        int ia = 1000000;
        //在 Java 7 中，不管是整数还是浮点数，都允许在数字之间插入任意多个下划线。这些下划线不会对字面量的数值产生影响，只是方便阅读。
        //编译器并不认识字面量中的 _ ，需要在编译阶段去掉。
        int ib = 1_000_000;
        Assert.assertEquals(ia,ib);
    }

    @Test(description = "int 最大值")
    public void testMaxValue() {
        int max = Integer.MAX_VALUE;        // 2^31 - 1
        assertThat(max).isEqualTo(2147483647);
    }
}
