<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/05/23
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<meta charset="UTF-8"> <html>
<head> <title>Home</title> </head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%--<form class="form-login" action = "./submit" method = "post"  >--%>
<%--    <spring:message code="id" /> <input type = "text" class="input" name = "id" placeholder="아이디" required> <form:errors path="id"></form:errors> <br>--%>
<%--    <spring:message code="email" /> <input type = "text" class="input" name = "email" placeholder="이메일" required> <br>--%>
<%--    <spring:message code="name" />  <input type = "text" class="input" name = "name" placeholder="이름" required> <br>--%>
<%--    <spring:message code="address" /> <input type = "text" class="input" name = "address" placeholder="주소" required> <br>--%>
<%--    <spring:message code="phone" />  <input type = "text" class="input" name = "phone" placeholder="전화번호" required>--%>
<%--    <br><br>--%>
<%--    <button class="btn" type="submit"> 제출 </button>--%>
<%--</form>--%>

<P> <spring:message code="homemsg" /> </P>
<form:form action="./submit" modelAttribute="userInfo">
    <p> <label> <spring:message code="name" />:<br>
        <form:input path="id" /> <form:errors path="id" /> </label> </p>
    <p> <label> <spring:message code="id" />:<br>
        <form:input path="email" /> <form:errors path="email" /> </label> </p>
    <p> <label> <spring:message code="email" />:<br>
        <form:input path="name" /> <form:errors path="name" /> </label> </p>
    <p> <label> <spring:message code="name" />:<br>
        <form:input path="address" /> <form:errors path="address" /> </label> </p>
    <p> <label> <spring:message code="phone" />:<br>
        <form:input path="phone" /> <form:errors path="phone" /> </label> </p>

    <button class="btn" type="submit"> <spring:message code="submit" /> </button> </form:form>
</body>
</html>