<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="process_fileupload.jsp" enctype="multipart/form-data">
		<p>제목 : <input type="text" name="title"></p>
		<p>가격 : <input type="text" name="price"></p>
		<p>파일 : <input type="file" name="filename"></p>
		<p>제목 : <input type="submit" name="전송하기"></p>
	</form>

</body>
</html>