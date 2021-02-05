package com.source.workman.string;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

public class StringTest3 {
    public static void main(String[] args) {
        StringTest3 st3 = new StringTest3();
        List<String> list = st3.mutiParams("hello", "world", "123");
        System.out.println(JSON.toJSONString(list));
    }


    public List mutiParams(String... labelValues) {
        for (String label : labelValues) {
            if (label == null) {
                throw new IllegalArgumentException("Label cannot be null.");
            }
        }

        List<String> key = Arrays.asList(labelValues);
        return key;
    }
}
