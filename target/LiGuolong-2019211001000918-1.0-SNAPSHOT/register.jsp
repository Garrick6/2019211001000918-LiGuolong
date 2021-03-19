<%--
  Created by IntelliJ IDEA.
  User: 26707
  Date: 2021/3/14
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<html>

<head>
    <title>
        Registration
    </title>
    <style type="text/css">
        body {background-color:lightgoldenrodyellow}
    </style>
    <script>
    function myFunction()
    {
        document.getElementById("demo").innerHTML="我的第一个 JavaScript 函数";
    }
</script>
</head>
<body>
<form style="text-align: center" method="post" action="http://localhost:8080/2019211001000918_LiGuolong_war_exploded/register">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender: <input type="radio" name="gender" value="male">Male <input type="radio" name="gender" value="female">Female<br/>
    Date of Birth: <input type="text name=" name="birthDate"><br/>
    <input type="submit" value="Register"/>

</form>
</body>

</html>