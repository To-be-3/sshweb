<%--
  Created by IntelliJ IDEA.
  User: To be
  Date: 2019/11/22
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加新用户</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/index">首页</a>
<h2>添加新用户</h2>
<form:form modelAttribute="user" method="post"
           action="${pageContext.request.contextPath}/user">
    <h4>请填写：</h4>
    <%--path属性相当于普通的form标签里的元素标签上的id和name的综合体--%>
    用户名: <form:input path="username"/><form:errors path="username"/><br><br>
    密码: <form:input path="password"/><form:errors path="password"/><br><br>
    身高: <form:input path="height"/><form:errors path="height"/><br><br>
    生日: <form:input path="birthday"/><form:errors path="birthday"/><br><br>
    所属部门: <form:select path="department.id" itemValue="id" itemLabel="deptName" items="${depts}"/><form:errors path="department"/><br><br>
    邮箱地址: <form:input path="email"/><form:errors path="email"/><br><br>
    <input type="submit" value="添加用户"/><br><br>
</form:form>
</body>
</html>
