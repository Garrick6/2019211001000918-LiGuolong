<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp"%>
<h1>Welcome to My Online Shop Home Page</h1>
<form method="get" target="_blank" action="http://localhost:8080/2019211001000918_LiGuolong_war_exploded/search">
    <label>
        <input type="text" name="txt" size="=30/">
            <select name="search">
                <option value="baidu">Baidu</option>
                <option value="bing">Bing</option>
                <option value="google">Google</option>
            </select>
        <input type="submit" value="Search"/>
    </label>
</form>


<%@include file="footer.jsp"%>