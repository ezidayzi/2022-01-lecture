<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/05/30
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<meta charset="UTF-8"> <html>
<head> <title>UserInfo</title> </head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>
<c:if test="${! empty authInfo}">
    <P> ${authInfo.userid}님 정보 </P>
    <p> <spring:message code="email" />: ${userInfo.email} </p>
    <p> <spring:message code="addr" />: ${userInfo.addr} </p>
    <p> <spring:message code="tel" />: ${userInfo.tel} </p>
    <p> <spring:message code="birthday" />: <tf:formatDate value="${userInfo.birthday}" pattern="yyyy-MM-dd" /> </p>
    <a href="/"> <spring:message code="back" /> </a>
</c:if>
</body>
</html>