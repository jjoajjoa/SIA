<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
	<form action="ex06result.jsp">
		<table border>
			<thead>
				<tr style="text-align: center;">
					<td>과일목록</td>
					<td>가격</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td rowspan="3">
						<input type="checkbox" name="fruit" id="cherry" value="체리">체리<br/>
						<input type="checkbox" name="fruit" id="orenge" value="오렌지">오렌지<br/>
						<input type="checkbox" name="fruit" id="apple" value="사과">사과
					</td>
					<td>25,000원</td>
				</tr>
				<tr>
					<td>23,000원</td>
				</tr>
				<tr>
					<td>16,000원</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<button type="submit">구입</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>

</body>
</html>