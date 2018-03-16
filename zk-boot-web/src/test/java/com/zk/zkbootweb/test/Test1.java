package com.zk.zkbootweb.test;

import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test1 {
    @Test
    public void test1(){
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println(("c:"+c));
        System.out.println(("e:"+e));
        System.out.println((a == c));
        System.out.println((a == e));
    }

    @Test
    public void test2(){
//        Integer a = 200;
//        Integer b = 200;
//        int c = 200;
//        int d = 200;
//        System.out.println((a == b));
//        System.out.println((a.equals(b)));
//        System.out.println((c == d));
//        System.out.println((c == a));
        Map<Object,String> map = new HashMap<>();
        map.put("Aa哈","123哈哈");
        map.put("Bb哈","123哈哈");
        System.out.println(map.get("Aa哈")==map.get("Bb哈"));
        TreeMap<Object,String> treeMap = new TreeMap<>(map);
        System.out.println(treeMap.get("Aa哈")==treeMap.get("Bb哈"));
    }

    public String orderId() {
        return new DateTime().toString("yyMMddHHmmssSSS") + RandomStringUtils.randomNumeric(8);
    }
    public static void main(String[] args) {
        Test1 o = new Test1();
        System.out.println(o.orderId());
    }
}
