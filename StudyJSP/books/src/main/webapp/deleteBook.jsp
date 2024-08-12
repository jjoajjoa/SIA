<%@page import="dao.BookRepository"%>
<%@page import="dto.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bookDAO" class="dao.BookRepository" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
   //1. request에서 bookId를 추출
   String bookId = request.getParameter("id");
   //2. 추출정보로 도서를 삭제한다.
   bookDAO.deleteBook(bookId);
   //3. books.jsp로 포워딩하거나 redirect한다.
   //response.sendRedirect("books.jsp"); 
%>
<jsp:forward page="books.jsp"></jsp:forward> 
</body>
</html>