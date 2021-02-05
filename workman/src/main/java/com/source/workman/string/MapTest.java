package com.source.workman.string;

import java.util.HashSet;
import java.util.Set;

public class MapTest {
    public static void setTest() {
        Set<String> set = new HashSet<>();
        boolean oneResult = set.add("hello");
        System.out.println("=====oneResult====" + oneResult);
        boolean result = set.add("hello");
        System.out.println("=====result====" + result);

    }

    public static void main(String[] args) {
        setTest();
    }
}
