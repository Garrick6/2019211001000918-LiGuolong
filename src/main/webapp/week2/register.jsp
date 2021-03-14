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
<form style="text-align: center" method="post">
    <h1>New User Registration!</h1>
    <label for="UserName">UserName</label><br/>
    <input type="text" name="Username" id="UserName" placeholder="Please input username" required autofocus><br/>
    <label for="Password">PassWord</label><br/>
    <input type="Password" name="Password" id="Password" placeholder="Please input Password" required autofocus minlength="8"><br/>
    <label for="Email">Email</label><br/>
    <input type="text" name="Email" id="Email" placeholder="Please input Email" required autofocus><br/>
    <label>
        Gender
        <input type="radio" name="sex" value="Male" checked/>
    </label>Mate
    <label>
        Mate
        <input type="radio" name="sex" value="Female" checked/>
    </label>Female<br>
    <label for="BirthDate">BirthDate</label><br/>
    <input id="BirthDate" name="BirthDate" placeholder="Day of Birth (yyyy-mm-dd)" type="text"><br/>
    <input type="submit" value="Register"/><br>

</form>
</body>

</html>