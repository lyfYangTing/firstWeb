<%--
  Created by IntelliJ IDEA.
  User: 18435
  Date: 2017/7/5
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
  <head>
    <title>��һ��web��Ŀ</title>
  </head>
  <body>
     <font color='red' >${requestScope.result}</font>
     <form action="loginServlet.do?op=login" method="post">
           �û�����<input type="text" name="username">
           ��  �룺<input type="password" name="password">
           <input type="submit" value="�ύ">
     </form>
  </body>
</html>