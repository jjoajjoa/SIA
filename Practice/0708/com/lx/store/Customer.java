package com.lx.store;

import java.util.ArrayList;

public class Customer {

	String name;
	int age;
	String mobile;

	// 내가 산 제품들 (한 고객이 산 제품들을 넣어둘 어레이)
	public ArrayList<Product> purchase = new ArrayList<Product>();
	// 내가 산 총 금액
	public int totalPrice = 0;
	

	public Customer(String name, int age, String mobile) {
		this.name = name;
		this.age = age;
		this.mobile = mobile;
	}
	
	public String getName() {
		return this.name;
	}

}