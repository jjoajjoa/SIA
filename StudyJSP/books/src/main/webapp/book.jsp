<%@page import="dao.BookRepository"%>
<%@page import="dto.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bookDAO" class="dao.BookRepository"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<div class="container py-4">
		<%@ include file="menu.jsp" %>

		<div class="p-5 mb-4 bg-body-tertiary rounded-3"></div>
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">도서정보</h1>
				<p class="col-md-8 fs-4">BookInfo</p>
			</div>
		
		<%
			//1. 클라이언트가 전송한 bookId 추출하기
			String bookId = request.getParameter("id");
			if(bookId==null | bookId.length()==0) {
		%>
		<jsp:forward page="books.jsp"></jsp:forward>
		<%		
			}
			//2. dao를 이용하여 해당 책 정보 조회
			/* BookRepository br = new BookRepository(); */
			Book book = bookDAO.getBookById(bookId);
			//3. 책 정보를 이용하여 화면에 출력
		%>
		<div class="row align-items-md-stretch text-center">
			<div class="col-md-4">
				<div class="h-100 p-2">
					<h3><b><%=book.getName() %></b></h3>
					<p><b>저 자</b> <%=book.getAuthor() %></p>
					<p><b>출판사</b> <%=book.getPublisher() %></p>
					<p><b>출판일</b> <%=book.getReleaseDate() %></p>
					<p><b>분 류</b> <%=book.getCategory() %></p>
					<p><b>재고수</b> <%=book.getUnitsInStock() %></p>
					<a href="book.jsp" class="btn btn-secondary">도서목록</a>
					<a href="addBook.jsp" class="btn btn-secondary">도서등록</a>
				</div>
			</div>
		</div>
	
		<%@ include file="footer.jsp" %>
	</div>
</body>
</html>