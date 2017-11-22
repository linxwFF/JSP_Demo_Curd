package com.controller;

import com.pojo.User;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LINxwFF on 2017/11/21.
 */
public class UserServlet extends javax.servlet.http.HttpServlet {

    private UserService userService = new UserService();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String method = (String) request.getParameter("method");
        User user = new User();

        if(method.equals("login")){
            user.setName(request.getParameter("name"));
            user.setPassword(request.getParameter("password"));
            if(request.getParameter("role") == null){
                user.setRole(0);
            }else{
                user.setRole(Integer.valueOf(request.getParameter("role")));
            }
            Login(request,response,user);
            return;
        }

        if(method.equals("register")){
            user.setNickname(request.getParameter("nickname"));
            user.setName(request.getParameter("name"));
            user.setPassword(request.getParameter("password"));
            user.setConfirmPassword(request.getParameter("confirmPassword"));
            if(request.getParameter("gender") == null){
                user.setGender(0);
            }else {
                user.setGender(Integer.valueOf(request.getParameter("gender")));
            }
            if(request.getParameter("role") == null){
                user.setRole(0);
            }else{
                user.setRole(Integer.valueOf(request.getParameter("role")));
            }
            user.setEmail(request.getParameter("email"));
            user.setTel(request.getParameter("tel"));

            Register(request,response, user);
            return;
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //退出用户
        String method = request.getParameter("method");
        if(method.equals("logout")){
            logout(request,response);
        }
    }

    //登录
    public void Login(HttpServletRequest request, HttpServletResponse response,User user) throws ServletException, IOException {
        //验证
        Map<String,String> errorMap = validateLogin(user);
        if(errorMap.size() > 0){
            request.setAttribute("errorMap",errorMap);
            //转发
            request.getRequestDispatcher("/Login.jsp").forward(request,response);
        }else{
            //登录
            User result = userService.Login(user.getName(),user.getPassword());
            if(result != null){
                request.getSession().setAttribute("current_user",result);
                //跳转到 productServlet的post方法中
                response.sendRedirect("/product?method=list");
            }else{
                //转发
                request.setAttribute("msg","密码或者用户名错误，请重新输入正确用户名和密码");
                request.getRequestDispatcher("/Login.jsp").forward(request,response);
            }
        }
    }

    //注册
    public void Register(HttpServletRequest request,HttpServletResponse response,User user) throws ServletException, IOException {
        //验证
        Map<String,String> errorMap = validateRegister(user);
        if(errorMap.size() > 0){
            request.setAttribute("errorMap",errorMap);
            //转发
            request.getRequestDispatcher("/Register.jsp").forward(request,response);
        }else{
            //存储数据库
            if(userService.Register(user)){
                //成功 1.存储session 2.直接跳转到登录
//                request.getSession().setAttribute("current_user",user);
                request.setAttribute("msg","注册成功");
                request.getRequestDispatcher("/Login.jsp").forward(request,response);
            }else{
                request.setAttribute("msg","注册失败");
                request.getRequestDispatcher("/Register.jsp").forward(request,response);
            }
        }
    }

    //登录验证
    private Map<String,String> validateLogin(User user)
    {
        Map<String,String> errorMap = new HashMap<String, String>();

        //校验
        if(user.getName().trim().isEmpty() || user.getName() == null)
        {
            errorMap.put("name","用户名不能为空");
        }else if(user.getPassword().trim().isEmpty() || user.getPassword() == null){
            errorMap.put("password","密码不能为空");
        }else if(user.getRole() == 0){
            errorMap.put("role","未选择角色");
        }

        return errorMap;
    }

    //注册验证
    private Map<String,String > validateRegister(User user)
    {
        Map<String,String> errorMap = new HashMap<String, String>();

        //校验
        //是否是已经注册过的用户
        if(userService.validateAlreadyRegister(user.getName())){
            errorMap.put("name","用户名已经注册过了");
        }else if(user.getName().trim().isEmpty() || user.getName() == null){
            errorMap.put("name","用户名不能为空");
        }else if(user.getPassword().trim().isEmpty() || user.getPassword() == null){
            errorMap.put("password","密码不能为空");
        }else if(user.getNickname().trim().isEmpty() || user.getNickname() == null){
            errorMap.put("nickname","昵称不能为空");
        }else if(user.getConfirmPassword().trim().isEmpty() || user.getConfirmPassword() == null){
            errorMap.put("confirmPassword","确认密码不能为空");
        }else if(!user.getConfirmPassword().equals(user.getPassword())){
            errorMap.put("confirmPassword","两次密码输入不一致");
        }else if(user.getGender() == 0){
            errorMap.put("gender","未选择性别");
        }else if(user.getRole() == 0){
            errorMap.put("role","未选择角色");
        }else if(user.getEmail().trim().isEmpty() || user.getEmail() == null){
            errorMap.put("email","邮箱不能为空");
        }else if(user.getTel().trim().isEmpty() || user.getTel() == null ){
            errorMap.put("tel","手机号码不得为空");
        }

        return errorMap;
    }

    //退出用户
    public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("current_user",null);
        response.sendRedirect("/Login.jsp");
    }
}
