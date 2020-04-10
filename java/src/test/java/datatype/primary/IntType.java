package datatype.primary;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

    @Test(dataProvider = "testBitwiseAND",
        description = "&（按位与）：按位与的运算规则是将两边的数转换为二进制位，然后运算最终值，运算规则即(两个为真才为真) 1&1=1 , 1&0=0 , 0&1=0 , 0&0=0")
    public void testBitwiseAND(int a, int b, int e) {
        Assert.assertEquals(a & b,e);
    }

    @DataProvider(name = "testBitwiseAND")
    public Object[][] testBitwiseANDDataProvider(){
        return new Integer[][]{
            {8,6,0},    // 1000 & 0110 = 0000(2) = 0(10)
            {3,5,1},    // 011 & 101 = 001(2) = 1(10)
            {3,7,3}     // 011 & 111 = 011(2) = 3(10)
        };
    }
}
