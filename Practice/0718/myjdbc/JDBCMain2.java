package myjdbc;

import java.util.List;
import java.util.Scanner;

public class JDBCMain2 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.print(" >> 직원명(입력안하면종료) : ");
		String name = scan.nextLine();
		while (!name.equals("")) {
			List<Emp> list = EmpDAO.getEmpListByLastName(name);
			for (Emp e : list) {
				System.out.println(e);
			}
			System.out.print(" >> 직원명(입력안하면종료) : ");
			name = scan.nextLine();
		}

		scan.close();
	}
}
