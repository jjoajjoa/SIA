package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest2 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver"); // "여기"안에 있는걸 클래스로 보고있는것
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr" , "root", "jjoajjoa");
		Statement statement = connection.createStatement();
		String sql = "select * from employees";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("last_name"));
		}
	}
}
