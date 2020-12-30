package com.learn.java;

import com.google.common.collect.HashBasedTable;
import com.learn.java.bean.CustomerVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

@SpringBootTest
public class OptionalTest {
    @Test
    void test01() {
        CustomerVo creditCustomerVo = new CustomerVo();

        Map hashMap = new HashMap<>();

        Dictionary hashTable = new Hashtable<>();
        hashTable.put(1,1);

        Collections.synchronizedMap(hashMap);

    }
    public static void main(String[] args) {
        String str = "helloo";
        String str1= "wooooooow";


        str.replaceAll("\\.+", "");// 将.都去掉
        System.out.println("--------");

        System.out.println(str);
//        str = str.replaceAll("(.)\\1+", "$1");// 将重复的字去掉
//        System.out.println("--------");
//        System.out.println(str);
//        System.out.println("--------");
//        System.out.println(str.replaceAll("(.)\\1(.)\\2","$1$1$2"));
        System.out.println(str1.replaceAll("(.)\\1+","$1$1"));
        System.out.println(str1.replaceAll("(.)\\1+","$1$1").replaceAll("(.)\\1(.)\\2","$1$1$2"));


    }
}
