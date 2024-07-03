package com.lx.main;

import java.util.ArrayList;

import com.lx.animal.Dog;
import com.lx.house.House;

public class Main {

	public static void main(String[] args) {

//		Dog dog1 = new Dog();
		House house = new House();
		Dog dog1 = new Dog("gaga", 1, "1111");
		house.setDog(dog1);
		Dog dog2 = new Dog("nana", 2, "2222");
		house.setDog(dog2);
		Dog dog3 = new Dog("dada", 3, "3333");
		house.setDog(dog3);
//		House house = new House(dog1, dog2, dog3);

		ArrayList<Dog> dogList = house.getDogs();
		int dogListSize = dogList.size();

//		System.out.println("> 강아지 몇마리? : " + house.dogs.size());
		System.out.println("> 강아지 몇마리? : " + dogListSize);

		for (int i = 0; i < dogListSize; i++) {
			System.out.println("........" + dogList.get(i).getName() + " || " + dogList.get(i).getAge() + " || "
					+ dogList.get(i).getPhone());
		}

		System.out.println("> 마지막 강아지 : " + dogList.get(dogListSize - 1).getName());

		house.run();

	}

}