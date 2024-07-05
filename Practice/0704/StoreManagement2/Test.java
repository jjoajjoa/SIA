import com.lx.store.Customer;
import com.lx.store.Product;
import com.lx.store.Store;

public class Test {

	public static void main(String[] args) {

		// 매장 만들기
		Store store1 = new Store("강남역");
		Store store2 = new Store("서울역");

		// 고객 만들기
		Customer customer1 = new Customer("홍길동1", 21, "010-1111-1111");
		Customer customer2 = new Customer("홍길동2", 22, "010-2222-2222");

		// 제품 만들기
		Product product1 = new Product("Benz", 10000);
		Product product2 = new Product("BMW", 25000);

		// 고객이 제품을 결제함
		store1.pay(customer1, product1);
		store1.pay(customer1, product2);
		store2.pay(customer2, product2);

		// 콘솔창에 출력 //
		// 첫번째 고객이 물건을 산 총 금액
		System.out.println(">> 고객 " + customer1.getName() + " : 총 " + customer1.total + "원");
		// 첫번째 고객이 산 물건들 리스트
		System.out.println("> 제품 갯수 : " + customer1.items.size());
		for (int i = 0; i < customer1.items.size(); i++) {
			System.out.println("    제품 " + i + " : " + customer1.items.get(i).name);
		}
	}

}
