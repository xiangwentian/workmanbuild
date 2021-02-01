package com.source.workman.designMode.chain.filter;

public class Main {
    public static void main(String[] args) {
        FilterBean bean = new FilterBean();
        bean.setChannel("2");

        FilterChain fc = FilterChain.getInstance();
        fc.addFilter(new FilterOne()).addFilter(new FilterTwo());
        fc.doFilter(bean, fc);

        System.out.println("result:" + bean.getResult());

    }
}
