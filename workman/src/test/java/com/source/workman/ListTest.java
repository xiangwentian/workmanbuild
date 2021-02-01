package com.source.workman;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        ListTest lt = new ListTest();
//        lt.tt();
        List<Double> list = lt.forTest();
        System.out.println(list.get(list.size()-1));
    }

    public void tt() {
        Double refundFee = 6.1d;
        List<Double> fitList = new ArrayList<>();

        List<Double> list = forTest();
        Double fitAmount = 0.0d;
        for (int i = 0; i < list.size(); i++) {
            Double tpwt = list.get(i);
            fitAmount += tpwt;
            if (fitAmount.equals(refundFee)) {
                fitList.add(tpwt);
                break;
            }
            if (fitAmount < refundFee) {
                fitList.add(tpwt);
                continue;
            }
            if (fitAmount > refundFee) {
                fitList.add(tpwt);
                break;
            }
        }

        System.out.println(JSON.toJSONString(fitList));
    }

    public List<Double> forTest() {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(Double.valueOf(i));
        }
        return list;
    }

}
