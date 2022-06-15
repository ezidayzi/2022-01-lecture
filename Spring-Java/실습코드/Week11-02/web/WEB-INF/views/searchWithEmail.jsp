<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/05/24
  Time: 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form class="form-login" action = "./result" method = "post"  >--%>
<spring:message code="email" /> : <input type = "text" class="input" name = "email" placeholder="이름" required> <br>
    <button class="btn" type="submit"> 제출 </button>
<%--</form>--%>
</body>
</html>
