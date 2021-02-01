package com.source.workman.designMode.chain.witness;

import com.source.workman.designMode.chain.witness.utils.MultiIfFilter;
import com.source.workman.designMode.chain.witness.utils.MultiIfFilterChain;
import com.source.workman.designMode.chain.witness.utils.RequestData;
import com.source.workman.designMode.chain.witness.utils.ResponseData;

public class MutilfFilterTest {
    public static void main(String[] args) {
        MutilfFilterTest mft = new MutilfFilterTest();
        String result = mft.filterTest("2");
        System.out.println("result=" + result);
    }

    public String filterTest(String channel) {
        RequestData requestData = new RequestData<InvokeTestBean>();
        requestData.setChannel(channel);

        ResponseData responseData = new ResponseData();

        chain(requestData, responseData);
        return responseData.getMsg();
    }

    private void chain(RequestData requestData, ResponseData responseData) {
        MultiIfFilterChain chain = MultiIfFilterChain.getInstance();
        chain.addFilter(new TestFilterOne()).addFilter(new TestFilterTwo());
        chain.doFilter(requestData, responseData, chain);
        //return responseData;
    }
}
