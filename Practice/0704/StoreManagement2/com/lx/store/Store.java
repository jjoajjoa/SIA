package com.lx.store;

import java.util.ArrayList;

public class Store {

	// 매장 이름
	String name;
	// 고객 리스트
	ArrayList<Customer> customers = new ArrayList<Customer>();
	// 제품 리스트
	ArrayList<Product> products = new ArrayList<Product>();

	// 생성자 함수
	public Store(String name) {
		this.name = name;
	}

	// 고객이 물건 결제하기
	public void pay(Customer customer, Product product) {
		// 고객이 산 물건을 고객에게 추가하기
		customer.items.add(product);
		// 고객이 산 총 금액에 합산하기
		customer.total = customer.total + product.price;
		// 제품이 팔린 총 금액에 합산하기
		product.total = product.total + product.price;
	}

}
