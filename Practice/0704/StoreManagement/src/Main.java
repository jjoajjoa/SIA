
public class Main {

	public static void main(String[] args) {
		
		Store store = new Store("JJoajjoa");
		Customer customer1 = new Customer("김고객", 1, "111");
		Customer customer2 = new Customer("이고객", 2, "222");
		Customer customer3 = new Customer("박고객", 3, "333");
		Customer customer4 = new Customer("최고객", 4, "444");
		store.setCustomer(customer1);
		store.setCustomer(customer2);
		store.setCustomer(customer3);
		store.setCustomer(customer4);
		Product product1 = new Product("gaga", 1000);
		Product product2 = new Product("nana", 2000);
		Product product3 = new Product("dada", 3000);
		Product product4 = new Product("lala", 4000);
		store.setProduct(product1);
		store.setProduct(product2);
		store.setProduct(product3);
		store.setProduct(product4);

		System.out.println("> 매장 안 고객 수: " + store.getCustomers().size());
		System.out.println("> 매장 안 제품 수: " + store.getProducts().size());

		store.pay(customer2, product1);

		System.out.println("\n  [우리 매장 " + store.getName() + " 고객 리스트]");
		for (Customer customer : store.getCustomers()) {
			System.out.println(customer);
		}
		
		System.out.println("\n  [우리 매장 " + store.getName() + " 고객 리스트]");
//		for ()
		
		System.out.println("\n  [고객 별 장바구니]");
		for (int i = 0; i < store.products.size(); i++) {
            Product customer = store.products.get(i);
            System.out.println(customer.getName() + " || " + customer.name);
        }
		
		System.out.println("\n  [우리 매장 " + store.getName() + " 총 매출액]");
		
//		System.out.println(customer2.calculateTotalPrice());
//		System.out.println(customer3.calculateTotalPrice());

	}

}
