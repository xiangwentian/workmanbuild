package com.source.workman.designMode.chain.filter;

public class FilterTwo implements Filter<FilterBean> {
    @Override
    public void doFilter(FilterBean theClass, FilterChain chain) {

        if (theClass.getChannel().equals("2")) {
            System.out.println("FilterTwo = " + theClass.getChannel());
            theClass.setResult("success");
            return;
        } else {
            System.out.println("FilterOne not work,next filter ");
        }

        chain.doFilter(theClass, chain);
        System.out.println("FilterTwo end");
    }
}
