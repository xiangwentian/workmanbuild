package com.source.workman.designMode.chain.witness;

import com.source.workman.designMode.chain.witness.utils.MultiIfFilterChain;
import com.source.workman.designMode.chain.witness.utils.RequestData;
import com.source.workman.designMode.chain.witness.utils.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvokeCtrl {

    @RequestMapping("test")
    public String filterTest(String channel) {
        RequestData requestData = new RequestData<InvokeTestBean>();
        requestData.setChannel("2");

        ResponseData responseData = new ResponseData();
        chain(requestData, responseData);
        return responseData.getMsg();
    }

    private ResponseData chain(RequestData requestData, ResponseData responseData) {
        MultiIfFilterChain chain = MultiIfFilterChain.getInstance();
        chain.addFilter(new TestFilterOne()).addFilter(new TestFilterTwo()).doFilter(requestData, responseData, chain);
        return responseData;
    }
}
