package com.source.workman.designMode.chain.witness.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class ResultData implements Serializable {
    private String msg;
    private String code;

    public ResultData(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public ResultData(String code) {
        this.code = code;
    }

    public ResultData() {
    }
}
