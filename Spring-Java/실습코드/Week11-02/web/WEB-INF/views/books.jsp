<%--
  Created by IntelliJ IDEA.
  User: kimyoonseo
  Date: 2022/05/16
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<form class="form-login" action = "./submitBook" method = "post"  >
    책 이름 <input type = "text" class="input" name = "bookname" placeholder="책이름" required> <br>
    출판사 <input type = "text" class="input" name = "publisher" placeholder="출판사" required> <br>
    가격 <input type = "text" class="input" name = "price" placeholder="가격" required>
    <br><br>
    <button class="btn" type="submit"> 제출 </button>
</form>
