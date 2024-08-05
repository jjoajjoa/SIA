package com.lx.store;

import java.util.ArrayList;

public class Customer {

	// 고객 이름
	String name;
	// 고객 나이
	int age;
	// 고객 전화번호
	String mobile;
	// 내가 산 제품들
	public ArrayList<Product> items = new ArrayList<Product>();
	// 내가 산 총 금액
	public int total = 0;

	// 생성자 함수
	public Customer(String name, int age, String mobile) {
		this.name = name;
		this.age = age;
		this.mobile = mobile;
	}

	// name 변수상자의 값 가져오기
	public String getName() {
		return this.name;
	}

}
