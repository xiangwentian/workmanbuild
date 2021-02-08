package com.workman.service.impl;

import com.workman.service.iHelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "${dubbo.service.version}")
public class HelloServiceImpl implements iHelloService {

    @Value("${spring.application.name}")
    private String serviceName;

    public String sayHello(String name) {
        return String.format("%s : Hello , %s", serviceName, name);
    }
}
