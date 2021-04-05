<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
 	<c:set var="id" value="${sessionScope.id}" />
  
 
 <c:if test="${id eq null }" >
 	<c:redirect url ="loginForm.jsp" />
 </c:if>

 로그인한 아이디 :  ${id }
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>

</body>
</html>