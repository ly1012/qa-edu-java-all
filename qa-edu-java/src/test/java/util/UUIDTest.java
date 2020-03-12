package util;

import org.testng.annotations.Test;

import java.util.UUID;

public class UUIDTest {

    @Test
    public void testUUID(){
        System.out.println(UUID.randomUUID().toString().replaceAll("-","").toUpperCase());
    }

}
