<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
</head>
<body>
	<h3>Ajax Test</h3>
	<p>여기가 달라집니다! 클릭하면 ajax 결과로 대체할거예요</p>
	
	<script type="text/javascript">
		$(function () {
			$('p').on('click', function () {
				//alert('click');
				$.ajax({
					url: 'JQServlet',
					success: function (data) {
						//alert(JSON.stringify(data));
						alert(data.ashley);
						$('p').html(JSON.stringify(data));
					}
				}) // {} JSON 자바스크립트객체 - 키:값 쌍으로 구성됨
			});
		});
	</script>
</body>
</html>