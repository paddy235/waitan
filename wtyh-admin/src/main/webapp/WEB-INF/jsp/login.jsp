<%--
  User: pc
  Date: 2016/3/16
  Time: 11:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>普惠法治智能平台</title>
    <%@include file="common/meta.jsp" %>
</head>
<body>
<div class="login-wrap">
    <div class="logo"></div>
    <div class="form">
        <form method="post" action="">
        	<div style="color: red">${error}</div>
            <div class="mg-s">
                <input name="username" type="text" value="<shiro:principal/>" class="ipt ipt-block" placeholder="请输入账号"/>
            </div>
            <div class="mg-s">
                <input name="password" type="password"  class="ipt ipt-block" placeholder="请输入密码"/>
            </div>
            <div class="mg-l">
                <button type="submit" class="btn btn-block">登 录</button>
            </div>
        </form>
    </div>
</div>
<div class="login-foot">
    <div class="mg-l">
        right<br>
        版权
    </div>
</div>
</body>
</html>
