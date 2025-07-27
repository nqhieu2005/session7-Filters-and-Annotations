package com.example.session7_filtersandannotations;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


@WebFilter("/hello")
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        System.out.println("Yêu cầu bắt đầu: " + startTime);
        filterChain.doFilter(servletRequest, servletResponse);
        long endTime = System.currentTimeMillis();
        System.out.println("Yêu cầu kết thúc: " + endTime + "Thời gian xử lý: " + (endTime - startTime) + "ms");
    }
}
