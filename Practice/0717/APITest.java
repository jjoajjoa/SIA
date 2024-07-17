import java.util.Calendar;
import java.util.Date;

public class APITest {

	public static void main(String[] args) {
		// 문자열
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str1 == str2); //false: 생성된 객체가 서로 다름을 보여줌
		System.out.println(str1.equals(str2)); //true: 문자열을 비교할때는 equals() 메서드를 사용!
		/* str이라는 변수는 메모리를 할당받는것으로 끝 -> 힙영역에 저장되어있는 String 객체의 주소값을 저장 */
		String str3 = "Hello";
		String str4 = "Hello";
		System.out.println(str3 == str4); // 근데 이렇게하면 또 true 나옴 
		
		// 배열
		String str = "iphone16:1000000:Apple";
		String[] result = str.split(":");
		for (String s : result) {
			System.out.println(s);
		}
		System.out.println(result.length);
		/* 사용된 API: String, split() */

		// 숫자
		int count = Integer.MAX_VALUE;
		System.out.println(count); // 2147483647 == 2^31 -1
		System.out.println(Integer.toBinaryString(count)); //1111111111111111111111111111111(31자리)
		count = count + 1;
		System.out.println(count); // -2147483648 == -2^31
		System.out.println(Integer.toBinaryString(count)); //10000000000000000000000000000000(32자리)
		int countM = -1;
		System.out.println(Integer.toBinaryString(countM)); //11111111111111111111111111111111(32자리)
		/* 사용된 API: Integer, MAX_VALUE, toBinaryString() */

		// 타입변환
		String price = "200";
		int priceInt = Integer.parseInt(price);
		/* 사용된 API: Integer, parseInt() */

		// 오늘날짜
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		System.out.println(today.toString());
		/* 사용된 API: Calendar, getInstance(), getTime(), Date, toString() */
	}

}
