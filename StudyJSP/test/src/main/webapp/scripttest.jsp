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
		int random = (int)(Math.random() * 100);
	%>
	랜덤한 숫자 : <%= random %>
	<%
		java.util.Date date;
	%>
	
	
</body>
</html>