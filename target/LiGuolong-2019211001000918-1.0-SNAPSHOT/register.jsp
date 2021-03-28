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
    username<label><input type="text" name="username"/></label><br/>
    password<label><input type="password" name="password"/></label><br/>
    Email<label><input type="text" name="email"/></label><br/>
    Gender: <label><input type="radio" name="gender" value="male"></label>
    Male <label><input type="radio" name="gender" value="female"></label>Female<br/>
    Date of Birth:<label><input type="text" name="birthDate"></label><br/>
    <input type="submit" value="Register"/>

</form>
</body>

</html>