<%--
  Created by IntelliJ IDEA.
  User: To be
  Date: 2019/11/22
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
    <h2>修改用户信息</h2>
    <h4>当前用户信息：</h4>
    <form:form modelAttribute="user" method="put"
                action="${pageContext.request.contextPath}/user">

        id: ${id}<br><br>
        姓名: ${user.username}<br><br>
        密码: ${user.password}<br><br>
        身高: ${user.height}<br><br>
        生日: ${user.birthday}<br><br>
        部门id: ${user.department.id}<br><br>
        部门名字: ${user.department.deptName}<br><br>
        邮箱地址: ${user.email}<br><br>
        <h4>请修改：</h4>
        <%--path属性相当于普通的form标签里的元素标签上的id和name的综合体--%>
        <form:hidden path="id"/>
        <form:input path="password"/><form:errors path="password"/><br><br>
        <form:input path="height"/><form:errors path="height"/><br><br>
        <form:input path="birthday"/><form:errors path="birthday"/><br><br>
        <form:select path="department.id" itemValue="id" itemLabel="deptName" items="${depts}"/><form:errors path="department"/><br><br>
        <form:input path="email"/><form:errors path="email"/><br><br>
        <input type="submit" value="修改用户"/><br><br>
    </form:form>
</body>
</html>
