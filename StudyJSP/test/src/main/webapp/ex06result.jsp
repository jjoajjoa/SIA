<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	//구입과일 목록
	String[] fruit = request.getParameterValues("fruit");
	List<String> fruitList = (List<String>) session.getAttribute("list");
	if (fruitList == null) {
		fruitList = new ArrayList<>();
	}
	if (fruit != null) {
		for (String f : fruit) {
			fruitList.add(f);
		}
		session.setAttribute("list", fruitList);
	}
	//구입과일 합계
	session.setAttribute("cherry", 25000);
	session.setAttribute("orenge", 23000);
	session.setAttribute("apple", 16000);
	%>

	<table border>
		<tbody style="text-align: center;">
			<tr>
				<th rowspan="2">구입한 과일</th>
			</tr>
			<tr>
				<td>
					<%
					if (fruit == null || fruit.length == 0) {
						out.print("텅");
					} else {
						for (String f : fruitList) {
							out.print(f + "<br>");
						}
					}
					%>
				</td>
			</tr>
			<tr>
				<th>합 계</th>
				<td>
					<%
					int sum = 0;
					int cherryInt = (int) session.getAttribute("cherry");
					int orengeInt = (int) session.getAttribute("orenge");
					int appleInt = (int) session.getAttribute("apple");
					for (String f : fruitList) {
						if (f.equals("체리")) {
							sum += cherryInt;
						} else if (f.equals("오렌지")) {
							sum += orengeInt;
						} else if (f.equals("사과")) {
							sum += appleInt;
						}
					}
					out.print(sum);
					%>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-decoration: none;">
					<button>
						<a href="ex06first.jsp" style="text-decoration: none;">과일구입화면</a>
					</button>
					<button id="btnReset">
						<a href="ex06reset.jsp" style="text-decoration: none;">초기화</a>
					</button>
				</td>
			</tr>
		</tbody>
	</table>

	<script>
	const btnReset = document.querySelector("#btnReset");
	btnReset.addEventListener("click", function() {
		sum = 0;
	})
	</script>
</body>
</html>