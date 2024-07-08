package com.lx.store;

import java.util.ArrayList;
import java.util.HashMap;

public class Store {

	// 매장 이름과 매출
	String name;
	public int sellingToday = 0;
	// 고객들, 제품들
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<Product> products = new ArrayList<Product>();
	// 날짜 별 팔린 제품들(오늘 팔린 물건)
	public HashMap<String, ArrayList<Product>> dayToSoldProductList = new HashMap<String, ArrayList<Product>>();
	// 날짜 별 팔린 총 금액
	public HashMap<String, Integer> dayToTotal = new HashMap<String, Integer>();

	public Store(String name) {
		this.name = name;
	}

	public void pay(Customer customer, Product product) {
		// 고객이 산 물건 추가하기
		customer.purchase.add(product);
		// 고객이 산 총 금액에 합산하기
		customer.totalPrice = customer.totalPrice + product.price;
		// 제품이 팔린 총 금액에 계산하기
		product.sellingTotal = product.sellingTotal + product.price;
		this.sellingToday += product.sellingTotal;
	}

}
