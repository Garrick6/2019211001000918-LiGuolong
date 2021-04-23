<%--
  Created by IntelliJ IDEA.
  User: 26707
  Date: 2021/4/21
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<%
  User user=(User) session.getAttribute("user");
  if ((request.getAttribute("message")!=null)){
%>
<script type="text/javascript" language="javascript">
  alert("<%=request.getAttribute("message")%>");                                            // 弹出错误信息

  // window.location='login.jsp' ;                            // 跳转到登录界面
</script>
<%
  }
%>
<form style="text-align: center" method="post" action="updateUser">
  <h2> User Update</h2>
  <input type="hidden" name="id" value="<%=user.getId()%>">
  username<label><input type="text" name="username" value="<%=user.getUsername()%>"/></label><br/>
  password<label><input type="password" name="password" value="<%=user.getPassword()%>"/></label><br/>
  Email<label><input type="text" name="email" value="<%=user.getEmail()%>"/></label><br/>
  Gender: <label><input type="radio" name="gender" value="male"<%= "male".equals(user.getGender())?"checked":"" %>></label>
  Male <label><input type="radio" name="gender" value="female"<%= "female".equals(user.getGender())?"checked":"" %>></label>Female<br/>
  Date of Birth:<label><input type="text" name="birthDate" value="<%=user.getBirthDate()%>"></label><br/>
  <input type="submit" value="Save Changes"/>
</form>
<%@include file="footer.jsp" %>