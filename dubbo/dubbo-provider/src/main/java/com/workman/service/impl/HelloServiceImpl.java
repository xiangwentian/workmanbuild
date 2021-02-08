package com.workman.service.impl;

import com.workman.common.log.context.TraceContext;
import com.workman.common.log.util.TraceUtils;
import com.workman.service.iHelloService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "${dubbo.service.version}")
public class HelloServiceImpl implements iHelloService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.application.name}")
    private String serviceName;

    public String sayHello(String name) {
        LOGGER.info("===================================================");
        String traceId = TraceContext.getTraceId();
        if (null == traceId) {
            LOGGER.info("traceId is null");
            TraceContext.setTraceId(TraceUtils.newTraceId());
            traceId = TraceContext.getTraceId();
        }
        LOGGER.info("{},HelloServiceImpl,{}", traceId, name);
        LOGGER.info("===================================================");
        testTraceId();
        return String.format("%s : Hello , %s", serviceName, name);
    }

    private void testTraceId() {
        String traceId = TraceContext.getTraceId();
        LOGGER.info("{},testTraceId,{}", traceId);
    }
}
