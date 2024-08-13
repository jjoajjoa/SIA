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

	<input type="button" value="전송" id="myBtn" />

	<script>
		//1.$함수에 전달된 함수를 실행시켜주는군
		$(function() {
			//alert('hi jq');
			//방법3
			$('#myBtn').on('click', () => {
				alert('jq로 인해 myBtn이 클릭되었어용');
			});
		});
		
		//2.초기설정을 이렇게 하면 되겠군
		let myBtn = document.querySelector('#myBtn');
		myBtn.addEventListener('click', function () {
			//방법1
			alert('myBtn이 클릭되었어용');
		});
		myBtn.onclick = function () {
			//방법2
			alert('myBtn이 클릭되었어용');
		}
	</script>
	
</body>
</html>