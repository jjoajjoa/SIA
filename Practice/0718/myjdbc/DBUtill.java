package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtill {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

		}
	}

	public static Connection getConnection() throws Exception {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "jjoajjoa");
		return connection;
	}

}
