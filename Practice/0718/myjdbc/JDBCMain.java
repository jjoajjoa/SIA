package myjdbc;

import java.util.List;
import java.util.Scanner;

public class JDBCMain {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
//		System.out.print(" >> 부서번호 (0:종료) : ");
//		int deptId = scan.nextInt();
//		while(deptId != 0) {
//			List<Emp> list = EmpDAO.getEmpListByDeptId(deptId);
//			for (Emp e : list) {
//				System.out.println(e);
//			}
//			System.out.print(" >> 부서번호 (0:종료) : ");
//			deptId = scan.nextInt();
//		}
		
		System.out.print(" >> 입사년도: ");
		int hireDate = scan.nextInt();
		while(hireDate != 0) {
			List<Emp> list = EmpDAO.getEmpListByHireDate(hireDate);
			for (Emp e : list) {
				System.out.println(e);
			}
			System.out.print(" >> 입사년도: ");
			hireDate = scan.nextInt();
		}
		
		scan.close();
	}
}
