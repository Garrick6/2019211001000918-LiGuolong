<%--
  Created by IntelliJ IDEA.
  User: 26707
  Date: 2021/4/7
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<h1>User List</h1>
<table border="1">
    <tr>
        <td>Id</td><td>Username</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthday</td>
    </tr>
    <%
        //从请求属性中获取rs
        ResultSet rs = (ResultSet) request.getAttribute("rsName");//属性的名称
        if(rs==null){
    %>
    <tr>
        <td>No Date!!!</td>
    </tr>
    <%}else {
            while(rs.next()) {
                try {
                    out.println("<tr>"+
                                    "<td>" + rs.getString("id")    + "</td>" +
                                    "<td>" + rs.getString("UserName") + "</td>" +
                                    "<td>" + rs.getString("Password")  + "</td>" +
                                    "<td>" + rs.getString("Email")     + "</td>" +
                                    "<td>" + rs.getString("Gender")   + "</td>" +
                                    "<td>" + rs.getString("BirthDate")+ "</td>"+
                                    "</tr>"
                                    );
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
    }
    %>
</table>
<%@include file="footer.jsp"%>
