package com.source.workman.designMode.chain.witness;

import com.source.workman.designMode.chain.witness.utils.*;

public class TestFilterOne implements MultiIfFilter {

    @Override
    public void doFilter(RequestData requestData, ResponseData responseData, MultiIfFilterChain chain) {
        if (requestData.getChannel().equals("1")) {
            System.out.println("TestFilterOne invoke");

//            responseData.setResult(new ResultData("TestFilterOne success", "000000"));
            responseData.setCode("000000");
            responseData.setMsg("TestFilterOne success");
            return;
        }
        chain.doFilter(requestData, responseData, chain);
    }
}
