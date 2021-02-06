package com.source.workman.designMode.chain.witness.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzh
 */
//@Component
public class MultiIfFilterChain<T> implements MultiIfFilter<T> {

    private static MultiIfFilterChain instance = new MultiIfFilterChain();

    private MultiIfFilterChain() {
    }

    public static MultiIfFilterChain getInstance() {
        return instance;
    }


    private List<MultiIfFilter> filterList = new ArrayList<MultiIfFilter>();
    private int index = 0;

    public MultiIfFilterChain addFilter(MultiIfFilter multiIfFilter) {
        filterList.add(multiIfFilter);
        return this;
    }

    @Override
    public void doFilter(RequestData<T> requestData, ResponseData responseData, MultiIfFilterChain chain) {
        if (index == filterList.size()) {
            return;
        }
        MultiIfFilter multiIfFilter = filterList.get(index);
        index++;
        multiIfFilter.doFilter(requestData, responseData, chain);
    }
}
