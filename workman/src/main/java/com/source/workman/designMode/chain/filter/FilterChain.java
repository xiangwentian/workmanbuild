package com.source.workman.designMode.chain.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain<T> implements Filter<T> {

    private static FilterChain singleton = new FilterChain<>();
    private FilterChain(){}
    public static FilterChain getInstance(){
        return singleton;
    }

    private List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public void doFilter(T t, FilterChain chain) {
        if (index == filters.size()) {
            return;
        }
        Filter filter = filters.get(index);
        index++;
        filter.doFilter(t, chain);
    }
}
