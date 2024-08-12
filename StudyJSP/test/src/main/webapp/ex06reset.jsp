<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	session.setAttribute("list", null);
	session.setAttribute("cherry", null);
	session.setAttribute("orenge", null);
	session.setAttribute("apple", null);
	%>
	<jsp:forward page="ex06first.jsp"></jsp:forward>
</body>
</html>