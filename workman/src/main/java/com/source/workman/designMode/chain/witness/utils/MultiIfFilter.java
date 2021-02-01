package com.source.workman.designMode.chain.witness.utils;

public interface MultiIfFilter<T> {

    void doFilter(RequestData<T> requestData, ResponseData responseData, MultiIfFilterChain chain);
}
