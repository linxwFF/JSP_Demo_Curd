<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>ɾ��ѧ����Ϣ</title>
<style type="text/css">
<!--
.style1 {color: #FF0000}
.style3 {color: #0000FF}
-->
</style>
</head>
<body>
<%   request.setCharacterEncoding("gb2312"); 
     response.setCharacterEncoding("gb2312"); 
     Class.forName("org.gjt.mm.mysql.Driver").newInstance(); 
     String url ="jdbc:mysql://localhost:3306/test1?user=root&password=123&useUnicode=true&characterEncoding=gbk" ;
     Connection conn= DriverManager.getConnection(url);   
     Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
%>
<center> <h2 class="style1">ɾ��ѧ����Ϣ</h2>
<br>
<form name="form1" method="post" action="delete_1.jsp">
<p><span class="style3">��ѡ��Ҫɾ����ѧ��������:</span>      
<select name="id">
<% ResultSet rs = stmt.executeQuery("SELECT * FROM stu_info");
   while(rs.next())
  {
     String name=rs.getString("name");
  %>
  <option value="<%=name%>"><%=name%></option>
  <%}
rs.close(); //�ر�ResultSet����
stmt.close(); //�ر�Statement����
conn.close(); //�ر�Connection����
  %>
 </select>
  </p>
  <p>
    <input type="submit"  name="queding" value="ȷ��">
&nbsp;
<input name="back" type="button" id="back" value="����" onClick="javascript:history.go(-1)">
  </p>
</form>
</center>

</body>
</html>
