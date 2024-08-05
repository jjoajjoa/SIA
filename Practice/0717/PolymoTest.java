import java.util.Date;

public class PolymoTest {

	public static void main(String[] args) {
		// Overload 중복정의
		System.out.println('1');
		System.out.println("1");
		
		// Override 재정의
		Object obj = new Object(); // Object 클래스: 모든 자바 클래스의 최상위 클래스
		System.out.println(obj.toString());
		Date date = new Date();
		System.out.println(date.toString());
	}

}
