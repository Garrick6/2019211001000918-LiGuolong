<%--
  Created by IntelliJ IDEA.
  User: 26707
  Date: 2021/4/3
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<%
    if ((request.getAttribute("message")!=null)){
%>
<script type="text/javascript" language="javascript">
    alert("<%=request.getAttribute("message")%>");                                            // 弹出错误信息

    // window.location='login.jsp' ;                            // 跳转到登录界面
</script>
<%
    }
    Cookie[] allCookies=request.getCookies();
    String username="",password="",ch="";
    if (allCookies!=null){
        for (Cookie c:allCookies){
            if (c.getName().equals("cUsername")){
                username=c.getValue();
                ch="checked";
            }
            if (c.getName().equals("cPassword")){
                password=c.getValue();
            }
        }

    }
%>
<form style="text-align: center" method="post" action="login">
    <h2>Login</h2>
    username:<label><input type="text" name="username" value="<%=username%>"/></label><br/>
    password:<label><input type="password" name="password" value="<%=password%>"/></label><br/>
    <input type="checkbox" name="rememberMe" value="1" <%=ch%>checked/>RememberMe<br/>
    <input type="submit" value="Login"/>
</form>
<%@ include file="footer.jsp"%>