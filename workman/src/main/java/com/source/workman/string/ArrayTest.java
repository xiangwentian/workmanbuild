package com.source.workman.string;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 5; i++) {
            array[i] = i;
        }
        System.out.println("before copyOf: " + array.length);
        array = Arrays.copyOf(array, array.length << 1);
        System.out.println("after copyOf: " + array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
