<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/05/16
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>고객정보</title>
</head>
<body>
<h3>제출되었습니다!</h3>
<p> 이름: ${customerData.name} </p>
<p> 전화번호: ${customerData.phone} </p>
<p> 주소: ${customerData.address} </p>
<br>

<a href="./">back ...</a>
</body>
</html>
