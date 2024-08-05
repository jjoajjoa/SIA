package practicePerson;

public class PersonTest {
	public static void main(String[] args) {
		Person ps1 = new Person();
		ps1.selfIntroduce();
		Person ps2 = new Person(3, "철수");
		ps2.selfIntroduce();
		System.out.println(Person.getPopulation());
	}
}

class Person {
	static int numberOfPersons;
	
	int age;
	String name;
	
	Person() {
		this.age = 12;
		this.name = "Anonymous";
		numberOfPersons++;
	}

	Person(int age, String name) {
		this.age = age;
		this.name = name;
		numberOfPersons++;
	}
	
	void selfIntroduce() {
		System.out.println("내 이름은 " + name + "이며, 나이는 " + age + "입니다.");
	}
	
	static int getPopulation() {
		return numberOfPersons;
	}
}