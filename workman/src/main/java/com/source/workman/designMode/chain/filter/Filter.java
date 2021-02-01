package com.source.workman.designMode.chain.filter;

public interface Filter<T> {
    void doFilter(T t, FilterChain chain);
}
