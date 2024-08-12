<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	input {
	}
	.myinput {
	}
	
</style>
</head>
<body>
	
<form id="myform" action="loginaction.jsp" method="post">
	id : <input class="myinput" type="text" name="id" id="id"> <br/>
	pw : <input type="password" name="pw"> <br/>
	<input type="submit"  id="myBtn" value="login"> 
</form>

<script>
let id = document.querySelector("#id")
	myform. onsubmit = function onSubmit(e) {
		alert('submit');
		
		if(!id.value) {
			alert('아이디를 입력하세요');
		
		// e.preventDefault(); //submit되지 않도록 처리한다.
		}
	}
	//let var const
	/* let myBtn = document.getElementById("myBtn"); //-> Ajax로 처리가 가능해야 한다.
	myBtn.onclick = handle;
	function handle() {
		//alert('haha');
		//id에 입력한 데이터를 추출할 수 있는가!
		let userId = document.getElementById("userId").value;
		alert(userId) {
			if(!userId) {
				alert('userId를 입력바랍니다.');
			}
		}
	} */
</script>

</body>
</html>