package com.workman.service.inner.impl;

import com.workman.service.inner.IHello;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service(value = "iHello")
public class HelloImpl implements IHello {

    @Reference(version = "${dubbo.service.version}")
    private com.workman.service.iHelloService iHelloService;

    public String sayHello(String name) {
        return iHelloService.sayHello(name);
    }
}
