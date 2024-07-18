package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	
	public static List<Emp> getEmpListByDeptId(int deptId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection con = DBUtill.getConnection();
		Statement statement = con.createStatement();
		String sql = "select * from employees where department_id = " + deptId;
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			int employeeId = rs.getInt("employee_id");
			String lastName = rs.getString("last_name");
			int salary = rs.getInt("salary");
//			emp.employeeId = employeeId;
//			emp.lastName = lastName;
//			emp.salary = salary;
			Emp emp = new Emp(employeeId, salary, lastName);
			result.add(emp);
		}
		return result;
	}
	
	public static List<Emp> getEmpListByHireDate(int hireDate) throws Exception {
		List<Emp> result2 = new ArrayList<Emp>();
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "jjoajjoa");
		Statement statement = connection.createStatement();
		String sql = "select first_name, last_name, hire_date, salary from employees where year(hire_date) = " + hireDate;
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String hire_Date = rs.getString("hire_date");
			int salary = rs.getInt("salary");
			
			Emp emp = new Emp();
			emp.firstName = firstName;
			emp.lastName = lastName;
			emp.hireDate = hire_Date;
			emp.salary = salary;
			
			result2.add(emp);
		}
		return result2;
	}

	public static List<Emp> getEmpListByLastName(String name) throws Exception {
		List<Emp> result3 = new ArrayList<Emp>();
		Connection con = DBUtill.getConnection();
		String sql = "select * from employees where last_name = ?"; 
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
//		Statement stmt = con.createStatement();
//		ResultSet rs = pstmt.executeQuery(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String hire_Date = rs.getString("hire_date");
			int salary = rs.getInt("salary");
			
			Emp emp = new Emp();
			emp.firstName = firstName;
			emp.lastName = lastName;
			emp.hireDate = hire_Date;
			emp.salary = salary;
			
			result3.add(emp);
		}
		return result3;
	}
}

//		List<Emp> result3 = new ArrayList<Emp>();
//		Connection con = DBUtill.getConnection();
//		Statement statement = con.createStatement();
//		String sql = "select * from employees where last_name = '" + name + "'";
//		ResultSet rs = statement.executeQuery(sql);
//		while (rs.next()) {
//			String firstName = rs.getString("first_name");
//			String lastName = rs.getString("last_name");
//			String hire_Date = rs.getString("hire_date");
//			int salary = rs.getInt("salary");
//			
//			Emp emp = new Emp();
//			emp.firstName = firstName;
//			emp.lastName = lastName;
//			emp.hireDate = hire_Date;
//			emp.salary = salary;
//			
//			result3.add(emp);
//		}
//		return result3;