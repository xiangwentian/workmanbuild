package com.source.workman.interceptor;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author liuzh
 */
@Aspect
@Component
public class RefundLogAspect {

    ThreadLocal<RefundLog> local = new ThreadLocal();

//    @Autowired
//    private RefundLogDao refundLogDao;

    @Around("execution(* com.source.workman.interceptor.PaBankRefundController.refund(..))")
    public Object handelControllerMethod(ProceedingJoinPoint point) throws Throwable {
        System.out.println("aspect start ");

        //获取参数
        Object[] args = point.getArgs();

        getParams(args);

        //去调用被拦截的方法
        Object proceed = point.proceed();

        resultCheck(proceed);

        return proceed;
    }

    private void getParams(Object[] args) {

        for (Object arg : args) {
            System.out.println("arg ==>" + arg);
            if (arg instanceof TEPay) {
                TEPay tePay = (TEPay) arg;
                RefundLog rl = new RefundLog();
                rl.setAmount(tePay.getAmount());
                rl.setChannel(tePay.getCategory());
                rl.setOrderId(String.valueOf(tePay.getOrderId()));
                rl.setOrderNo(tePay.getOrderCode());
                local.set(rl);
            }
        }
    }

    private void resultCheck(Object proceed) {
        boolean flag = false;
        if (proceed instanceof JsonResult) {
            JsonResult result = (JsonResult) proceed;
            flag = result.getStatus();
        }

        RefundLog rl = local.get();
        rl.setCreateTime(new Date());
        rl.setStatus(flag ? "1" : "0");
        //TODO 操作日志入库
        System.out.println("RefundLog:" + JSON.toJSONString(rl));
    }

    //可以加一个事件，然后把数据持久化的功能与主业务解耦 undo

}
