package com.source.workman.designMode.chain.filter;

import lombok.Data;

@Data
public class FilterBean {
    String name;
    String accNo;
    String carId;
    String channel;

    String result;

    @Override
    public String toString() {
        return "FilterBean{" +
                "name='" + name + '\'' +
                ", accNo='" + accNo + '\'' +
                ", carId='" + carId + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }
}
