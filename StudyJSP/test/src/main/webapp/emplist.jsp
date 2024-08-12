<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>Employees List</h3>
	<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "jjoajjoa");
	Statement stmt = con.createStatement();
	String sql = "select * from employees where department_id = 80";
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next()) {
		%>
		<%=rs.getString("first_name") %> <%=rs.getString("last_name") %> <%=rs.getString("salary") %><br/>
		<%
	}
	%>

</body>
</html>