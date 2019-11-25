<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h4>Hello World!</h4>
    <form action="${pageContext.request.contextPath}/users" method="get">
        <input type="submit" value="显示所有用户信息">
    </form>
    <form action="${pageContext.request.contextPath}/depts" method="get">
        <input type="submit" value="显示所有部门信息">
    </form>
    <form action="${pageContext.request.contextPath}/jsonTestView" method="get">
        <input type="submit" value="显示json页面">
    </form>
    <a name="filename" href="${pageContext.request.contextPath}/download?filename=123321.txt">下载123321.txt</a>
</body>
</html>
