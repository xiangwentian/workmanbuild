package com.workman.trace.dubbo.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.workman.common.log.context.TraceContext;
import com.workman.common.log.enums.DubboType;
import com.workman.common.log.util.TraceUtils;

/**
 * Description:
 *
 * @author gan bing
 * @version V1.0
 * @date 2018-05-24 10:39
 */
@Activate(group = Constants.PROVIDER, order = -10001)
public class ProviderTraceFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        TraceUtils.traceDubbo(invocation, DubboType.PROVIDER);
        try {
            return invoker.invoke(invocation);
        } finally {
            TraceContext.clear();
        }
    }
}
