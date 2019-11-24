<%--
  Created by IntelliJ IDEA.
  User: To be
  Date: 2019/11/22
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var href = this.href;//js原生写法$(this).attr("href");
                $("#delform").attr("action", href).submit();
                return false;//让<a>标签原来的功能失效
            });
        });
    </script>
</head>
<body>
<%--测试文件上传操作--%>
<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    文件说明：<input type="text" name="mark"><br><br>
    上传文件：<input type="file" name="file"><br><br>
    <input type="submit" value="上传">
</form>
<%--测试@ResponseBody@和RequestBody--%>
<form action="${pageContext.request.contextPath}/testConvert" method="post" enctype="multipart/form-data">
    文件说明：<input type="text" name="mark"><br><br>
    上传文件：<input type="file" name="file"><br><br>
    <input type="submit" value="上传">
</form>

<form action="${pageContext.request.contextPath}/convertUser" method="post">
    字符串形式的User(username,password,dept_id): <input type="text" name="user">
    <input type="submit" value="提交">
</form>
<form id="delform" action="" method="post">
    <input type="hidden" name="_method" value="delete">
</form>
<h2>显示所有用户的信息</h2>
<form:form action="${pageContext.request.contextPath}/user" method="get">
    <input type="submit" value="添加新用户">
</form:form>
<table width="50%" border="1" cellpadding="0" cellspacing="0">
    <tr>
        <td>用户编号</td>
        <td>用户名</td>
        <td>用户密码</td>
        <td>身高</td>
        <td>生日</td>
        <td>用户所属部门</td>
        <td>邮箱地址</td>
        <td>用户进行操作</td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.height}</td>
            <td>${user.birthday}</td>
            <td>${user.department.deptName}</td>
            <td>${user.email}</td>
            <td>
                <a href="${pageContext.request.contextPath}/user/${user.id}">修改</a>
                <a class="delete" href="${pageContext.request.contextPath}/user/${user.id}">删除</a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
