<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Resume Form</title>
</head>
<body>
<form method="post" action="/user/doLogin">
    <label>用户名:
        <input type="text" name="username" />
    </label>
    <label>密码:
        <input type="password" name="password" />
    </label>
    <button type="submit">登录</button>
</form>
</body>
</html>
