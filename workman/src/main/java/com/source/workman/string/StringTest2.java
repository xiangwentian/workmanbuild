package com.source.workman.string;

/**
 * @author liuzh
 */
public class StringTest2 {
    public String formatTest(String name) {
        String ALIWARE_NACOS_PRODUCT_DOM_TEMPLATE = "nacos.as.%s";
        return String.format(ALIWARE_NACOS_PRODUCT_DOM_TEMPLATE, name);
    }

    public static void main(String[] args) {
        StringTest2 st = new StringTest2();
        String formatRs = st.formatTest("hello");
        System.out.println(formatRs);
    }
}
