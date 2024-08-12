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
	out.print("out. 내장객체 테스트"); // 클라이언트 화면에 출력한다.
	System.out.println("System. 내장객체 테스트");// 애플리케이션 실행한 콘솔창에 출력한다.
	String id = request.getParameter("id");
	String name = "haha";
	name.length();
	//name이 갖고있는 메서드가 아니라 String이 갖고있는 메서드이다.
%>
	String clientIP = request.getRemoteAddr();
	System.out.println("client IP:" client IP);
	

</body>
</html>