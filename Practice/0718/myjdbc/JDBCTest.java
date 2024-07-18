package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver"); // .forname 메서드가 throw절로 정의되어있음
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "jjoajjoa");
//		System.out.println(con.getClass().getName()); //com.mysql.cj.jdbc.ConnectionImpl이라는 클래스를 객체생성하여 리턴함
		// .getConnection() : 드라이버매니저 클래스 안에 있는 리턴타입이 커넥션인 스태틱 메서드
		Statement stmt = con.createStatement();
		// .createStatement() : 커넥션인터페이스에 선언된 리턴타입이 스테이트먼트인 추상 메서드
		// 인터페이스에 선언된건데 실행해버림.. 어떤게 실행됐을까? com.mysql.cj.jdbc.ConnectionImpl
		String sql = "select * from employees where department_id = 80";
		ResultSet rs = stmt.executeQuery(sql);
		// .executeQuery() : 스테이트먼트인터페이스에 선언된 리턴타입이 리저트셋인 메서드
		while (rs.next()) {
			System.out.println(rs.getString("last_name"));
//			System.out.println(rs.getString("salary"));
//			System.out.println(rs.getInt(1));
		}

	}
}
