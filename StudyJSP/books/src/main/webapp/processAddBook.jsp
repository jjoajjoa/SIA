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
   //1. 클라이언트가 전송한 도서정보를 추출한다. (request) Book 객체생성
   request.setCharacterEncoding("utf-8");
   
   String bookId = request.getParameter("bookId");
   String name = request.getParameter("name");
   String author = request.getParameter("author");
   String publisher = request.getParameter("publisher");
   String description = request.getParameter("description");
   
   Book book = new Book();
   book.setBookId(bookId);
   book.setName(name);
   book.setAuthor(author);
   book.setPublisher(publisher);
   book.setDescription(description);
   //2. 추출정보로 도서를 추가한다.
   //BookRepository br = new BookRepository();
   bookDAO.addBook(book);
   
   //3. books.jsp로 포워딩하거나 redirect한다.
   response.sendRedirect("books.jsp");
%>
</body>
</html>