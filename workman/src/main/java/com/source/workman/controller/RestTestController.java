package com.source.workman.controller;

import com.source.workman.constants.InterfaceConstant;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzh
 */
@RestController
@RequestMapping({InterfaceConstant.DEFAULT_CONTROLLER_PREFIX + "/nodes"})
public class RestTestController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String test() {
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
        return InterfaceConstant.DEFAULT_CONTROLLER_PREFIX + ": " + str;
    }

}
