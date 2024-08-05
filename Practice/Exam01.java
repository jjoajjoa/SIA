import java.util.Scanner;

public class Exam01 {

//	업앤다운 게임입니다.
//	v 1부터 100사이의 임의 숫자를 생성해둡니다.
//	v 사용자로부터 숫자를 입력받습니다.
//	v 입력숫자가 임의숫자보다 크면 아래란 문자열 출력
//	v 작으면 위 라는 문자열 출력
//	v 그래서 몇번만에 맞췄는지를 출력해줍니다.
//	v 0아래이거나 100보다 크면 다시 입력하게 합니다.

	public static void main(String[] args) {

		// 2. 사용자로부터 숫자를 입력받습니다.
		Scanner scanner = new Scanner(System.in);
		System.out.println("    [숫자를 입력하세용!]");
		int input = scanner.nextInt();
		// 4. 그래서 몇번만에 맞췄는지를 출력해줍니다.
		int count = 0;
		// 3. 입력숫자가 임의숫자보다 크면 아래란 문자열 출력, 입력숫자가 임의숫자보다 크면 아래란 문자열 출력
		if (input < 0 || input > 100) {
			System.out.println("다시 입력하세용!!");
			input = scanner.nextInt();
		} else {
			while (true) {
				// 1. 1부터 100사이의 임의 숫자를 생성해둡니다.
				count = count + 1;
				System.out.println("    [숫자를 입력하세용!]");
				input = scanner.nextInt();
				int random = (int) (Math.random() * 100);
				if (random > input) {
					System.out.println("[임의숫자] " + random + "  [입력숫자] " + input);
					System.out.println(">> 아래!");
				} else if (random < input) {
					System.out.println("[임의숫자] " + random + "  [입력숫자] " + input);
					System.out.println(">> 위!");
				} else {
					System.out.println("[임의숫자] " + random + "  [입력숫자] " + input);
					System.out.println(">> " + count + "번만에 맞추셨습니다!");
					break;
				}
			}
		}
		

	} // main

} // End
