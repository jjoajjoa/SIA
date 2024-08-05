package com.lx.store;

public class Product {

	public static String totalPrice;
	public String name;
	public int price;
	
	// 팔린 전체 금액
	public int sellingTotal = 0;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}
	
}