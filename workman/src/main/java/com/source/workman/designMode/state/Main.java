package com.source.workman.designMode.state;

/**
 * 状态模式
 */
public class Main {
    public static void main(String[] args) {
        MMState mmSadState = new MMSadState();
        mmSadState.say();
        mmSadState.cry();
        mmSadState.smile();
    }
}
