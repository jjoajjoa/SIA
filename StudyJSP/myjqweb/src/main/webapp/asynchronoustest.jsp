<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	let count = 500;
	console.log(count);
	count = prompt('input number');
	console.log(count);
	<!-- 순차적으로 실행: 동기방식 -->
	
	setTimeout(function () {
		console.log('setTimeout');		
	}, 2000);
	console.log('last');
</script>
	
</body>
</html>