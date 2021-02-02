package com.source.workman.designMode.state;

public class MMSadState extends MMState {
    @Override
    void smile() {
        System.out.println("mm sad smile");
    }

    @Override
    void cry() {
        System.out.println("mm sad cry");
    }

    @Override
    void say() {
        System.out.println("mm sad say");
    }
}
