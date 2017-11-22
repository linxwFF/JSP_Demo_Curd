<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加</title>
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
<div align="center" class="style1">
  <p>添加商品信息</p>
  <form name="form1" method="post" action="/product?method=add">
    <p><span class="style3">商品货号：</span>
      <input type="text"  name="uuid" value="10002">
    </p>
    <p><span class="style3">商品名称：</span>
      <input type="text" name="name" value="商品名称">
    </p>
    <p><span class="style3">型号规格：</span>
      <input type="text" name="ts" value="型号规格">
    </p>
    <p><span class="style3">商品数量：</span>
      <input type="text" name="quantity" value="100">
    </p>
    <p><span class="style3">生产日期：</span>
      <input type="text" name="date_of_manufacture" value="2017-11-22 14:53:26">
    </p>
    <p><span class="style3">保质期：</span>
      <input type="text" name="shelf_life" value="18">个月
    </p>
    <p><span class="style3">生产厂家：</span>
      <input type="text" name="vendor" value="生产厂家">
    </p>
    <p><span class="style3">供货商：</span>
      <input type="text" name="supplier" value="供货商">
    </p>
    <p>
      &nbsp;
      <input type="submit" value="提交">
      &nbsp;
      <input type="reset"  value="重置">
</p>
    <p>&nbsp;    </p>
  </form>
  <p>&nbsp;  </p>
</div>
</body>
</html>
