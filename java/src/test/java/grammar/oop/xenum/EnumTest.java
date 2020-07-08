package grammar.oop.xenum;

import org.testng.annotations.Test;

/**
 * 枚举类
 */
public class EnumTest {

    public enum Animal {

        //注意事项：
        //1. 最后一个枚举值使用分号 ;
        //2. 中间的枚举值后面使用逗号 ,
        DOG("狗"),
        CAT("猫");

        private final String cname;

        Animal(String cname){
            this.cname = cname;
        }

        public String getCname() {
            return cname;
        }

    }

    @Test
    public void testEnum() {
        String a = Animal.valueOf("DOG").name();
        System.out.println("name："+a);
        System.out.println("name："+Animal.DOG.name());
        System.out.println("toString："+Animal.DOG.toString());
        System.out.println("name："+Animal.DOG.getCname());
        System.out.println("equals："+Animal.CAT.equals(Animal.CAT));

        System.out.println();

        for(Animal animal : Animal.values()){
            System.out.println("toString："+animal);
        }
    }


}
