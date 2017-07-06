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
    <title>第一个web项目</title>
  </head>
  <body>
     <font color='red' >${requestScope.result}</font>
     <form action="loginServlet.do?op=login" method="post">
           用户名：<input type="text" name="username">
           密  码：<input type="password" name="password">
           <input type="submit" value="提交">
     </form>
  </body>
</html>
