package com.lx.store;

public class Product {

	// 제품 이름
	public String name;
	// 제품 가격
	int price;
	// 팔린 전체 금액
	int total = 0;

	// 생성자 함수
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

}
