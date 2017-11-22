package com.utils;

import com.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by LINxwFF on 2017/11/22.
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获得在下面代码中要用的request,response,session对象
        HttpServletRequest Request = (HttpServletRequest) servletRequest;
        HttpServletResponse Response = (HttpServletResponse) servletResponse;
        HttpSession session = Request.getSession();

        // 获得用户请求的URI
        String path = Request.getRequestURI();

        // 登陆页面无需过滤
        if(path.indexOf("/Login.jsp") > -1 || path.indexOf("/Register.jsp") > -1 ||path.indexOf("/user") > -1){
            filterChain.doFilter(Request,Response);
            return;
        }

        // 获取登录信息
        // 判断如果没有取到信息,就跳转到登陆页面
        if (session.getAttribute("current_user") == null ) {
            // 跳转到登陆页面
            Request.setAttribute("msg","操作商品需登录系统");
            Request.getRequestDispatcher("/Login.jsp").forward(Request,Response);
        } else {
            User user = (User) session.getAttribute("current_user");
            if( user.getRole() == 2 ){
                Request.setAttribute("msg","操作商品需要管理员权限");
                Request.getRequestDispatcher("/Login.jsp").forward(Request,Response);
            }else{
                // 已经登陆,继续此次请求
                filterChain.doFilter(Request, Response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
