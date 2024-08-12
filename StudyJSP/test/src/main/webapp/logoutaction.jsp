<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
//첫번째방법 세션이 가지고있는 모든 어트리뷰트가 리셋됨
//session.invalidate();
//두번째방법 어트리뷰트 아이디의 값을 없애버림
session.setAttribute("id", null);
%>
<jsp:forward page="login.jsp"></jsp:forward>
</body>
</html>