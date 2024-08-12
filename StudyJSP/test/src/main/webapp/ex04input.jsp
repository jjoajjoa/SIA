<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="ex04result.jsp" id="myformId">
		<table border="1">
			<caption style="font-weight: bolder; margin-bottom: 10px;">성적 입력</caption>
			<tbody>
				<tr>
					<th colspan="2">사 번</th>
					<td><input id="empNumberId" name="empNumber" type="text"></td>
				</tr>
				<tr>
					<th rowspan="3">과 목</th>
					<th>Java</th>
					<td><input name="java" type="number"></td>
				</tr>
				<tr>
					<th>Database</th>
					<td><input name="db" type="number"></td>
				</tr>
				<tr>
					<th>JSP</th>
					<td><input name="jsp" type="number"></td>
				</tr>
				<tr>
					<td colspan="3" id="saveBtn" style="text-align: center;">
						<button type="submit">저장</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<script>
	let myform = document.querySelector("#myform");
	let empNumber = document.getElementById("empNumberId");
	
	myform.onsubmit = function (event) { //웹브라우저에서실행됨
		let empNumberId = document.getElementById("empNumberId");
		if (!empNumberId.value) {
			event.preventDefault();
			alert('사번이 입력되지 않았습니다.');
			empNumberId.focus();
		}
	}
	</script>
</body>
</html>