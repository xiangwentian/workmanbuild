package com.workman.controller;

import com.workman.common.log.context.TraceContext;
import com.workman.common.log.util.TraceUtils;
import com.workman.service.inner.IHello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping(value = "hello")
@RestController
public class HelloController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "iHello")
    private IHello iHello;

    @RequestMapping(value = "/{name}")
    public String hello(@PathVariable String name) {
        String traceId = TraceUtils.newTraceId();
        TraceContext.setTraceId(traceId);
        LOGGER.info("===================================================");
        LOGGER.info("{},HelloController,{}", traceId, name);
        LOGGER.info("===================================================");
        return iHello.sayHello(name);
    }
}
