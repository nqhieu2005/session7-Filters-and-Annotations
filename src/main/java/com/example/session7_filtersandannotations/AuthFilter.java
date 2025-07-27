package com.example.session7_filtersandannotations;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/upload")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String token = httpRequest.getParameter("token");

        if("secret".equals(token)){
            filterChain.doFilter(httpRequest, httpResponse);
        } else {
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token không hợp lệ");
        }
    }
}
