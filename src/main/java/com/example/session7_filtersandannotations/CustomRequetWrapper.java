package com.example.session7_filtersandannotations;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class CustomRequetWrapper extends HttpServletRequestWrapper {
    public CustomRequetWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getHeader(String name) {
        if("X-Custom-Header".equals(name)){
            return "CustomValue";
        }
        return super.getHeader(name);
    }
}
