<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Resume Form</title>
</head>
<body>
<form method="post" action="/resume/save">
    <c:choose>
        <c:when test="${resume == null}">
            <label>姓名:
                <input type="text" name="name" />
            </label>
            <label>地址:
                <input type="text" name="address" />
            </label>
            <label>电话:
                <input type="text" name="phone" />
            </label>
        </c:when>
        <c:otherwise>
            <input type="hidden" name="id" value="${resume.id}" />
            <label>姓名:
                <input type="text" name="name" value="${resume.name}" />
            </label>
            <label>地址:
                <input type="text" name="address" value="${resume.address}" />
            </label>
            <label>电话:
                <input type="text" name="phone" value="${resume.phone}" />
            </label>
        </c:otherwise>
    </c:choose>
    <button type="submit">提交</button>
</form>
</body>
</html>
