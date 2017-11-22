<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title> 注册 </title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta charset="utf-8">
</head>
<style>

  .main{
    padding: 20px 100px;
    background-color: coral;
  }
  tr{
    display:block; /*将tr设置为块体元素*/
    margin:10px 0;
  }
  .title{
    background-color: darkorange; text-align: center; height: 40px; line-height: 40px;
  }
  .sub{
    width: 100px;height: 30px;
  }

</style>

<body>
<div class="main">
  <div style="background-color: aliceblue;">
    <div class="title">
      请完成以下表格（注册）
      ${msg}
      <a href="Login.jsp">登录系统</a>
    </div>
    <form action="/user" method="post">
      <input type="hidden" name="method" value="register">
      <table>
        <tr>
          <td width="200" align="right">昵称：</td>
          <td width="300"><input type="text" name="nickname" value="admin"/><br/></td>
          <td width="300"><span style="color: red;">${errorMap.nickname}</span></td>
        </tr>

        <tr>
          <td width="200" align="right">姓名：</td>
          <td width="300"><input type="text" name="name" value="admin"/><br/></td>
          <td width="300"><span style="color: red;">${errorMap.name}</span></td>
        </tr>

        <tr>
          <td width="200" align="right">密码：</td>
          <td width="300"><input type="password" name="password" value="admin"/></td>
          <td width="300"><span style="color: red;">${errorMap.password}</span></td>
        </tr>

        <tr>
          <td width="200" align="right">确认密码：</td>
          <td width="300"><input type="password" name="confirmPassword" value="admin"/></td>
          <td width="300"><span style="color: red;">${errorMap.confirmPassword}</span></td>
        </tr>

        <tr>
        <td width="200" align="right">性别：</td>
        <td width="300">
          <input type="radio" name="gender" value="1" checked/>男
          <input type="radio" name="gender" value="2"/>女
        </td>
          <td width="300"><span style="color: red;">${errorMap.gender}</span></td>
      </tr>

      <tr>
        <td width="200" align="right">角色：</td>
        <td width="300">
          <input type="radio" name="role" value="1" checked/>普通用户
          <input type="radio" name="role" value="2"/>管理员
        </td>
        <td width="300"><span style="color: red;">${errorMap.role}</span></td>
      </tr>

        <tr>
          <td width="200" align="right">电子邮箱地址：</td>
          <td width="300"><input type="text" name="email" value="874226876@qq.com"/></td>
          <td width="300"><span style="color: red;">${errorMap.email}</span></td>
        </tr>

        <tr>
          <td width="200" align="right">手机：</td>
          <td width="300"><input type="text" name="tel" value="13774545206"/></td>
          <td width="300"><span style="color: red;">${errorMap.tel}</span></td>
        </tr>
        </table>
      <div class="title">
        （填写完成后，选择下面的提交按钮提交表单）
      </div>
      <div style="margin-left: 300px;margin-top: 3px;margin-bottom: 3px;">
        <input type="submit" value="提交" class="sub" />
        <input type="reset" value="重置" class="sub" />
      </div>

    </form>
  </div>
</div>
</body>
</html>
