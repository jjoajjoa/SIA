package test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import test.util.DBUtil;
import test.vo.Emp;

public class EmpDAO {

	//부서번호목록
	public static List<Integer> getDeptIdList() throws Exception {
		List<Integer> result = new ArrayList<Integer>();
		Connection con = DBUtil.getConnection();
		Statement stmt = con.createStatement();
		String sql = "select distinct department_id from employees where department_id is not null";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int deptId = rs.getInt("department_id");
			result.add(deptId);
		}
		return result;
	}
	
	public static List<Emp> getEmpListByDeptId(int deptId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection con = DBUtil.getConnection();
		Statement stmt = con.createStatement();
		String sql = "select * from employees where department_id = " + deptId;
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int salary = rs.getInt("salary");
			String lastName = rs.getString("last_name");
//			emp.salary = salary;
//			emp.lastName = lastName;
			Emp emp = new Emp(salary, lastName);
			result.add(emp);
		}
		return result;
	}

	public static List<Emp> getEmpListByHireYear(int year) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection con = DBUtil.getConnection();
		Statement stmt = con.createStatement();
		String sql = "select * from employees where year(hire_date) = " + year;
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int salary = rs.getInt("salary");
			String lastName = rs.getString("last_name");
			Emp emp = new Emp();
			emp.salary = salary;
			emp.lastName = lastName;
			result.add(emp);
		}
		return result;
	}

	public static List<Emp> getEmpListByLastName(String name) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection con = DBUtil.getConnection();
		String sql = "select * from employees where last_name = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
//		Statement stmt = con.createStatement();
//		ResultSet rs = pstmt.executeQuery(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int salary = rs.getInt("salary");
			String lastName = rs.getString("last_name");
			Emp emp = new Emp();
			emp.salary = salary;
			emp.lastName = lastName;
			result.add(emp);
		}
		return result;
		
//		List<Emp> result = new ArrayList<Emp>();
//		Connection con = DBUtil.getConnection();
//		Statement stmt = con.createStatement();
//		String sql = "select * from employees where last_name = '" + name + "'";
//		ResultSet rs = stmt.executeQuery(sql);
//		while(rs.next()) {
//			int salary = rs.getInt("salary");
//			String lastName = rs.getString("last_name");
//			Emp emp = new Emp();
//			emp.salary = salary;
//			emp.lastName = lastName;
//			result.add(emp);
//		}
//		return result;
	}
}
