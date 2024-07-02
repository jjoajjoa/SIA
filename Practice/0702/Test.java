import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		/* 객체 생성 */
		Person person1 = new Person("길동");
		House house1 = new House("조선저잣거리", person1);
		System.out.println(">> " + house1.name + house1.person.name);

		Person person2 = new Person("느리");
		Dog dog = new Dog("부추", 11);
		House house2 = new House("의정부", person2, dog);
		System.out.println(">>> " + house2.name + house2.person.name + 
							house2.dog.name + house2.dog.age);
		
		Person person3 = new Person("르미");
		Cat cat = new Cat("쪼랭", 6);
		House house3 = new House("영등포", person3, cat);
		System.out.println(">>>> " + house3.name + house3.person.name + 
							house3.cat.name + house3.cat.age);

		
		ArrayList<Person> personList = new ArrayList<Person>();
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		System.out.println(personList.get(1));
	}

}
