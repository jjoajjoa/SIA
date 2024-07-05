import java.util.ArrayList;

public class Store {
	
	static int totalPayment;
	
	String name;
	ArrayList<Customer> customers = new ArrayList<Customer>(); //고객명당
	ArrayList<Product> products = new ArrayList<Product>(); //제품리스트
//	ArrayList<> payList = new ArrayList<>();

	/* 매장 이름 */
	Store(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* 고객array */
	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	/* 제품array */
	public void addProduct(Product product) {
		this.products.add(product);
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	/* 제품 결제 */
	void pay(Customer customer, Product product) {
		customer.getPurchase().add(product);
		customer.buyPrice += product.price;
		product.totalPrice += product.price;
	}

}
