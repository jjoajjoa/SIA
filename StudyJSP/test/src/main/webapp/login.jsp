<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form id="myform" action="loginaction.jsp" method="post">
   		id : <input type="text" name="userId"> <br/>
   		pw : <input type="password" name="pw"> <br/>
   		<input type="submit" id="myBtn" name="myBtn" value="login">
   </form>
	<script>
		myform.onsubmit = function onSubmit(){
			alert('제출완료');
			e.preventDedault(); //submit되지 않도록 처리한다. 
			}	
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