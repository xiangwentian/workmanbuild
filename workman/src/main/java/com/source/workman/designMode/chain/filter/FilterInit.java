package com.source.workman.designMode.chain.filter;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class FilterInit {

    @Bean
    public void init() {
        FilterBean bean = new FilterBean();
        bean.setChannel("2");

        FilterChain fc = FilterChain.getInstance();
        fc.addFilter(new FilterOne()).addFilter(new FilterTwo());
        fc.doFilter(bean, fc);
    }
}
