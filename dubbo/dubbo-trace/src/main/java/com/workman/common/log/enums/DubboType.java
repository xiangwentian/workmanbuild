package com.workman.common.log.enums;

/**
 * Description:
 *
 * @author gan bing
 * @version V1.0
 * @date 2018-06-08 16:40
 */
public enum DubboType {

    PROVIDER("Provider"),
    CONSUMER("Consumer");
    private String type;
    DubboType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}
