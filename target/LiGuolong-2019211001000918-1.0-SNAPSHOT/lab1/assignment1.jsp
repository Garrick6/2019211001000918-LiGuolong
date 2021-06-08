<%@ page import="com.lab1.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lab1.Dog" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 9:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assignment1</title>
</head>
<body>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<h2> c:forEach loog to print 1 to 10</h2>

    <ul>
        <c:forEach var="i" begin="1" end="10">
        <li>${i}</li>
        </c:forEach>
    </ul>
<%--。   使用<%@taglib%>指令包含JSTL核心库。
        使用<c:forEach>标记向下循环固定的次数
        使用<C:ForEach>标签从集合中获取项目
        使用<C:forTokens>从分隔字符串中获取单词1。--%>
    <%-- todo 1 : run assignement1.jsp  --%>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%-- todo 2 : use c:forEach to print list 1,3,5,7,9   --%>
        <h2> c:forEach to print list 1,3,5,7,9</h2>

        <ul>
            <c:forEach var="i" begin="1" end="9" step="2">
                <li>${i}</li>
            </c:forEach>
        </ul>
   <%-- todo 3 : use c:forEach to print 2,4,6,8,10   --%>
        <h2> c:forEach to print 2,4,6,8,10</h2>

        <ul>
            <c:forEach var="i" begin="2" end="10" step="2">
                <li>${i}</li>
            </c:forEach>
        </ul>

<% String[] words ={"one","two","three","four","five","six","seven","eight","nine","ten"};
   pageContext.setAttribute("words", words);
   pageContext.setAttribute("words2", words);
%>
    <%-- todo 4 : use c:forEach to print all elements of array --%>
        <h2> c:forEach to print all elements of array</h2>

        <ul>
            <c:forEach items="${words}" var="words" >
                <li>${words}</li>
            </c:forEach>
        </ul>
    <%-- todo 5 : use c:forEach to print "one","three","five","seven","nine"  of array --%>
        <h2> c:forEach to print "one","three","five","seven","nine"  of array</h2>
        <ul>
            <c:forEach  items="${words2}" var="words2" begin="0" end="9" step="2">
                <li>${words2}</li>
            </c:forEach>
        </ul>

<%
List<Person> personList=new ArrayList<Person>();
personList.add(new Person("Tom",new Dog("Tommy")));
personList.add(new Person("Sam",new Dog("Sammy")));
// todo 6 : add a new person into PersonList - person name and dog name
    personList.add(new Person("Jim",new Dog("Jimmy")));
request.setAttribute("AllPerson",personList);
%>
<%--//todo 7: use c:forEach to print person name :   and persons' dog name : --%>
        <h2> c:forEach to print person name :   and persons' dog name :</h2>
        <ul>
            <c:forEach  items="${AllPerson}" var="AllPerson">
                <li>${AllPerson.name}-->${AllPerson.dog.name}</li>
            </c:forEach>
        </ul>
<%
    String str="one:two:three-four-five";
    pageContext.setAttribute("str", str);
%>
<%--todo 8 : use c:forToken to print all words --%>
        <h2> c:forToken to print all words</h2>
        <ul>
            <c:forTokens  items="${str}" delims="-:" var="str">
                <li>${str}</li>
            </c:forTokens>
        </ul>
</body>
</html>
