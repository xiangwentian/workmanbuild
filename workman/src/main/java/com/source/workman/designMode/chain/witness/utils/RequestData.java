package com.source.workman.designMode.chain.witness.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

//@Component
@Data
public class RequestData<T> {
    private T data;
    String channel;
}
