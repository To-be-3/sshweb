<%--
  Created by IntelliJ IDEA.
  User: To be
  Date: 2019/11/25
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>显示所有部门</title>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var href = this.href;
                $("#delform").attr("action", href).submit();
                return false;
            });
        });
    </script>
</head>
<body>
<a href="${pageContext.request.contextPath}/index">首页</a>
<h2>显示所有用户的信息</h2>
<form action="${pageContext.request.contextPath}/dept" method="get">
    <input type="submit" value="添加部门">
</form>
<form id="delform" action="" method="post">
    <input type="hidden" name="_method" value="delete">
</form>
<table width="50%" border="1" cellpadding="0" cellspacing="0">
    <tr>
        <td>部门编号</td>
        <td>部门名字</td>
        <td>操作</td>
    </tr>
    <c:forEach var="dept" items="${depts}">
        <tr>
            <td>${dept.id}</td>
            <td>${dept.deptName}</td>
            <td>
                <a href="${pageContext.request.contextPath}/dept/${dept.id}">修改</a>
                <a href="${pageContext.request.contextPath}/dept/${dept.id}" class="delete">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
