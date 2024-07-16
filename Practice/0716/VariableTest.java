
public class VariableTest {

	public static void main(String[] args) {
		Dog dog1 = new Dog();
		Dog dog2 = new Dog();
		Dog dog3 = new Dog();
		// 객체 3개가 힙영역에 생성 -> 생성된 객체가 각각의 변수를 참조하고 있음
		// dog1, dog2, dog3은 main메서드 안에서 만들어진 로컬변수
		dog1.age = 5;
		dog2.age = 10;
		// 힙영역에 생성된 변수가 갖고있는 변수가 바뀌는 것
		dog1.name = "Puppy";
//		Dog.name = "Happy"; // 원래는 객체(클래스) 자체를 사용해줌
		System.out.println(dog2.name); // Puppy가 출력됨
		dog2.age = 10;
		System.out.println(dog2.age); // 10이 출력됨
	}

}

class Dog {
	int age; // 멤버변수 객체변수 instance variable : 객체를 생성하여 참조하기 때문에
	static String name; // 스태틱이 붙어서 클래스변수(멤버변수 중 한 종류) // Dog로 생성된 모든 객체가 공유하는 변수
	String mobile;
	
	void print() {
		int age; // 로컬변수 : 메서드 안에서 선언됨 - print 함수 안에서만 사용가능
		mobile = "12134"; // 클래스 안에서 선언된 멤버변수 사용
		for(int i = 0;;) {} // 임시변수 : for문 안에서만 사용
	}
}