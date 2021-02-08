package com.workman.common.log.util;

import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.RpcInvocation;
import com.workman.common.log.constants.TraceConstants;
import com.workman.common.log.context.TraceContext;
import com.workman.common.log.enums.DubboType;
import feign.RequestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Description:
 *
 * @author gan bing
 * @version V1.0
 * @date 2018-05-24 14:22
 */
public class TraceUtils {

    /**
     * traceId最短长度
     */
    private final static int MIN_TRACE_ID_LEN = 5;

    public static void traceDubbo(Invocation invocation, DubboType type) {
        String traceId;
        switch (type) {
            case CONSUMER:
                RpcInvocation rpcInvocation = (RpcInvocation) invocation;
                traceId = getDefaultContextTraceId();
                rpcInvocation.setAttachment(TraceConstants.X_COMMON_TRACE_ID, traceId);
                break;
            case PROVIDER:
                traceId = invocation.getAttachment(TraceConstants.X_COMMON_TRACE_ID);
                setDefaultContextTraceId(traceId);
                break;
            default:
                break;
        }
    }

    public static void traceFeign(RequestTemplate requestTemplate) {
        String traceId = getDefaultContextTraceId();
        requestTemplate.header(TraceConstants.X_COMMON_TRACE_ID, traceId);
    }

    public static void traceWeb(HttpServletRequest request, HttpServletResponse response) {
        String traceId = request.getHeader(TraceConstants.X_COMMON_TRACE_ID);
        traceId = setDefaultContextTraceId(traceId);
        response.setHeader(TraceConstants.X_COMMON_TRACE_ID, traceId);
    }

    public static String getDefaultContextTraceId() {
        String traceId = TraceContext.getTraceId();
        if (traceId == null || traceId.length() < MIN_TRACE_ID_LEN) {
            traceId = newTraceId();
        }
        return traceId;
    }

    public static String setDefaultContextTraceId(String traceId) {
        if (traceId == null || traceId.length() < MIN_TRACE_ID_LEN) {
            traceId = getDefaultContextTraceId();
        }
        TraceContext.setTraceId(traceId);
        return traceId;
    }

    public static String newTraceId() {
        //getTraceTime new Date(Long.parseLong(Integer.toBinaryString(Integer.parseInt(TraceUtils.newTraceId().substring(0,8), 16)),2)*1000)
        int random = ThreadLocalRandom.current().nextInt();
        long epochSeconds = System.currentTimeMillis() / 1000;
        return Long.toHexString((epochSeconds & 0xffffffffL) << 32 | (random & 0xffffffffL));
    }
}
