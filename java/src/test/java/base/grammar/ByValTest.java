package base.grammar;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Java 中的值传递
 * @author liyun
 */
public class ByValTest {

    @Test(description = "方法参数的值传递")
    public void testByVal() {
        Person p = new Person();
        //方法参数赋值等价于：Person person = p ，将实参 p 的引用值赋值给 person
        setName(p);
        //注意，如果 person 和 p 是完全相同的对象，则 person 和 p 的值一同改变（即没有 person = new Person();），那么此处应该输出 B 而不是 A。
        Assert.assertEquals(p.name,"A");
    }


    private void setName(Person person){
        person.name = "A";
        person = new Person();
        person.name = "B";
    }

    public class Person{
        private String name;
    }

}
