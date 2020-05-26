
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎登录后台管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });
    </script>

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">


<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录后台管理界面平台</span>
</div>

<div class="loginbody">

    <span class="systemlogo"></span>
    <br/>
    <% Object log = request.getAttribute("rinima");
        if ("log".equals(log)){
            %>
    <div style="text-align: center;">
        <span style="font-size: 15px;color: darkred;font-weight: bold;">用户名或密码错误</span >
    </div>
    <%
        }
    %>
    <% Object change = session.getAttribute("rinima");
        if("change".equals(change)){
            %>
             <div style="text-align: center;">
                <span style="font-size: 15px;color: darkred;font-weight: bold;">密码修改成功</span>
            </div>
    <%
        }
    %>
    <% Object reg = session.getAttribute("rinima");
    if ("reg".equals(reg)){
        %>
    <div style="text-align: center;">
        <span style="font-size: 15px;color: darkred;font-weight: bold;">注册成功</span>
    </div>
    <%
    }
    %>
    <c:remove var="flage" scope="session"/>
    <div class="loginbox loginbox1">
        <form action="pjy/UserLogin" method="post">
            <ul>
                <li><input name="uname" type="text" placeholder="用户名" class="loginuser" /></li>
                <li><input name="pwd" type="password" placeholder="密码" class="loginpwd" /></li>
                <li class="yzm">
                <span><input name="" type="text" value="验证码"
                             onclick="JavaScript:this.value=''"/></span><cite>X3D5S</cite>
                </li>
                <li><input  type="submit" class="loginbtn" value="登录"
                           onclick="javascript:window.location='main.html'"/>
                    <label><a href="user/reg.jsp">注册</a></label>
                    <label><a href="#">忘记密码？</a></label></li>
            </ul>
        </form>
    </div>
</div>


<div class="loginbm">裴帅所有 <a href="https://zsy.xyz">pjy.com</a> 帅哥可看！</div>


</body>

</html>

