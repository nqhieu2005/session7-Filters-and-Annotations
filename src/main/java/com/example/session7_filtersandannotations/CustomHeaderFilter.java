package com.example.session7_filtersandannotations;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/header")
public class CustomHeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        CustomRequetWrapper wrapper = new CustomRequetWrapper(httpRequest);
        filterChain.doFilter(wrapper, servletResponse);
    }
}
