<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/05/16
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<form class="form-login" action = "./submitCustomer" method = "post"  >
  이름 <input type = "text" class="input" name = "name" placeholder="이름" required> <br>
  주소 <input type = "text" class="input" name = "address" placeholder="주소" required> <br>
  번호 <input type = "text" class="input" name = "phone" placeholder="전화번호" required>
  <br><br>
  <button class="btn" type="submit"> 제출 </button>
</form>
