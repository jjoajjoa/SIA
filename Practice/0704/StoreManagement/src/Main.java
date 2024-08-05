
public class Main {

	public static void main(String[] args) {

		Store store1 = new Store("JJoa");
//		Store store2 = new Store("No.2");
		Customer customer1 = new Customer("김고객", 1, "111");
		Customer customer2 = new Customer("이고객", 2, "222");
		Customer customer3 = new Customer("박고객", 3, "333");
		Customer customer4 = new Customer("최고객", 4, "444");
		store1.addCustomer(customer1);
		store1.addCustomer(customer2);
		store1.addCustomer(customer3);
		store1.addCustomer(customer4);
		Product product1 = new Product("gaga", 1000);
		Product product2 = new Product("nana", 2000);
		Product product3 = new Product("dada", 3000);
		Product product4 = new Product("lala", 4000);
		store1.addProduct(product1);
		store1.addProduct(product2);
		store1.addProduct(product3);
		store1.addProduct(product4);

		System.out.println("> 우리 매장 이 름: " + store1.getName());
		System.out.println("> 매장 안 고객 수: " + store1.getCustomers().size());
		System.out.println("> 매장 안 제품 수: " + store1.getProducts().size());

		/* 한사람 한개씩 결제 */
		store1.pay(customer1, product2);
		store1.pay(customer1, product3);
		store1.pay(customer2, product1);

		System.out.println("\n  [우리 매장 " + store1.getName() + " 고객 리스트]");
		for (Customer customer : store1.getCustomers()) {
			System.out.println(customer);
		}

		for (Customer c : store1.getCustomers()) {
			// 물건을 산 사람만 나오게 하기
			if (c.purchase.size() > 0) {
				System.out.println("\n.......[" + c.name + "님의 장바구니]");
				for (Product p : c.getPurchase()) {
					System.out.println("제품 이름 : " + p.name + " || 가격 : " + p.price + "원");
				}
				// 물건을 산 사람의 총 금액
				System.out.println(">>> 총 " + c.buyPrice + "원");
			}
		}
		
		// 매장의 총 매출
		System.out.println("\n  [우리 매장 " + store1.getName() + " 총 매출]");
		System.out.println(">>> " + Product.totalPrice + "원");		
	}

}
