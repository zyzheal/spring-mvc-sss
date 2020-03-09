<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Resume List</title>
</head>
<body>
<p>
    <a href="/user/lougout">退出</a>
</p>
<h1>The Resumes</h1>
<a href="/resume/new">新建</a>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>address</td>
        <td>phone</td>
        <td>actions</td>
    </tr>
    <c:forEach items="${resumeList}" var="resume">
        <tr>
            <td>${resume.id}</td>
            <td>${resume.name}</td>
            <td>${resume.address}</td>
            <td>${resume.phone}</td>
            <td>
                <a href="/resume/edit?id=${resume.id}">编辑</a>
                <form action="/resume/remove" method="post">
                    <input type="hidden" name="id" value="${resume.id}">
                    <button type="submit">删除</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
