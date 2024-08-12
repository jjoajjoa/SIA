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
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String search = request.getParameter("search");
	
	String[] hobbys = request.getParameterValues("hobby");
	String gender = request.getParameter("gender");
	String lunch = request.getParameter("lunch");
	%>
	
	당신의 이름은 <%=name %> 이군요!<br> 
	이메일은 <%=email %> 입니다.<br> 
	검색어는 <%=search %> 입니다.<br> 
	취미는 <%
	    if (hobbys == null || hobbys.length == 0) {
	        out.print("없군요..");
	    } else {
	        for (String h : hobbys) {
	            out.print(h + " 이군요! ");
	        }
	    }
		%><br>
	<%=gender %> 군요!<br>
	점심으로는 <%=lunch %> 드시는군요!
</body>
</html>