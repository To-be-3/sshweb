<%--
  Created by IntelliJ IDEA.
  User: To be
  Date: 2019/11/25
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>修改部门信息</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/index">首页</a>
    <h2>修改用户信息</h2>
    <form:form action="${pageContext.request.contextPath}/dept" method="put" modelAttribute="dept">
        <h4>当前用户信息：</h4>
        部门id: ${dept.id}<br>
        部门名称: ${dept.deptName}<br>
        <h4>请修改：</h4>
        <form:hidden path="id"/>
        <form:input path="deptName"/><form:errors path="deptName"/><br><br>
        <input type="submit" value="提交">
    </form:form>
</body>
</html>
