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
	<form id="myform" action="loginaction.jsp" method="post">
		id : <input type="text" name="userId"> <br /> 
		pw : <input type="password" name="pw"> <br /> 
		<input type="submit" id="myBtn" name="myBtn" value="login">
	</form>
	<script>
		//자바스크립스 사용
		myform.onsubmit = function onSubmit(){
			alert('제출완료');
			e.preventDedault(); //submit되지 않도록 처리한다. 
		}
		
		//제이쿼리 사용
		$(function() {
			//form submit 이벤트 핸들러 등록
			$('#myform').on('submit', function(e) {
				if($('#userId').val()=='') {
					alert('아이디를 입력하세요!');
					let result = confirm('yes or no');
					e.preventDedault();
				}
			});
		});
		
		//let var const
		/*let myBtn = document.getElementById("myBtn"); // ->Ajax
		myBtn.onclick = handle;
		function handle(){
			//alert('haha');
			let userId = document.getElementById("userId").value;
			alert(userId);
			if(!userId){
				alert('userId를 입력바랍니다.')
			}
		} */
	
	</script>
</body>
</html>