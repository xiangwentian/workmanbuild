package com.workman.service.inner.impl;

import com.workman.common.log.context.TraceContext;
import com.workman.service.inner.IHello;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(value = "iHello")
public class HelloImpl implements IHello {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Reference(version = "${dubbo.service.version}")
    private com.workman.service.iHelloService iHelloService;

    public String sayHello(String name) {
        String traceId = TraceContext.getTraceId();
        log.info("{},HelloImpl sayHello,name={}", traceId, name);
        return iHelloService.sayHello(name);
    }
}
