<%@ page import="com.LiGuolong.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 26707
  Date: 2021/4/8
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h2>User Info</h2>
<%
    User user= (User) session.getAttribute("user");
%>
<table>
    <tr>
        <td>Username</td><td><%=user.getUsername()%></td>
    </tr><tr>
    <td>Password</td><td><%=user.getPassword()%></td>
</tr><tr>
    <td>Email</td><td><%=user.getEmail()%></td>
</tr><tr>
    <td>Gender</td><td><%=user.getGender()%></td>
</tr><tr>
    <td>Birthdate</td><td><%=user.getBirthDate()%></td>
</tr><tr>
    <td><a href='updateUser'>Update User</a></td>
</tr>
</table>
<%@include file="footer.jsp"%>
