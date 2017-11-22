<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title> 商品模块 </title>
    <style type="text/css">

        body {
            background-color: #FFFFCC;
        }
        td
        {
            text-align:center;
        }
    </style>
</head>
<body>
<div align="center" class="style1">
    <p class="style3">使用JSP技术构建B/S结构的商品信息管理系统
    </p>
    <span style="color:red;">${msg}</span>
    <a href="/user?method=logout">退出系统</a>
    <p align="center" class="style4">请选择操作:</p>
    <p align="center" class="style2">
        <a href="add.jsp">添加商品 </a> &nbsp;&nbsp;&nbsp;
        <a href="/product?method=query">查询商品</a>&nbsp;&nbsp;&nbsp;
    </p>
    <table  width="800" border="1" cellspacing="0" cellpadding="0">
        <th>id</th>
        <th>商品货号</th>
        <th>商品名称</th>
        <th>型号规格</th>
        <th>商品数量</th>
        <th>生产日期</th>
        <th>保质期</th>
        <th>生产厂家</th>
        <th>供货商</th>
        <th>操作</th>

        <c:forEach items="${list}" var="product" varStatus="vs">
        <tr>
            <td>${product.id}</td>
            <td>${product.uuid}</td>
            <td>${product.name}</td>
            <td>${product.ts}</td>
            <td>${product.quantity}</td>
            <td>${product.date_of_manufacture}</td>
            <td>${product.shelf_life} 月</td>
            <td>${product.vendor}</td>
            <td>${product.supplier}</td>
            <td>

                <a href = "/product?method=modify&id=${product.id}">修改 </a>&nbsp;&nbsp;&nbsp;
                <a href = "/product?method=delete&id=${product.id}">删除</a>
            </td>
        </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
