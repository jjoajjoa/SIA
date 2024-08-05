import java.util.ArrayList;

public class Test02 {

	public static void main(String[] args) {

		/*
		- 1.1부터 999까지의 100개의 임의의 수로 이루어진 배열을 생성하는 함수를 호출하여 배열을 생성한다.
		- 2.인덱스가 홀수인 수들을 출력하는 함수
		- 3.배열의 수들의 합을 반환하는 함수
		- 4.가장 작은 수의 위치(인덱스)를 반환하는 함수
		- 5.3의 배수만을 새로운 배열에 복사하여 리턴하는 함수
		option!	- 배열의 수들을 한 줄에 10개씩 출력하는 함수, 이때 각 수들은 줄이 맞춰져야 함
		option!	- 5번은 List Collection API를 사용하는 것이 더 적절한다.
		 */

		int[] list = makeList(); // 임의의 100까지 수
//		System.out.println(list[1]); //test
		printOdd(list); // 인덱스가 홀수
		System.out.println(sumNum(list));; // 배열총합
		System.out.println(smallNum(list));; // 제일작은값의위치
		System.out.println(threeList(list)); // 3의배수
		printTen(list); // 한줄에 10개씩
		
	} // main

	// 1.1부터 999까지의 100개의 임의의 수로 이루어진 배열을 생성하는 함수를 호출하여 배열을 생성한다.
	static int[] makeList() {
		int[] list = new int[99];
		for (int i = 0; i < list.length; i++) {
			list[i] = (int) (Math.random() * 100);
		}
		return list;
	}

	// 2.인덱스가 홀수인 수들을 출력하는 함수
	static void printOdd(int[] list) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] % 2 == 1) {
				System.out.print(list[i] + " ");
			}
		}
	}

	// 3.배열의 수들의 합을 반환하는 함수
	static int sumNum(int[] list) {
		int total = 0;
		for (int i = 0; i < list.length; i++) {
			total += list[i];
		}
		return total;
	}

	// 4.가장 작은 수의 위치(인덱스)를 반환하는 함수
	static int smallNum(int[] list) {
		int small = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] > list[small]) {
				small = i;
			}
		}
		return small;
	}

	// 5.3의 배수만을 새로운 배열에 복사하여 리턴하는 함수
	static ArrayList threeList(int[] list) {
		ArrayList threeArray = new ArrayList();
		for (int i = 0; i < list.length; i++) {
			if (list[i] % 3 == 0) {
				threeArray.add(list[i]);
			}
		}
		return threeArray;
	}

	// option! 배열의 수들을 한 줄에 10개씩 출력하는 함수
	static void printTen(int[] list) {
        for (int i = 0; i < list.length; i++) {
            // 1의 자리 숫자일 때 앞에 0을 붙여 출력
            if (list[i] < 10) {
                System.out.print("0" + list[i] + " ");
            } else {
                System.out.print(list[i] + " ");
            }
            // 10개마다 줄바꿈
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println(); 
    }

} //End
