
public class House {
	String name;

	Person person;
	Dog dog;
	Cat cat;

	House() {
	}

	House(String name) {
		this.name = name;
	}

	House(String name, Person person) {
		this.name = name;
		this.person = person;
	}
	
	House(String name, Person person, Dog dog) {
		this.name = name;
		this.person = person;
		this.dog = dog;
	}
	
	House(String name, Person person, Cat cat) {
		this.name = name;
		this.person = person;
		this.cat = cat;
	}
	
}
