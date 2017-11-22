<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询</title>
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
     <p class="style3">查询商品结果</p>
     <a href="/product?method=list">全部的商品信息</a>
     <form name="form1" method="post" action="/product?method=query">
          <p><span class="style3">商品货号或者商品名称查询</span>
               <input type="text"  name="input">
          </p>
          <p>
               &nbsp;
               <input type="submit" value="提交">
               &nbsp;
               <input type="reset"  value="重置">
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
          <c:if test="${queryList.size() == 0}">
               <tr><td colspan="10"> 查无数据 </td></tr>
          </c:if>
          <c:forEach items="${queryList}" var="product">
          <tr>
               <td>${product.id}</td>
               <td>${product.uuid}</td>
               <td>${product.name}</td>
               <td>${product.ts}</td>
               <td>${product.quantity}</td>
               <td>${product.date_of_manufacture}</td>
               <td>${product.shelf_life}</td>
               <td>${product.vendor}</td>
               <td>${product.supplier}</td>
               <td>
                    <a href = "<c:url value='/product?method=modify&id=${product.id}'/>">修改 </a>
                    <a href = "<c:url value='/product?method=delete&id=${product.id}'/>">删除</a>
               </td>
          </tr>
          </c:forEach>
</table>
</div>
</body>
</html>
