package com.source.workman.string;

/**
 * @author liuzh
 */
public class SwitchTest {

    public static final String start = "1";
    public static final String end = "0";

    public String switchT(String state) {
        switch (state) {
            case start:
                System.out.println("state: start");
                return "start";
            case end:
                System.out.println("state: end");
                return "end";
        }
        return null;
    }

    public static void main(String[] args) {
        SwitchTest st = new SwitchTest();
        st.switchT(start);
        st.switchT(end);
        System.out.println(st.switchT(""));
    }
}
