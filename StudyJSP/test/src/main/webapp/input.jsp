<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
	text-align:center;
	}
</style>
</head>
<body>
	<h3>성적 입력</h3>
	<form id="myform" action="result.jsp" method="post"  >
		<table border="1">
			<tr>
				<td colspan="2">사번</td>
				<td colspan="2"><input type="text" name="userId" id="userId"></td>
			</tr>
			<tr>
				<td rowspan="4">과목</td>
			</tr>
			<tr>
				<td>Java</td>
				<td><input type="text" name="java"></td>
			</tr>
			<tr>
				<td>Database</td>
				<td><input type="text" name="database"></td>
			</tr>
			<tr>
				<td>JSP</td>
				<td><input type="text" name="jsp"></td>
			</tr>
			<tr>
				<td colspan="5"><Button type="submit" id="saveBtn">저장</Button></td>
			</tr>			
		</table>
	</form>
<script>
	let myform = document.getElementById("myform");
	//let myform = document.querySelector("#myform"); // css방식
	let userId = document.getElementById("userId");
	//let userId = document.querySelector("#userId"); // css방식
	
	 myform.onsubmit = function() {
		   var userId = document.getElementById("userId");	
		   if(!userId.value){
			   alert('사번이 입력되지 않았습니다.');
			   userId.focus(); //페이지 안넘어가게 막음.
			   return false;
		   }
	   }
	
	
	
</script>
</body>
</html>