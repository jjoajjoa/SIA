public class ExceptionTest {

	public static void main(String[] args) {
		try {
			System.out.println("start");
			print(5);
			System.out.println("after");
		} catch (Exception e) { // Exception객체생성를 참조하는 e
			System.out.println("catch");
			System.out.println(e.getMessage());
		} finally {
			System.out.println("finally");
		}
		// 컴파일 오류
		// print 메서드가 throw절로 정의되어 있어서
		// 그 예외를 처리하지 않으면 컴파일이 안된다.
		// 어캐해야하는데
		// throw절로 처리하기
		// try~catch로 처리하기
	}

	private static void print(int count) throws Exception {
		if (count < 0)
			throw new Exception("음수는 안돼욧"); // Exception객체생성
		System.out.println("after if");
		for (int i = 0; i < count; i++) {
			System.out.println("hello");
		}
	}

}