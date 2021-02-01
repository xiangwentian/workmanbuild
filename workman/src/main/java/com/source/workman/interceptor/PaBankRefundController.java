package com.source.workman.interceptor;

import com.alibaba.fastjson.JSON;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("refundCtr")
public class PaBankRefundController {

    @RequestMapping(value = "refund", method = RequestMethod.POST)
    public JsonResult refund(TEPay tePay) {
        JsonResult jsonResult = new JsonResult();
        try {
            checkParams(tePay);
            jsonResult.success("请求成功");
        } catch (IllegalArgumentException e) {
            jsonResult.failure(e.getMessage());
        }
        return jsonResult;
    }

    private void checkParams(TEPay tePay) {
        System.out.println(JSON.toJSONString(tePay));
        Assert.notNull(tePay, "请求参数为空");
    }
}
