package com.workman.common.log.context;

import com.workman.common.log.constants.TraceConstants;
import org.slf4j.MDC;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author gan bing
 * @version V1.0
 * @date 2018-05-24 14:09
 */
public final class TraceContext {

    private TraceContext() {
    }

    public static String getTraceId() {
        return MDC.get(TraceConstants.X_COMMON_TRACE_ID);
    }

    public static void setTraceId(String traceId) {
        MDC.put(TraceConstants.X_COMMON_TRACE_ID, traceId);
        MDC.put(TraceConstants.X_COMMON_TRACE_ID_LOG, "-traceId-" + traceId + "-#");
    }

    public static Map<String, String> getContextMap() {
        return MDC.getCopyOfContextMap();
    }

    public static void setContextMap(Map<String, String> contextMap) {
        if (contextMap == null) {
            contextMap = new HashMap<String, String>();
        }
        MDC.setContextMap(contextMap);
    }

    public static void clear() {
        MDC.remove(TraceConstants.X_COMMON_TRACE_ID);
        MDC.remove(TraceConstants.X_COMMON_TRACE_ID_LOG);
    }

    public static void clearAll() {
        MDC.clear();
    }
}
