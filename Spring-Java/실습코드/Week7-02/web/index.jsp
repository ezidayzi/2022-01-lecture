<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/04/18
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>7주차 실습 과제</title>
  </head>
  <body>
  <%@page import="calculation.Value" %>
  <%@ page import="calculation.Multiply" %>
  <%@ page import="calculation.Divide" %>
  <%@ page import="calculation.MultiplicationTable" %>
  <%
    Value a, b;
    a = new Value(6);
    b = new Value(3);
  %>
  테스트 객체1 : <%= a.getValue() %> <br>
  테스트 객체2 : <%= b.getValue() %> <br>

  <%
    Multiply m = new Multiply();
    m.setA(a);
    m.setB(b);
  %>
  곱하기! <%= m.multiply() %> <br>

  <%
    Divide d = new Divide();
    d.setA(a);
    d.setB(b);
  %>
  나누기! <%= d.divide() %> <br>

  <%
    MultiplicationTable table = new MultiplicationTable();
  %>

  <%
    for (int i = 2; i<10; i++) {
      table.setValue(i);
      String contents = table.makeTable();
      contents = contents.replace("\n", "<br>"); %>
      <%= contents %>
   <%
    }
  %>

  </body>
</html>
