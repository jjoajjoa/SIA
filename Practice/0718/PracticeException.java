package practiceException;

import java.util.Scanner;

/* 사용자로부터 문자열을 입력받아서 그 문자열을 숫자로 변환하여 출력하는 프로그램입니다. */
// 1>  convert라는 메서드를 정의합니다.v
//	A. 문자열을 전달받아서, 그 문자열을 숫자로 변환하여 리턴합니다.v
//	B. 전달된 문자가 문자열의 길이가 0이면 Exception을 발생시킨 후 메소드를 호출한 쪽으로 예외를 던집니다.v
//2>  main메서드에서 convert를 호출하고 결과를 출력합니다.v
//3>  예외가 발생되면, “예외가 발생되었습니다. 문자열을 입력하지 않고 Enter키를 누르셨습니다.”라고 출력합니다.v
//
//실행 예>  [ 사용자가 123을 입력할 경우, 화면으로 출력되는 문자열입니다 ]
//          숫자로 변환할 문자열을 입력바랍니다.
//123
//변환된 숫자는 123 입니다.
//
//[ 사용자가 입력하지 않고 Enter키를 누른 경우, 화면으로 출력되는 문자열 입니다 ]
//          숫자로 변환할 문자열을 입력바랍니다.
public class ExceptionTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(" >> 숫자로 변환할 문자열을 입력바랍니다. <<");
		String input = scan.nextLine();

		try {
			convert(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void convert(String input) throws Exception {
		if (input.length() == 0 && input.equals(""))
			throw new Exception("[system] 예외가 발생되었습니다. 문자열을 입력하지 않고 Enter키를 누르셨습니다.");
		int inputInt = Integer.parseInt(input);
		System.out.println(" >> 변환된 숫자는 " + inputInt + " 입니다!");
	}

}
