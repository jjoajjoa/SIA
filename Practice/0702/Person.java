
public class Person {

	String name;
	int age;
	String phone;
	
	Person(String name) {
		this.name = name;
	}
	
	Person(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	
	void introThis() {
		System.out.println("나는 " + this.age + "살 " + this.name + "이야");
		System.out.println("전화번호는" + this.phone + "야");
	}
	
	void intro(String name, int age, String phone) {
		System.out.println("나는 " + age + "살 " + name + "이야");
	}
	
}
