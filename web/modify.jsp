<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" import="java.sql.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改</title>
<style type="text/css">
<!--
.style1 {
	color: #FF0000;
	font-size: 24px;
}
.style3 {font-size: 16px}
-->
</style>
</head>
<body>

<br>
<div align="center" class="style1">
  <p>修改学生信息</p>
  <form name="form1" method="post" action="/product?method=update">
      <input type="hidden"  name="id" value="${product.id}">

      <p><span class="style3">商品货号：</span>
          <input type="text"  name="uuid" value="${product.uuid}">
      </p>
      <p><span class="style3">商品名称：</span>
          <input type="text" name="name" value="${product.name}">
      </p>
      <p><span class="style3">型号规格：</span>
          <input type="text" name="ts" value="${product.ts}">
      </p>
      <p><span class="style3">商品数量：</span>
          <input type="text" name="quantity" value="${product.quantity}">
      </p>
      <p><span class="style3">生产日期：</span>
          <input type="text" name="date_of_manufacture" value="${product.date_of_manufacture}">
      </p>
      <p><span class="style3">保质期：</span>
          <input type="text" name="shelf_life" value="${product.shelf_life}">个月
      </p>
      <p><span class="style3">生产厂家：</span>
          <input type="text" name="vendor" value="${product.vendor}">
      </p>
      <p><span class="style3">供货商：</span>
          <input type="text" name="supplier" value="${product.supplier}">
      </p>
    <p>
      &nbsp;
      <input type="submit" value="提交">
      &nbsp;
      <input type="button"  value="返回" onClick="javascript:history.go(-1)">
</p>
    <p>&nbsp;    </p>
  </form>
  <p>&nbsp;  </p>
</div>

</body>
</html>
