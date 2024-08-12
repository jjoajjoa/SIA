package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileTest3 {
	public static void main(String[] args) throws FileNotFoundException {
		//사용자가 입력한 문자열을 파일로 저장.
		Scanner scan = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new File("System.out"));
		String str = scan.nextLine();
		while(str.length()!=0) {
			System.out.println(str);
			out.println(str);
			str = scan.nextLine();
		}
		out.close();
	}
}
