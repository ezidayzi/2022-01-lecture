<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/06/13
  Time: 2:38
  To change this template use File | Settings | File Templates.
--%>
<%--상품 디테일 페이지--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${productInfo.name}</title>
</head>
<body>
<h1>${productInfo.name}</h1>
<h1>${productInfo.info}</h1>
<h3>${productInfo.price}원</h3>

<a href="./shop"> <spring:message code="back" /> </a>
</body>
</html>
