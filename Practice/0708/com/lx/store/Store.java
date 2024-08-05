package com.lx.store;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Store {

	// 매장 이름과 매출
	String name;
	public int sellingToday = 0;

	// 고객들, 제품들
	// ArrayList<Customer> customers = new ArrayList<Customer>();
	// ArrayList<Product> products = new ArrayList<Product>();

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

		// 오늘 팔린 제품들
//		ArrayList<Product> todayList = new ArrayList<Product>();
//		todayList.add(product);
//		Date now = new Date();
//		SimpleDateFormat simpleFormat = new SimpleDateFormat("YYYY/MM/dd");
//		String today = simpleFormat.format(now);
//		dayToSoldProductList.put(today, todayList);
//
//		// 오늘 팔린 제품들의 총 금액
//		for (int i = 0; i < todayList.size(); i++) {
//			this.sellingToday += todayList.get(i).price;
//		}
//		dayToTotal.put(today, sellingToday);

		//LDB
		calcDaySellInfo(product);
	}

	//LDB
	public void calcDaySellInfo(Product product) {
		ArrayList<Product> todayList = new ArrayList<Product>();
		Date now = new Date();
		SimpleDateFormat simpleFormat = new SimpleDateFormat("YYYY/MM/dd");
		String today = simpleFormat.format(now);
		
		if(dayToSoldProductList.get(today) == null) {
			todayList.add(product);
			dayToSoldProductList.put(today, todayList);
		} else {
			dayToSoldProductList.get(today).add(product);
		}
		
		int totalAmount = 0;
		for(int i = 0 ; i < dayToSoldProductList.get(today).size(); i++) {
			totalAmount += dayToSoldProductList.get(today).get(i).price;
		}
		
		dayToTotal.put(today, totalAmount);
	}
}