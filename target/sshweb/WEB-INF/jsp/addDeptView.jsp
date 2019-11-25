<%--
  Created by IntelliJ IDEA.
  User: To be
  Date: 2019/11/25
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加部门</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/index">首页</a>
    <h2>添加新部门</h2>
    <form:form modelAttribute="dept" action="${pageContext.request.contextPath}/dept" method="post">
        <h4>请填写：</h4>
        部门名称: <form:input path="deptName"/><form:errors path="deptName"/><br><br>
        <input type="submit" value="添加部门">
    </form:form>
</body>
</html>
