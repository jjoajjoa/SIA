import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.lx.store.Customer;
import com.lx.store.Product;
import com.lx.store.Store;

public class Main {

	public static void main(String[] args) {

		Store store = new Store("굿투씨유");
		Customer customer1 = new Customer("김고객", 1, "1111");
		Customer customer2 = new Customer("이고객", 2, "2222");
		Customer customer3 = new Customer("박고객", 3, "3333");
		Product product1 = new Product("과자1", 1000);
		Product product2 = new Product("과자2", 2000);
		Product product3 = new Product("과자3", 3000);

		// 물건 사기
		store.pay(customer1, product1);
		store.pay(customer1, product2);
		store.pay(customer2, product3);
		store.pay(customer3, product2);
		// 오늘 날짜
		Date now = new Date();
		SimpleDateFormat simpleFormat = new SimpleDateFormat("YYYY/MM/dd");
		String today = simpleFormat.format(now);
		// 어제 날짜
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(calendar.DATE, -1);
		String yesterday = simpleFormat.format(calendar.getTime());
		// 오늘 팔린 물건들을 해시에 저장하기
		// 날짜가 키, 팔린 물건들이 벨류
		store.dayToSoldProductList.put(yesterday, customer1.purchase);
		store.dayToSoldProductList.put(today, customer2.purchase);
		store.dayToSoldProductList.put(today, customer3.purchase);
		// 날짜 별 팔린 총 금액 저장하기
		store.dayToTotal.put(yesterday, 10000);
		store.dayToTotal.put(today, 30000);
//		System.out.println(".......Test......" + store.dayToTotal);

		for (String key : store.dayToSoldProductList.keySet()) {
			System.out.println(">> 날짜: " + key);
			ArrayList<Product> soldProducts = store.dayToSoldProductList.get(key);
			System.out.print("팔린 물건: ");
			for (Product product : soldProducts) {
				System.out.print(product.getName() + " ");
			}
			if (key.equals(today)) {
				System.out.println("\n오늘 매출: " + store.sellingToday + "원\n");
			} else if (key.equals(yesterday)) {
				System.out.println("\n어제 매출: " + store.sellingToday + "원\n");
			}
		}

//		for (String key : store.dayToSoldProductList.keySet()) {
//            System.out.println("날짜: " + key);
//            ArrayList<Product> soldProducts = store.dayToSoldProductList.get(key);
//            System.out.print("팔린 물건: ");
//            for (Product product : soldProducts) {
//                System.out.print(product + " ");
//            }
//            System.out.println();
//        }

//		for (String key :store.dayToSoldProductList.keySet()) {
//			System.out.println("날짜: " + key + ", 팔린 물건: " + store.dayToSoldProductList.get(key));
//		}

//		for (String key : store.dayToSoldProductList.keySet()) { // 이름만 여러게 뽑아옴
//			ArrayList<Product> value = store.dayToSoldProductList.get(key);
//			System.out.println("키: " + key + ", 값: " + store.dayToSoldProductList.get(value));
//		}

//		// customer1이 산 총 금액
//		System.out.println(">> " + customer1.getName() + "님, 총 " + customer1.totalPrice + "원");
//		// customer1의 주문내역
//		System.out.println(">> 주문제품 갯수: " + customer1.purchase.size());
//		for (int i = 0; i < customer1.purchase.size(); i++) {
//			System.out.println("    " + customer1.purchase.get(i).name);
//		}

	} // main

}
