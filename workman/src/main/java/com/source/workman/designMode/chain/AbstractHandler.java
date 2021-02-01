package com.source.workman.designMode.chain;

public abstract class AbstractHandler {
    Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
