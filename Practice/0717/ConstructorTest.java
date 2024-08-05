
public class ConstructorTest {

	public static void main(String[] args) {
		Circle circle1 = new Circle();
		// circle1: Circle 타입의 지역변수 (생성된 객체의 주소값만을 저장할 수 있음)
		Circle circle2 = new Circle(10, 10);
		
//		Shape shape = new Shape(); // 추상클래스는 객체를 생성할 수 없음
		Shape shape; // 변수의 타입으로는 사용 가능함
		Shape shapeTest = new Circle(1, 1); // 그래서 이렇게 쓰는게 가능
		shapeTest.print(); // Circle.print();: Circle 객체로 생성했기 때문에 
	}

}

abstract class Shape {
	int x, y; // Shape 클래스의 멤버변수
	// 메서드를 선언(declare) -> 하위클래스에서 구현하세용
	abstract void print();
	// Shape 클래스를 상속받은 Circle 클래스에서 print 메서드를 구현해야함
}

// 하나의 클래스를 힙 영역에 메모리 할당을 받는 것 <- 객체화
class Circle extends Shape {
	Circle() {

	}

	Circle(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	void print() {
		System.out.println("Circle.print();");
	}
}