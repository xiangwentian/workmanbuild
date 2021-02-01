package com.source.workman.designMode.chain.witness;

import com.source.workman.designMode.chain.witness.utils.*;

public class TestFilterTwo implements MultiIfFilter {
    @Override
    public void doFilter(RequestData requestData, ResponseData responseData, MultiIfFilterChain chain) {
        if (requestData.getChannel().equals("2")) {
            System.out.println("TestFilterTwo invoke");

            //responseData.setResult(new ResultData("TestFilterTwo success", "000000"));
            responseData.setCode("000000");
            responseData.setMsg("TestFilterTwo success");
            return;
        }
        chain.doFilter(requestData, responseData, chain);
    }
}
