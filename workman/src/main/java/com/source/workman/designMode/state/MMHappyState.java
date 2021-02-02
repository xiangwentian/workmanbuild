package com.source.workman.designMode.state;

public class MMHappyState extends MMState {
    @Override
    void smile() {
        System.out.println("mm happy smile");
    }

    @Override
    void cry() {
        System.out.println("mm happy cry");
    }

    @Override
    void say() {
        System.out.println("mm happy say");
    }
}
