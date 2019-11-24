<%--
  Created by IntelliJ IDEA.
  User: To be
  Date: 2019/11/24
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#json").click(function () {
               var href=this.href;
               var args={};
               $.post(href,args,function (data) {
                  for (var i=0;i<data.length;i++){
                      alert(data[i].username+"  "+data[i].id);
                  }
               });
               return false;
            });
        });
    </script>
</head>
<body>
<%--    <a id="json" href="${pageContext.request.contextPath}/testJson1">json的数据格式，来获取所有用户信息</a>--%>
    <a id="json" href="${pageContext.request.contextPath}/testJson2">json的数据格式，来获取所有用户信息</a>
</body>
</html>
