package com.source.workman.designMode.chain.filter;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult<T> implements Serializable {
    private boolean status;
    private String msg;
    private T data;
    private String code;

    public JsonResult() {
    }

    public JsonResult(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public JsonResult(boolean status, String msg, T data, String code) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.code = code;
    }
}
