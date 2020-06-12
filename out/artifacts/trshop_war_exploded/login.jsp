<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

    <script>
        function check() {
            var username = $("#username").val();
            var password = $("#password").val();
            //alert(username);
            //alert(password);
            if(username == "" || password == ""){
                $("#message").text("账户密码不能为空!");
                return false;
            }
            return true;
        }

    </script>
</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">游客登录</div>
    <!--提示信息-->
    <font color="red">
        <span id="message">${msg}</span>
    </font>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form" action="${pageContext.request.contextPath}/login"
          onsubmit="return check()">
        <input name="username" id="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
        <hr class="hr15">
        <input name="password" id="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
        <hr class="hr15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20" >
    </form>
</div>




<!-- 底部结束 -->

</body>
</html>