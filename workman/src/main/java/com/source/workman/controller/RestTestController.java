package com.source.workman.controller;

import com.source.workman.constants.InterfaceConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzh
 */
@Slf4j
@RestController
@RequestMapping({InterfaceConstant.DEFAULT_CONTROLLER_PREFIX + "/nodes"})
public class RestTestController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String test() {
        log.info("rest test controller,invoke test method");
        return InterfaceConstant.DEFAULT_CONTROLLER_PREFIX;
    }

    /**
     * localhost:8080/helloworld/nodes/aa
     *
     * @param str
     * @return
     */
    @RequestMapping(value = "/{str}", method = RequestMethod.GET)
    public String test1(@PathVariable String str) {
        log.info("rest test controller,invoke test method,param={}", str);
        return InterfaceConstant.DEFAULT_CONTROLLER_PREFIX + ": " + str;
    }

}
