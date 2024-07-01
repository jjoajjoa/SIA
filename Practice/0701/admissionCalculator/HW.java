
//입장료 계산기
import java.util.Scanner;

public class HW {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int adult = 20000;
		int kid = 9900;
		System.out.print("어른: ");
		int adultNum = sc.nextInt();
		System.out.print("아이: ");
		int kidNum = sc.nextInt();

		int totalNum = adultNum + kidNum;
		int total = adultSum(adult, adultNum) + kidSum(kidNum, kid);
		String strTotal = String.format("%, d", total);
		int discountTotal = (int) (total * 0.8);
		String strDisTotal = String.format("%, d", discountTotal);

		if (totalNum > 4) {
			System.out.print("입장료: " + strDisTotal);
		} else {
			System.out.println("입장료: " + strTotal);
		}

		sc.close(); 

	} // main

	static int adultSum(int adult, int adultNum) { // 어른총값
		return adult * adultNum;
	}

	static int kidSum(int kid, int kidSum) { // 아이총값
		return kid * kidSum;
	}

} // end