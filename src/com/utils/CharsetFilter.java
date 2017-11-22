package com.utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by LINxwFF on 2017/11/21.
 */
public class CharsetFilter implements Filter {
    private String CharsetEncoding;
    FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //配置的encoding
        CharsetEncoding = filterConfig.getInitParameter("encoding");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //请求编码
        request.setCharacterEncoding(CharsetEncoding);
        //响应编码
        response.setContentType("text/html;charset=utf-8");

        //对request进行包装
        CharacterRequest characterRequest = new CharacterRequest(request);

        filterChain.doFilter(characterRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}


class CharacterRequest extends HttpServletRequestWrapper{
    private HttpServletRequest request;

    public CharacterRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    public String getParameter(String name){
        String value = super.getParameter(name);
        if(value == null) return null;
        String method = super.getMethod();
        if("get".equalsIgnoreCase(method)){
            try {
                value = new String(value.getBytes("iso-8859-1"), "utf-8");
            }catch (UnsupportedEncodingException e){
                throw new RuntimeException(e);
            }
        }
        return value;
    }
}