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
	let myf2 = function () {
		document.write('myf2');	
	}

	function myf(mymy) {
		mymy();
	}
	
	myf(myf2);
</script>
	
</body>
</html>