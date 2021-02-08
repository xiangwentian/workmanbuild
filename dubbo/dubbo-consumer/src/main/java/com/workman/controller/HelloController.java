package com.workman.controller;

import com.workman.service.inner.IHello;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping(value = "hello")
@RestController
public class HelloController {

    @Resource(name = "iHello")
    private IHello iHello;

    @RequestMapping(value = "/{name}")
    public String hello(@PathVariable String name) {
        return iHello.sayHello(name);
    }
}
