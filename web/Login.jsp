<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title> 登录 </title>
<style type="text/css">
<!--
.style1 {
	font-size: 24px;
	color: #FF0000;
}
.style2 {
	font-size: 16px;
	color: #0033FF;
}
.style3 {font-size: 36px}
.style4 {
	font-size: 24px;
	color: #FF66CC;
}
body {
	background-color: #FFFFCC;
}
-->
</style>
</head>
<body>
<div align="center" class="style1">
  <p align="center" class="style2">
    <a href="Register.jsp">注册系统</a>
    <p>登录系统</p>
    <span style="color: red">${msg}</span>
    <form name="form1" method="post" action="/user" >
        <input type="hidden" name="method" value="login">
        <p><span class="style3">用户名：</span>
            <input type="text"  name="name" value="admin">
            <p style="color:red">${errorMap.name}</p>
        </p>
        <p><span class="style3">密码：</span>
            <input type="password" name=password value="admin">
        <p style="color:red">${errorMap.password}</p>
        </p>
        <p><span class="style3">角色：</span>
            <input type="radio" value="1" name="role" checked> 普通用户 <br>
            <input type="radio" value="2" name="role"> 管理员 <br>
        <p style="color:red">${errorMap.role}</p>
        </p>
        <p>
            &nbsp;
            <input type="submit" value="提交">
            &nbsp;
            <input type="reset" value="重置">
        </p>
    </form>
  </p>
</div>
</body>
</html>