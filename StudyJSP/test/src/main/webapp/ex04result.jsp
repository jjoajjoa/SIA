<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	String empNumber = request.getParameter("empNumber");
	int java = Integer.parseInt(request.getParameter("java"));
	int db = Integer.parseInt(request.getParameter("db"));
	int jsp = Integer.parseInt(request.getParameter("jsp"));
	double avg = (java + db + jsp) / 3;
	%>
	<table border="1">
		<caption style="font-weight: bolder; margin-bottom: 10px;">처리 결과</caption>
		<tbody>
			<tr>
				<th colspan="2">사 번</th>
				<td><%=empNumber%></td>
			</tr>
			<tr>
				<th rowspan="3">과 목</th>
				<th>Java</th>
				<td><%=java%>점</td>
			</tr>
			<tr>
				<th>Database</th>
				<td><%=db%>점</td>
			</tr>
			<tr>
				<th>JSP</th>
				<td><%=jsp%>점</td>
			</tr>
			<tr>
				<th colspan="2">평 균</th>
				<td style="width: 30%;"><%=avg%>점
			</tr>
			<tr>
				<td colspan="3" style="text-align: center;">
					<button>
						<a href="ex04input.jsp">입력화면</a>
					</button>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>