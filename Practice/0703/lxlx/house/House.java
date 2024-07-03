package com.lx.house;

import java.util.ArrayList;
import com.lx.animal.Dog;

public class House {
	String name;

	ArrayList<Dog> dogs = new ArrayList<Dog>();

//	public House(Dog dog1, Dog dog2, Dog dog3) {
//		dogs.add(dog1);
//		dogs.add(dog2);
//		dogs.add(dog3);
//	}

	public void run() {
		if (dogs.size() == 0) {
			System.out.println("강아지가 없어용");
		} else {
			System.out.println("> 첫번째 강아지: " + dogs.get(0).getName());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Dog> getDogs() {
		return dogs;
	}

	public void setDog(Dog dog) {
		this.dogs.add(dog);
	}

	public void setDogs(ArrayList<Dog> dogs) {
		this.dogs = dogs;
	}
}