<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title> ��Ʒģ�� </title>
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
    <p class="style3">ʹ��JSP��������B/S�ṹ����Ʒ��Ϣ����ϵͳ
    </p>
    <span style="color:red;">${msg}</span>
    <a href="/user?method=logout">�˳�ϵͳ</a>
    <p align="center" class="style4">��ѡ�����:</p>
    <p align="center" class="style2">
        <a href="add.jsp">�����Ʒ </a> &nbsp;&nbsp;&nbsp;
        <a href="/product?method=query">��ѯ��Ʒ</a>&nbsp;&nbsp;&nbsp;
    </p>
    <table  width="800" border="1" cellspacing="0" cellpadding="0">
        <th>id</th>
        <th>��Ʒ����</th>
        <th>��Ʒ����</th>
        <th>�ͺŹ��</th>
        <th>��Ʒ����</th>
        <th>��������</th>
        <th>������</th>
        <th>��������</th>
        <th>������</th>
        <th>����</th>

        <c:forEach items="${list}" var="product" varStatus="vs">
        <tr>
            <td>${product.id}</td>
            <td>${product.uuid}</td>
            <td>${product.name}</td>
            <td>${product.ts}</td>
            <td>${product.quantity}</td>
            <td>${product.date_of_manufacture}</td>
            <td>${product.shelf_life} ��</td>
            <td>${product.vendor}</td>
            <td>${product.supplier}</td>
            <td>

                <a href = "/product?method=modify&id=${product.id}">�޸� </a>&nbsp;&nbsp;&nbsp;
                <a href = "/product?method=delete&id=${product.id}">ɾ��</a>
            </td>
        </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
