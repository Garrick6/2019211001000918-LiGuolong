<%--
  Created by IntelliJ IDEA.
  User: 26707
  Date: 2021/4/3
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<form style="text-align: center" method="post" action="http://localhost:8080/2019211001000918_LiGuolong_war_exploded/login">
    <h2>Login</h2>
    username:<label><input type="text" name="username"/></label><br/>
    password:<label><input type="password" name="password"/></label><br/>
    <input type="submit" value="Login"/>

</form>
<%@ include file="footer.jsp"%>