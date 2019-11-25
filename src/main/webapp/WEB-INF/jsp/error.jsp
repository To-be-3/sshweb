<%--
  Created by IntelliJ IDEA.
  User: To be
  Date: 2019/11/24
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/index">首页</a>
    错误信息: ${exception}
</body>
</html>
