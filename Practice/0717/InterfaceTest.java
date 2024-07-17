import java.util.List;

public class InterfaceTest {
	public static void main(String[] args) {
		List list;
	}
}


// interface: 순전히 메서드를 선언하는 용도로 사용
interface MyInterface {
	public abstract void print(); // public abstract가 디폴트로 적용됨

	// {바디}가 있는 것: define 정의했다
	// {바디}가 없는 것: declare 선언했다 > 실제 호출되었을 때 실행되는 내용이 없음
//	void write() {} // 그래서 얘는 에러가 남
	void write(); // {바디}가 없어야 함
	
//	MyInterface my = new Interface(); // 인터페이스는 객체 생성이 안됨!
//	MyInterface my = new MyInterface() { // 그래서이런 방법으로 사용해줄 수 있음
//		@Override
//		public void write() { }
//		@Override
//		public void print() { }
//	};
}


class MyInterfaceImpl implements MyInterface {
// MyInterface에서 선언해준 메서드들을 여기서 구현해줌
	@Override
	public void print() { }
	@Override
	public void write() { }
}