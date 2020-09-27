package com.liyun.qa.edu.java.api;

import org.testng.annotations.Test;

import java.util.UUID;

public class UUIDTest {

    @Test
    public void testUUID(){
        String oid = UUID.randomUUID().toString();
        System.out.println(oid);
        System.out.println(oid.replaceAll("-",""));
        System.out.println(oid.replaceAll("-","").toUpperCase());
    }

}
