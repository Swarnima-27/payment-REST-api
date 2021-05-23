package com.basic.paymentapp.CustomFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class Filter1 implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }

    private static final Logger log= LoggerFactory.getLogger(Filter1.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.info("Filetr 1 working");
        long time=System.currentTimeMillis();
        log.info("time 1 : " + System.currentTimeMillis());
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("time 2 : " + System.currentTimeMillis());
        log.info("{} : {} ms" ,((HttpServletRequest) servletRequest).getRequestURI(),System.currentTimeMillis()-time);
    }

//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
}
