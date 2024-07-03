package com.lx.main;
import com.lx.animal.Dog;
import com.lx.house.House;

public class Main {

	public static void main(String[] args) {

//		Dog dog1 = new Dog();
		Dog dog1 = new Dog("gaga", 1, "1111");
		Dog dog2 = new Dog("nana", 2, "2222");
		Dog dog3 = new Dog("dada", 3, "3333");
		House house = new House(dog1, dog2, dog3);

		System.out.println("> 강아지 몇마리? : " + house.dogs.size());

		for (int i = 0; i < house.dogs.size(); i++) {
			System.out.println("........" + house.dogs.get(i).getName());
		}
		
		System.out.println("> 마지막 강아지 : " + house.dogs.get(house.dogs.size()-1).getName());

		house.run();
		
	}

}
