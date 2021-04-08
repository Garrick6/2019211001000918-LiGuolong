<%--
  Created by IntelliJ IDEA.
  User: 26707
  Date: 2021/3/14
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
This is my register JSP page <br>
<form style="text-align: center" method="post" action="register">
    <h2>Register</h2>
    username<label><input type="text" name="username"/></label><br/>
    password<label><input type="password" name="password"/></label><br/>
    Email<label><input type="text" name="email"/></label><br/>
    Gender: <label><input type="radio" name="gender" value="male"></label>
    Male <label><input type="radio" name="gender" value="female"></label>Female<br/>
    Date of Birth:<label><input type="text" name="birthDate"></label><br/>
    <input type="submit" value="Register"/>

</form>
<%@include file="footer.jsp"%>